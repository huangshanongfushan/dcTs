package com.duplicall.task;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.duplicall.common.Constant;
import com.duplicall.dao.device.IDeviceDao;
import com.duplicall.dao.device.impl.DeviceDaoImpl;
import com.duplicall.dao.message.IMessageDao;
import com.duplicall.dao.message.impl.MessageDaoImpl;
import com.duplicall.dao.ngp.IPartyDao;
import com.duplicall.dao.ngp.ISwxCallDao;
import com.duplicall.dao.ngp.impl.PartyDaoImpl;
import com.duplicall.dao.ngp.impl.SwxCallDaoImpl;
import com.duplicall.entities.CallDetail;
import com.duplicall.entities.CallMessage;
import com.duplicall.entities.TsConfig;
import com.duplicall.pojo.Party;
import com.duplicall.service.callDetail.ICallDetail;
import com.duplicall.service.callDetail.impl.CallDetailImpl;

public class MyTask extends java.util.TimerTask {
	private ICallDetail detailImpl = new CallDetailImpl();
	//
	private ISwxCallDao swxCallDaoImpl = new SwxCallDaoImpl();
	//
	private IPartyDao partyDaoImpl = new PartyDaoImpl();

	private IDeviceDao deviceDaoImpl = new DeviceDaoImpl();

	private IMessageDao messageDaoImpl = new MessageDaoImpl();
	static Logger log = Logger.getLogger(MyTask.class);

	@Override
	public void run() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 当前时间
		Date date = new Date();
		String startTime = null;
		try {
			startTime = this.readConfig(new File(Constant.CONPATH))
					.getLastTime();
		} catch (Exception e1) {
			e1.printStackTrace();
			log.error("read config file fails");
			return;
		}
		// String startTime = "2015-03-23 14:22:34";
		String endTime = sdf.format(date);
		// String endTime = "2015-03-23 14:22:35";
		List<CallDetail> detailList = null;
		// 写记录最后备份时间
		File file = new File("C://macaw/config/avayaConfig.xml");
		try {
			this.updateConfig(file, endTime);
		} catch (IOException e1) {
			log.error("read config file fails");
			return;
		}
		try {
			detailList = detailImpl.getCallDetail(startTime, endTime);
			log.info(startTime + "--" + endTime + " calldetails:" + detailList);
		} catch (Exception e) {
			log.error(e.getMessage()+" query for callDetail error");
			return;
		}
		if(detailList==null||detailList.size()<1){
			return;
		}
		// 遍历需要处理的通话
		for (CallDetail callDetail : detailList) {
			String extension = callDetail.getExtention();
			Long deviceId = 0L;
			try {
				if (extension != null) {
					deviceId = deviceDaoImpl.getDeviceId(extension);
				}
			} catch (Exception e) {
				log.error("query for device Id fail!");
				continue;
			}
			// 主叫方信息
			Party callingParty = new Party();
			// callingParty.setIpAddress(callDetail.getAgent());
			callingParty.setGenericDigits(callDetail.getCalledParty());
			// 被叫方信息
			Party calledParty = new Party();
			// calledParty.setIpAddress(callDetail.getOrigCalled());
			calledParty.setGenericDigits(callDetail.getOrigCalled());
			// 应答方
			Party answeringParty = new Party();
			// calledParty.setIpAddress(callDetail.getOrigCalled());
			answeringParty.setGenericDigits(callDetail.getOrigCalled());
			List<Object> callIdList = null;
			try {
				// call发生的时间
				String createTime = callDetail.getCreateTime();
				SimpleDateFormat df = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss");
				Date fromDate = df.parse(createTime);
				Date endDate = df.parse(createTime);
				// 取前后一秒
				long fromTimeLong = fromDate.getTime() - 1000;
				long endTimeLong = endDate.getTime() + 1000;
				Date fromLongDate = new Date(fromTimeLong);
				Date endLongDate = new Date(endTimeLong);
				String fromT = df.format(fromLongDate);
				String endT = df.format(endLongDate);
				// 获取这一时刻的ngp中call的数据，考虑到处理时间的效率
				callIdList = swxCallDaoImpl.getCallIdByCaseId(deviceId + "",
						fromT, endT);
				if(callIdList==null||callIdList.size()<1){
					continue;
				}
				// partyDaoImpl.up
			} catch (NumberFormatException e) {
				log.error(e.getMessage());
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			// 处理每个通话
			for (Object object : callIdList) {
				// 获取每个call的Id
				Long callid = (Long) object;
				log.info("to Deal with the call "+callid+":"+callDetail);
				try {
					// 修改被叫方
					partyDaoImpl.updateCalledParty(callid, calledParty);
					log.info("update calledParty:" + calledParty);
					// 修改主叫方
					partyDaoImpl.updateCallingParty(callid, callingParty);
					log.info("update callingParty:" + callingParty);
					// 修改硬答方
					partyDaoImpl.updateAnsweringParty(callid, answeringParty);
					log.info("update answeringParty:" + answeringParty);

					// 下面这几行是转换主被叫
					long messageId = messageDaoImpl.getMessageId(callid);
					if (messageId < 1) {
						log.error("no messageId");
						continue;
					}
					CallMessage message = messageDaoImpl
							.getOrginationMessage(messageId);
					if (message == null) {
						log.error("no message");
						continue;
					}
					messageDaoImpl.insertOriginationMessage(message);
					log.info("insert callingParty:" + message);
					messageDaoImpl.deleteTeminalMessage(messageId);
					log.info("delete terminal table ");
					swxCallDaoImpl.updateLaesMessages(callid);
					log.info("update derection");
				} catch (Exception e) {
					log.error("修改主被叫错误:"+e.getMessage());
					continue;
				}
			}
		}

	}
	
	public  void updateConfig(File file, String endtime) throws IOException {
		
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element rootElement = document.getRootElement();
		Element lastTimeElement = rootElement.element("lasttime");
		lastTimeElement.setText(endtime);
		XMLWriter writer = new XMLWriter(new FileOutputStream(file));
		writer.write(document);
		writer.close();
	}
	
	/**
	 * 读取配置文件
	 * 
	 * @param file
	 * @return
	 */
	public  TsConfig readConfig(File file) throws Exception {
		SAXReader saxReader = new SAXReader();
		Document matchFiledocument = null;
		matchFiledocument = saxReader.read(file);
		Element rootElement = matchFiledocument.getRootElement();
		String enable = rootElement.attributeValue("enable");
		Element lastTimeElement = rootElement.element("lasttime");
		String lasttime = lastTimeElement.getTextTrim();
		Element freElement = rootElement.element("frequency");
		long interval = Long.parseLong(freElement.getTextTrim());
		TsConfig tsConfig = new TsConfig();
		tsConfig.setEnable(enable);
		tsConfig.setInterval(interval);
		tsConfig.setLastTime(lasttime);
		return tsConfig;
	}

}