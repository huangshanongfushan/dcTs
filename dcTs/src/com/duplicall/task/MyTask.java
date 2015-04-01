package com.duplicall.task;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.duplicall.common.ConfigUtil;
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
import com.duplicall.exception.ServiceException;
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
		// 当前时间
		Long end = System.currentTimeMillis();
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(end);
		Date date = c.getTime();
		String startTime = null;
		try {
			startTime = ConfigUtil.readConfig(new File(Constant.CONPATH))
					.getLastTime();
		} catch (Exception e1) {
			log.error("read config file fails");
			return;
		}
		// String startTime = "2015-03-23 14:22:34";
		@SuppressWarnings("deprecation")
		String endTime = date.toLocaleString();
		// String endTime = "2015-03-23 14:22:35";
		List<CallDetail> detailList = null;
		// 写记录最后备份时间
		File file = new File("C://macaw/config/avayaConfig.xml");
		try {
			ConfigUtil.updateConfig(file, endTime);
		} catch (IOException e1) {
			log.error("read config file fails");
			return;
		}
		try {
			detailList = detailImpl.getCallDetail(startTime, endTime);
			log.info(startTime + "--" + endTime + " calldetails:" + detailList);
		} catch (ServiceException e) {
			log.warn(e.getMessage());
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
				log.warn(e.getMessage());
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
				try {
					Date fromDate = df.parse(createTime);
					Date endDate = df.parse(createTime);
					// 取前后一秒
					long fromTimeLong = fromDate.getTime() - 1000;
					long endTimeLong = endDate.getTime() + 1000;
					Date fromLongDate = new Date(fromTimeLong);
					Date endLongDate = new Date(endTimeLong);
					String fromT = df.format(fromLongDate);
					String endT = df.format(endLongDate);
					// 获取这一时刻的ngp中call的数据，考虑到处理时间的效率，给了两秒的时间间隔，正常情况下应该只有一条数据
					callIdList = swxCallDaoImpl.getCallIdByCaseId(
							deviceId + "", fromT, endT);
				} catch (ParseException e) {
					log.warn(e.getMessage());
				}
				// partyDaoImpl.up
			} catch (NumberFormatException e) {
				log.warn(e.getMessage());
			} catch (ServiceException e) {
				log.warn(e.getMessage());
			}
			// 处理每个通话
			for (Object object : callIdList) {
				// 获取每个call的Id
				Long callid = (Long) object;
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
					if(messageId<1){
						continue;
					}
					CallMessage message = messageDaoImpl
							.getOrginationMessage(messageId);
					if (message == null) {
						continue;
					}
					messageDaoImpl.insertOriginationMessage(message);
					log.info("insert callingParty:" + message);
					messageDaoImpl.deleteTeminalMessage(messageId);
					log.info("delete terminal table ");
					swxCallDaoImpl.updateLaesMessages(callid);
					log.info("update derection");

				} catch (Exception e) {
					log.warn(e.getMessage());
					continue;
				}
			}
		}

	}

}