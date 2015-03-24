package com.duplicall.task;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.duplicall.dao.device.IDeviceDao;
import com.duplicall.dao.device.impl.DeviceDaoImpl;
import com.duplicall.dao.ngp.IPartyDao;
import com.duplicall.dao.ngp.ISwxCallDao;
import com.duplicall.dao.ngp.impl.PartyDaoImpl;
import com.duplicall.dao.ngp.impl.SwxCallDaoImpl;
import com.duplicall.entities.CallDetail;
import com.duplicall.exception.ServiceException;
import com.duplicall.pojo.Party;
import com.duplicall.service.callDetail.ICallDetail;
import com.duplicall.service.callDetail.impl.CallDetailImpl;

public class MyTask extends java.util.TimerTask {
	public static String filePath = "C://macaw/config/avayaConfig.xml";
	private ICallDetail detailImpl = new CallDetailImpl();
	//
	private ISwxCallDao swxCallDaoImpl = new SwxCallDaoImpl();

	//
	private IPartyDao partyDaoImpl = new PartyDaoImpl();

	private IDeviceDao deviceDaoImpl = new DeviceDaoImpl();

	@Override
	public void run() {
		Long end = System.currentTimeMillis();
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(end);
		Date date = c.getTime();
		// String startTime = readConfig(new File(filePath));
		String startTime = "2015-03-23 14:50:22";
		@SuppressWarnings("deprecation")
		String endTime = date.toLocaleString();
		List<CallDetail> detailList = null;
		try {
			detailList = detailImpl.getCallDetail(startTime, endTime);
			System.out.println("detailList："+detailList);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 遍历需要处理的通话
		for (CallDetail callDetail : detailList) {
			String extension = callDetail.getExtention();
			Long deviceId = 0L;
			try {
				if (extension != null) {
					deviceId = deviceDaoImpl.getDeviceId(extension);
					System.out.println(deviceId+":::"+extension);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 主叫方信息
			Party callingParty = new Party();
			// callingParty.setIpAddress(callDetail.getAgent());
			callingParty.setGenericDigits(callDetail.getCalledParty());
			System.out.println("   ::"+callingParty);
			// 被叫方信息
			Party calledParty = new Party();
			// calledParty.setIpAddress(callDetail.getOrigCalled());
			calledParty.setGenericDigits(callDetail.getOrigCalled());
			System.out.println("   ::"+calledParty);
			//应答方
			Party answeringParty = new Party();
			// calledParty.setIpAddress(callDetail.getOrigCalled());
			answeringParty.setGenericDigits(callDetail.getAnsweringParty());
			List<Object> callIdList = null;
			try {
				callIdList = swxCallDaoImpl.getCallIdByCaseId(deviceId + "",
						startTime, endTime);
				System.out.println("callIdList:"+callIdList);
				// partyDaoImpl.up
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 处理每个通话
			for (Object object : callIdList) {
				// 获取每个call的Id
				Long callid = (Long) object;
				try {
					partyDaoImpl.updateCalledParty(callid, callingParty);
					partyDaoImpl.updateCallingParty(callid, calledParty);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		File file = new File("C://macaw/config/avayaConfig.xml");
		updateConfig(file, endTime);
		// 写记录最后备份时间

	}

	/**
	 * 跟新配置文件，修改最后的更新时间
	 * 
	 * @param file
	 * @param endtime
	 */
	public void updateConfig(File file, String endtime) {
		SAXReader saxReader = new SAXReader();
		Document document = null;
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element rootElement = document.getRootElement();
		rootElement.setText(endtime);
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(file));
			writer.write(document);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取配置文件
	 * 
	 * @param file
	 * @return
	 */
	public static String readConfig(File file) {
		SAXReader saxReader = new SAXReader();
		Document matchFiledocument = null;
		try {
			matchFiledocument = saxReader.read(file);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element rootElement = matchFiledocument.getRootElement();
		return rootElement.getTextTrim();
	}
}