package com.duplicall.smartControl.service.smartControl.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.server.ServerCloneException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import com.duplicall.smartControl.common.util.CommandRegUtil;
import com.duplicall.smartControl.common.util.SmartConLogWriter;
import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.pojo.IP;
import com.duplicall.smartControl.pojo.NetInterCard;
import com.duplicall.smartControl.pojo.Ngx;
import com.duplicall.smartControl.pojo.NgxSmartControl;
import com.duplicall.smartControl.pojo.PBXSmartControl;
import com.duplicall.smartControl.pojo.SmartBoard;
import com.duplicall.smartControl.pojo.SmartControlSystem;
import com.duplicall.smartControl.pojo.User;
import com.duplicall.smartControl.pojo.VoIPSmartControl;
import com.duplicall.smartControl.service.smartControl.ISmartControl;

@Service
public class SmartControlImpl implements ISmartControl {
	@Override
	public SmartControlSystem getSmartControlSystem() throws ServiceException {
		SmartControlSystem controlSystem = new SmartControlSystem();
		// driverMajor信息查询
		String driverMajor = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\" | find /i \"DriverMajor\"";
		controlSystem.setDriverMajor(Integer.parseInt(
				CommandRegUtil.regValue(driverMajor).substring(2), 16)
				+ "");
		SmartConLogWriter.writeLog("-r",
				"driverMajor:" + controlSystem.getDriverMajor());
		// driverBuilder 信息查询
		String driverBuildStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\" | find /i \"DriverBuild\"";
		controlSystem.setDriverBuild(Integer.parseInt(
				CommandRegUtil.regValue(driverBuildStr).substring(2), 16)
				+ "");
		SmartConLogWriter.writeLog("-r",
				"driverBuildStr:" + controlSystem.getDriverBuild());
		// DriverMinor 信息查询
		String driverMinor = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\" | find /i \"DriverMinor\"";
		controlSystem.setDriverMinor(Integer.parseInt(
				CommandRegUtil.regValue(driverMinor).substring(2), 16)
				+ "");
		SmartConLogWriter.writeLog("-r",
				"driverMinor:" + controlSystem.getDriverMinor());

		// driverInternal 信息查询
		String driverInternalStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\" | find /i \"DriverInternal\"";
		controlSystem.setDriverInterval(Integer.parseInt(CommandRegUtil
				.regValue(driverInternalStr).substring(2), 16)
				+ "");
		SmartConLogWriter.writeLog("-r",
				"driverInternalStr:" + controlSystem.getDriverInterval());

		controlSystem.setDriverVersion(controlSystem.getDriverMajor() + "."
				+ controlSystem.getDriverMinor() + "."
				+ controlSystem.getDriverInterval());
		controlSystem.setDcPanelVersion(controlSystem.getDriverVersion()
				+ ".001");
		return controlSystem;
	}

	@Override
	public Object getBoard(String type) throws ServiceException {
		return null;
	}

	public PBXSmartControl getPbxSmartControl(int configurationId) throws ServiceException {
		PBXSmartControl pbxSmartControl = new PBXSmartControl();
		String totalChannelStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"TotalChannels\"";
		pbxSmartControl.setTotalChannels(Integer.parseInt(CommandRegUtil
				.regValue(totalChannelStr).substring(2), 16));
		SmartConLogWriter.writeLog("-r",
				"totalChannelStr:" + pbxSmartControl.getTotalChannels());
		// 以下三個值組成serial number
		String dateCodeStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"DateCode\"";
		String dateCode = CommandRegUtil.regValue(dateCodeStr);
		SmartConLogWriter.writeLog("-r", "dateCode:" + dateCode);
		// pbxSmartControl
		// pbxSmartControl.set
		String assemblyCodeStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\"  | find /i \"AssemblyCode\"";
		String assemblyCode = CommandRegUtil.regValue(assemblyCodeStr);
		SmartConLogWriter.writeLog("-r", "assemblyCode:" + assemblyCode);
		// System.out.println(assemblyCode);
		String serialNumberStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"SerialNumber\"";
		String serialNumberCode = CommandRegUtil.regValue(serialNumberStr);
		SmartConLogWriter
				.writeLog("-r", "serialNumberCode:" + serialNumberCode);
		// 以下三個決定fireware version
		String firmwareMajorStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"FirmwareMajor\"";
		String firmwareMajorCode = CommandRegUtil.regValue(firmwareMajorStr);
		SmartConLogWriter.writeLog("-r", "firmwareMajorCode:"
				+ firmwareMajorCode);
		String firmwareMinorStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"FirmwareMinor\"";
		String firmwareMinorCode = CommandRegUtil.regValue(firmwareMinorStr);
		SmartConLogWriter.writeLog("-r", "firmwareMinorCode:"
				+ firmwareMinorCode);
		String firmwareIntervalStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"FirmwareInternal\"";
		String firmwareIntervalCode = CommandRegUtil
				.regValue(firmwareIntervalStr);
		SmartConLogWriter.writeLog("-r", "firmwareIntervalCode:"
				+ firmwareIntervalCode);
		String tdmEncodingStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"TDMEncoding\"";
		String tdmEncodingCode = CommandRegUtil.regValue(tdmEncodingStr);
		SmartConLogWriter.writeLog("-r", "tdmEncodingCode:" + tdmEncodingCode);
		// GCIStartingIndex 信息抓取
		String gciStrartingIndexStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Parameters\" | find /i \"GCIStartingIndex\"";
		SmartConLogWriter.writeLog("-r", "gciStrartingIndexStr:"
				+ pbxSmartControl.getGciStartIndex());
		// bus No 不确定
		/*
		 * String conigurationIdStr =
		 * "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\Bus4Slot0\" | find /i \"ConfigurationId\""
		 * ; String configurationIdCode =
		 * CommandRegUtil.regValue(conigurationIdStr);
		 * SmartConLogWriter.writeLog("-r", "configurationIdCode:" +
		 * configurationIdCode);
		 */
		pbxSmartControl.setSerialNumber(dateCode + "." + assemblyCode + "."
				+ Integer.parseInt(firmwareIntervalCode.substring(2), 16));
		pbxSmartControl
				.setFirmwareVersion(Integer.parseInt(
						firmwareMajorCode.substring(2), 16)
						+ "."
						+ Integer.parseInt(firmwareMinorCode.substring(2), 16)
						+ "."
						+ Integer.parseInt(firmwareIntervalCode.substring(2),
								16));
		// System.out.println(configurationIdCode);
		// pbxSmartControl.setBoardNumber(Integer.parseInt(configurationIdCode.substring(2),
		// 16));
		String gciIndex = CommandRegUtil.regValue(gciStrartingIndexStr)
				.substring(2);
		pbxSmartControl.setGciStartIndex(gciIndex);
		pbxSmartControl.setTdmEncoding(Long.valueOf(
				tdmEncodingCode.substring(2), 16)
				+ "");
		pbxSmartControl.setBusNo(4);
		pbxSmartControl.setSlotNo(0);
		return pbxSmartControl;
	}

	public VoIPSmartControl getVoIPSmartControl() throws ServiceException {
		VoIPSmartControl voIpSmartControl = new VoIPSmartControl();
		// 查询boarVersion
		String boardVersionStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\BoardServices\\SmrtWrksSrvc\" | find /i \"CurrentVersion\"";
		String boardVersionCode = CommandRegUtil.regValue(boardVersionStr);
		SmartConLogWriter
				.writeLog("-r", "boardVersionCode:" + boardVersionCode);
		voIpSmartControl.setBoardVersion(boardVersionCode);
		// 查询currentBuild
		String currentBuildStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\BoardServices\\SmrtWrksSrvc\" | find /i \"CurrentBuild\"";
		String currentBuildCode = CommandRegUtil.regValue(currentBuildStr);
		SmartConLogWriter
				.writeLog("-r", "currentBuildCode:" + currentBuildCode);
		voIpSmartControl.setBoadrdBuild(currentBuildCode);

		// 网卡一是否生效
		String monitorPor0EnableStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\100\" | find /i \"Mon0Enable\"";
		String monitorPor0EnableCode = CommandRegUtil
				.regValue(monitorPor0EnableStr);
		SmartConLogWriter.writeLog("-r", "monitorPor0EnableCode:"
				+ monitorPor0EnableCode);
		voIpSmartControl.setMonitorPort0Enable(Integer.parseInt(
				monitorPor0EnableCode.substring(2), 16));
		// 网卡信息查询，有几个网卡
		// List<String> nicList = new ArrayList<String>();
		String nicStr = "reg query \"HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\NetworkCards\" | find /i \"NetworkCards\\\"";
		List<String> resultsList = CommandRegUtil.getResultsList(nicStr);
		// List<String> nicDescription = new ArrayList<String>();
		// 遍历，查找每个网卡信息
		List<NetInterCard> netInterCards = new ArrayList<NetInterCard>();
		for (int i = 0; i < resultsList.size(); i++) {
			NetInterCard netInterCard = new NetInterCard();
			String results = resultsList.get(i);
			String description = CommandRegUtil
					.regValue("reg query \"HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\NetworkCards\\"
							+ results + "\" | find /i \"Description\"");
			SmartConLogWriter.writeLog("-r", "monitorPor" + i + "Description:"
					+ description);
			String serviceName = CommandRegUtil
					.regValue("reg query \"HKEY_LOCAL_MACHINE\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\NetworkCards\\"
							+ results + "\" | find /i \"ServiceName\"");
			SmartConLogWriter.writeLog("-r", "monitorPor" + i + "serviceName:"
					+ serviceName);
			netInterCard.setDescription(description);
			netInterCard.setServiceName(serviceName);
			netInterCards.add(netInterCard);
		}
		// 端口0选用的网卡的service name
		String monitorPor0SeleStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\100\" | find /i \"Mon0Select\"";
		String monitorPor0SeleCode = CommandRegUtil
				.regValue(monitorPor0SeleStr);
		SmartConLogWriter.writeLog("-r", "monitorPor0SeleCode:"
				+ monitorPor0SeleCode);

		// 网卡 port1 是否生效
		String monitorPor1EnableStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\100\" | find /i \"Mon1Enable\"";
		String monitorPor1EnableCode = CommandRegUtil
				.regValue(monitorPor1EnableStr);
		SmartConLogWriter.writeLog("-r", "monitorPor1EnableCode:"
				+ monitorPor1EnableCode);
		voIpSmartControl.setMonitorPort1Enable(Integer.parseInt(
				monitorPor1EnableCode.substring(2), 16));
		// port1选用的网卡service name
		String monitorPor1SeleStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\100\" | find /i \"Mon1Select\"";
		String monitorPor1SeleCode = CommandRegUtil
				.regValue(monitorPor1SeleStr);
		SmartConLogWriter.writeLog("-r", "monitorPor1SeleCode:"
				+ monitorPor1SeleCode);

		for (NetInterCard netInterCard : netInterCards) {
			// port0选用的网卡完整信息
			if (monitorPor0SeleCode.equals(netInterCard.getServiceName())) {
				voIpSmartControl.setMonitorPort0Selected(netInterCard);
			}
			// port1选用的网卡完整信息
			if (monitorPor1SeleCode.equals(netInterCard.getServiceName())) {
				voIpSmartControl.setMonitorPort1Selected(netInterCard);
			}
		}
		// voIpSmartControl
		// rtptimeout:
		String rtpEnableStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\100\" | find /i \"RTP_Enable\"";
		String rtpEnableCode = CommandRegUtil.regValue(rtpEnableStr);

		voIpSmartControl.setRtpEnable(Integer.parseInt(
				rtpEnableCode.substring(2), 16));
		//
		String rtpTimeOutStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\100\" | find /i \"RTP_Timeout\"";
		String rtpTimeOutCode = CommandRegUtil.regValue(rtpTimeOutStr);
		SmartConLogWriter.writeLog("-r", "rtpTimeOutCode:" + rtpTimeOutCode);
		voIpSmartControl.setRtpTimeOut(String.valueOf(Integer.parseInt(
				rtpTimeOutCode.substring(2), 16)));

		String rtpQosStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\100\" | find /i \"RTCP_QoS_Enable\"";
		String rtpQosCode = CommandRegUtil.regValue(rtpQosStr);
		SmartConLogWriter.writeLog("-r", "rtpQosCode:" + rtpQosCode);

		voIpSmartControl.setRtcpQos(Integer.parseInt(rtpQosCode.substring(2),
				16));
		voIpSmartControl.setPort0NicList(netInterCards);
		voIpSmartControl.setPort1NicList(netInterCards);
		return voIpSmartControl;
	}

	@Override
	public void updateSmartControlSystem(User user,
			SmartControlSystem smartControlSystem,
			PBXSmartControl pbxSmartControl, VoIPSmartControl voIpSmartControl,
			Object object) throws ServiceException {

		File smartControlRegFile = new File(user.getUserName()
				+ System.currentTimeMillis() + ".reg");
		if (!smartControlRegFile.exists()) {
			try {
				smartControlRegFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileWriter writer = null;
		try {
			writer = new FileWriter(smartControlRegFile, true);
			// 写文件头部
			writer.append("Windows Registry Editor Version 5.00")
					.append("\r\n");
			writer.append("\r\n");
			// 写gciStartIndex 部分的值
			writer.append(
					"[HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Parameters]")
					.append("\r\n");
			// writer.append("\"GCIStartingIndex\"").append("=").append("dword:").append(smartControlSystem.getGciStartIndex()
			// + "").append("\r\n");
			writer.append("\r\n");
			// 写tdm编码选择
			writer.append(
					"[HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\0]")
					.append("\r\n");
			writer.append("\"TDMEncoding\"").append("=")
					.append("dword:" + pbxSmartControl.getTdmEncoding())
					.append("\r\n");

			if (voIpSmartControl != null) {
				writer.append("\r\n");
				writer.append("[HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\100]");
				writer.append("\r\n");
				writer.append("\"Mon0Enable\"").append("=").append("dword:")
						.append(voIpSmartControl.getMonitorPort0Enable() + "")
						.append("\r\n");
				writer.append("\"Mon1Enable\"").append("=").append("dword:")
						.append(voIpSmartControl.getMonitorPort1Enable() + "")
						.append("\r\n");
				writer.append("\"Mon0Select\"")
						.append("=")
						.append("\"")
						.append("{")
						.append(voIpSmartControl.getMonitorPort0Selected()
								.getServiceName()).append("}").append("\"")
						.append("\r\n");
				writer.append("\"Mon1Select\"")
						.append("=")
						.append("\"")
						.append("{")
						.append(voIpSmartControl.getMonitorPort1Selected()
								.getServiceName()).append("}").append("\"")
						.append("\r\n");
				writer.append("\"RTP_Enable\"").append("=").append("dword:")
						.append(voIpSmartControl.getRtpEnable() + "")
						.append("\r\n");
				writer.append("\"RTP_Timeout\"").append("=").append("dword:")
						.append(voIpSmartControl.getRtpTimeOut())
						.append("\r\n");
				writer.append("\"RTP_QoS_Enable\"").append("=")
						.append("dword:")
						.append(voIpSmartControl.getRtpEnable() + "")
						.append("\r\n");
			}
			writer.flush();
			CommandRegUtil.importReg(smartControlRegFile.getPath());
			SmartConLogWriter.writeLog("-w",
					"TDMEncoding:" + pbxSmartControl.getTdmEncoding()
							+ "       Operator:" + user.getUserName());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public List<String> getNICList() throws ServiceException {
		String nicCode = "netsh interface show interface";
		List<String> nicList = new ArrayList<String>();
		List<String> stringList = CommandRegUtil.getStringList(nicCode);
		for (int i = 0; i < stringList.size(); i++) {
			if (i < 2) {
				continue;
			}
			String every = stringList.get(i);
			every = every.substring(every.lastIndexOf(" ") + 1);
			nicList.add(every);
		}
		return nicList;
	}

	@Override
	public IP getIpInformation(String nicName) throws ServiceException {
		IP ip = new IP();
		String ipCode = "netsh interface ip show address " + nicName;
		List<String> ipResults = CommandRegUtil.getStringList(ipCode);
		for (int i = 2; i < ipResults.size(); i++) {
			String line = ipResults.get(i);
			String regexString = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";
			Pattern p = Pattern.compile(regexString);
			Matcher m = p.matcher(line);
			boolean result = m.find();
			String informationStr = null;
			while (result) {
				informationStr = m.group();
				result = m.find();
			}
			if (i == 2) {
				ip.setIpAddress(informationStr);
				continue;
			}
			if (i == 3) {
				ip.setMask(informationStr);
				continue;
			}
			if (i == 4) {
				ip.setDefaultGeteWay(informationStr);
				continue;
			}
		}
		String dnsCode = "netsh interface ip show dns " + nicName;
		List<String> dnsResult = CommandRegUtil.getStringList(dnsCode);
		for (int i = 1; i < dnsResult.size() - 1; i++) {
			String line = dnsResult.get(i);
			if (i == 1) {
				ip.setFirstDNS(line.split("\\s{2,}")[2]);
			}
			if (i == 2) {
				ip.setSubDNS(line.trim());
			}

		}
		return ip;
	}

	@Override
	public void restartOs() throws ServiceException {
		String shutDownCode = "shutdown /r /t 0";
		CommandRegUtil.exuteCommand(shutDownCode);
	}

	@Override
	public Boolean updateIp(IP ip) throws ServiceException {
		String nicName = ip.getNicName();
		String ipCode = "c:\\macaw\\tools\\setip " + nicName;
		StringBuffer ipBf = new StringBuffer(ipCode);
		ipBf.append(" ").append(ip.getIpAddress());
		ipBf.append(" ").append(ip.getMask());
		ipBf.append(" ").append(ip.getDefaultGeteWay());
		if (ip.getFirstDNS() != null && !("".equals(ip.getFirstDNS()))) {
			ipBf.append(" ").append(ip.getFirstDNS());
		}
		if (ip.getSubDNS() != null && !("".equals(ip.getSubDNS()))) {
			ipBf.append(" ").append(ip.getSubDNS());
		}
		IP oldIp = new SmartControlImpl().getIpInformation(nicName);
		CommandRegUtil.exuteCommand(ipBf.toString());
		IP newIp = new SmartControlImpl().getIpInformation(nicName);
		if (!newIp.equals(oldIp)) {
			if (ip.getNicId() == 1) {
				this.restartOs();
			}
			return true;
		}
		return false;
	}

	/**
	 * Description
	 * 
	 * @throws ServerCloneException
	 * @see com.duplicall.smartControl.service.smartControl.ISmartControl#shutdownOs()
	 */

	@Override
	public void shutdownOs() throws ServiceException {
		String shutDownCode = "shutdown /s";
		CommandRegUtil.exuteCommand(shutDownCode);

	}

	@Override
	public void updatePbx(User user, String tdm, int gciIndex,int configurationId)
			throws ServiceException {

		File smartControlRegFile = new File("c://macaw/temp/"
				+ user.getUserName() + System.currentTimeMillis() + ".reg");
		if (!smartControlRegFile.exists()) {
			try {
				smartControlRegFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileWriter writer = null;
		try {
			writer = new FileWriter(smartControlRegFile, true);
			// 写文件头部
			writer.append("Windows Registry Editor Version 5.00")
					.append("\r\n");
			writer.append("\r\n");
			// 写gciStartIndex 部分的值
			writer.append(
					"[HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Parameters]")
					.append("\r\n");
			writer.append("\"GCIStartingIndex\"").append("=").append("dword:")
					.append(gciIndex + "").append("\r\n");
			writer.append("\r\n");
			// 写tdm编码选择
			writer.append(
					"[HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"]")
					.append("\r\n");
			writer.append("\"TDMEncoding\"").append("=").append("dword:" + tdm)
					.append("\r\n");
			writer.flush();
			CommandRegUtil.importReg(smartControlRegFile.getPath());
			SmartConLogWriter.writeLog("-w", "TDMEncoding:" + tdm
					+ "       Operator:" + user.getUserName());
			SmartConLogWriter.writeLog("-w", "GCI Index:" + gciIndex
					+ "       Operator:" + user.getUserName());
		} catch (IOException e) {
			throw new ServiceException();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void updateVoIp(User user, VoIPSmartControl voIPSmartControl)
			throws ServiceException {

		File smartControlRegFile = new File("c://macaw/temp/"
				+ user.getUserName() + System.currentTimeMillis() + ".reg");
		if (!smartControlRegFile.exists()) {
			try {
				smartControlRegFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileWriter writer = null;
		try {
			writer = new FileWriter(smartControlRegFile, true);
			// 写文件头部
			writer.append("Windows Registry Editor Version 5.00")
					.append("\r\n");
			writer.append("\r\n");
			if (voIPSmartControl != null) {
				writer.append("\r\n");
				writer.append("[HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\100]");
				writer.append("\r\n");
				writer.append("\"Mon0Enable\"").append("=").append("dword:")
						.append(voIPSmartControl.getMonitorPort0Enable() + "")
						.append("\r\n");
				writer.append("\"Mon1Enable\"").append("=").append("dword:")
						.append(voIPSmartControl.getMonitorPort1Enable() + "")
						.append("\r\n");
				writer.append("\"Mon0Select\"")
						.append("=")
						.append("\"")
						.append("{")
						.append(voIPSmartControl.getMonitorPort0Selected()
								.getServiceName()).append("}").append("\"")
						.append("\r\n");
				writer.append("\"Mon1Select\"")
						.append("=")
						.append("\"")
						.append("{")
						.append(voIPSmartControl.getMonitorPort1Selected()
								.getServiceName()).append("}").append("\"")
						.append("\r\n");
				writer.append("\"RTP_Enable\"").append("=").append("dword:")
						.append(voIPSmartControl.getRtpEnable() + "")
						.append("\r\n");
				writer.append("\"RTP_Timeout\"")
						.append("=")
						.append("dword:")
						.append(Integer.toHexString(Integer
								.parseInt(voIPSmartControl.getRtpTimeOut())))
						.append("\r\n");
				writer.append("\"RTCP_QoS_Enable\"").append("=")
						.append("dword:")
						.append(voIPSmartControl.getRtcpQos() + "")
						.append("\r\n");
			}
			writer.flush();
			CommandRegUtil.importReg(smartControlRegFile.getPath());
			SmartConLogWriter.writeLog("-w", "VoIP:" + "       Operator:"
					+ user.getUserName());
		} catch (IOException e) {
			throw new ServiceException("修改失败！");
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public NgxSmartControl getNgx(Ngx ngx) throws ServiceException {
		NgxSmartControl ngxSmartControl = new NgxSmartControl();
		SmartBoard baseBoard = getBasicBoard(ngx.getConfigurationId());
		ngxSmartControl.setBusNo(ngx.getBusno());
		ngxSmartControl.setSlotNo(ngx.getSlotno());
		//对于1ubox，因为是8路的，所以无dc1和dc2
//		SmartBoard dc1 = getDc1(ngx.getConfigurationId());
//		SmartBoard dc2 = getDc2(ngx.getConfigurationId());
		ngxSmartControl.setBoardBase(baseBoard);
		ngxSmartControl.setConfigurationId(ngx.getConfigurationId());
//		ngxSmartControl.setBoardDC1(dc1);
//		ngxSmartControl.setBoardDC2(dc2);
		return ngxSmartControl;
	}

	// 获取ngx，basic board
	public SmartBoard getBasicBoard(int configurationId) {
		// baseBoard
		SmartBoard baseBoard = new SmartBoard();
		// pbxType
		String baseTypeCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"PbxType\"";
		String baseType = CommandRegUtil.regValue(baseTypeCode);
		baseBoard.setPbxType(String.valueOf(Integer.parseInt(
				baseType.substring(2), 16)));

		// channels
		String baseChannelCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"TotalChannels\"";
		String baseChannels = CommandRegUtil.regValue(baseChannelCode);
		baseBoard.setChannels(String.valueOf(Integer.parseInt(
				baseChannels.substring(2), 16)));

		// SerialNumber
		String baseSerialNumberCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+" | find /i \"SerialNumber\"";
		String baseSerialNumber = CommandRegUtil.regValue(baseSerialNumberCode);
		// DateCode
		String dateCodeCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"DateCode\"";
		String dateCode = CommandRegUtil.regValue(dateCodeCode);
		// assemblyCode
		String assemblyCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"AssemblyCode\"";
		String assembly = CommandRegUtil.regValue(assemblyCode);

		baseBoard.setServialNumber(dateCode + "." + assembly + "."
				+ baseSerialNumber);
		baseBoard.setDateCode(dateCode);

		// Firmware version
		String firmWareMajorCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"FirmwareMajor\"";
		String firmWareMajor = CommandRegUtil.regValue(firmWareMajorCode);
		String firmWareMinorCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"FirmwareMinor\"";
		String firmWareMinor = CommandRegUtil.regValue(firmWareMinorCode);
		String firmWareInternalCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"FirmwareInternal\"";
		String firmWareInternal = CommandRegUtil.regValue(firmWareInternalCode);
		// System.out.println(firmWareMajor+"    "+firmWareMinor+"   "+firmWareInternal);
		String firmWareVersion = String.valueOf(Integer.parseInt(
				firmWareMajor.substring(2), 16))
				+ "."
				+ String.valueOf(Integer.parseInt(firmWareMinor.substring(2),
						16))
				+ "."
				+ String.valueOf(Integer.parseInt(
						firmWareInternal.substring(2), 16));
		baseBoard.setFirmwareVersion(firmWareVersion);

		// termination
		String terminationCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"Termination\"";
		String termination = CommandRegUtil.regValue(terminationCode);
		baseBoard.setTermination(String.valueOf(Integer.parseInt(
				termination.substring(2), 16)));

		String dChanelCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"DChOptions\"";
		String dChanel = CommandRegUtil.regValue(dChanelCode);
		baseBoard.setdChannel(String.valueOf(Integer.parseInt(
				dChanel.substring(2), 16)));

		// tdmEncoding
		String tdmEncodingStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"TDMEncoding\"";
		String tdmEncodingCode = CommandRegUtil.regValue(tdmEncodingStr);
		Long tdmEncoding = Long.valueOf(tdmEncodingCode.substring(2), 16);
		baseBoard.setTdmEncoding((tdmEncoding==0?0:1)
				+ "");

		return baseBoard;
	}

	// 获取ngx，DC1
	public SmartBoard getDc1(int configurationId) {
		// baseBoard
		SmartBoard dc1 = new SmartBoard();
		// pbxType
		String baseTypeCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC1\" | find /i \"PbxType\"";
		String baseType = CommandRegUtil.regValue(baseTypeCode);
		dc1.setPbxType(String.valueOf(Integer.parseInt(baseType.substring(2),
				16)));

		// channels
		String baseChannelCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC1\" | find /i \"TotalChannels\"";
		String baseChannels = CommandRegUtil.regValue(baseChannelCode);
		dc1.setChannels(String.valueOf(Integer.parseInt(
				baseChannels.substring(2), 16)));

		// SerialNumber
		String baseSerialNumberCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC1\" | find /i \"SerialNumber\"";
		String baseSerialNumber = CommandRegUtil.regValue(baseSerialNumberCode);

		// DateCode
		String dateCodeCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC1\" | find /i \"DateCode\"";
		String dateCode = CommandRegUtil.regValue(dateCodeCode);
		// assemblyCode
		String assemblyCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC1\" | find /i \"AssemblyCode\"";
		String assembly = CommandRegUtil.regValue(assemblyCode);

		dc1.setServialNumber(dateCode + "." + assembly + "." + baseSerialNumber);
		dc1.setDateCode(dateCode);

		// Firmware version
		String firmWareMajorCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC1\" | find /i \"FirmwareMajor\"";
		String firmWareMajor = CommandRegUtil.regValue(firmWareMajorCode);
		String firmWareMinorCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC1\" | find /i \"FirmwareMinor\"";
		String firmWareMinor = CommandRegUtil.regValue(firmWareMinorCode);
		String firmWareInternalCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC1\" | find /i \"FirmwareInternal\"";
		String firmWareInternal = CommandRegUtil.regValue(firmWareInternalCode);
		String firmWareVersion = String.valueOf(Integer.parseInt(
				firmWareMajor.substring(2), 16))
				+ "."
				+ String.valueOf(Integer.parseInt(firmWareMinor.substring(2),
						16))
				+ "."
				+ String.valueOf(Integer.parseInt(
						firmWareInternal.substring(2), 16));
		dc1.setFirmwareVersion(firmWareVersion);

		// termination
		String terminationCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC1\" | find /i \"Termination\"";
		String termination = CommandRegUtil.regValue(terminationCode);
		dc1.setTermination(String.valueOf(Integer.parseInt(
				termination.substring(2), 16)));

		String dChanelCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC1\" | find /i \"DChOptions\"";
		String dChanel = CommandRegUtil.regValue(dChanelCode);
		dc1.setdChannel(String.valueOf(Integer.parseInt(dChanel.substring(2),
				16)));

		/*
		 * //tdmEncoding String tdmEncodingStr =
		 * "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\6\" | find /i \"TDMEncoding\""
		 * ; String tdmEncodingCode = CommandRegUtil.regValue(tdmEncodingStr);
		 * dc1.setTdmEncoding(Long.valueOf( tdmEncodingCode.substring(2),
		 * 16)+"");
		 */
		return dc1;
	}

	// 获取ngx，DC1
	public SmartBoard getDc2(int configurationId) {
		// baseBoard
		SmartBoard dc2 = new SmartBoard();
		// pbxType
		String baseTypeCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC2\" | find /i \"PbxType\"";
		String baseType = CommandRegUtil.regValue(baseTypeCode);
		dc2.setPbxType(String.valueOf(Integer.parseInt(baseType.substring(2),
				16)));

		// channels
		String baseChannelCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC2\" | find /i \"TotalChannels\"";
		String baseChannels = CommandRegUtil.regValue(baseChannelCode);
		dc2.setChannels(String.valueOf(Integer.parseInt(
				baseChannels.substring(2), 16)));

		// SerialNumber
		String baseSerialNumberCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC2\" | find /i \"SerialNumber\"";
		String baseSerialNumber = CommandRegUtil.regValue(baseSerialNumberCode);
		// DateCode
		String dateCodeCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC2\" | find /i \"DateCode\"";
		String dateCode = CommandRegUtil.regValue(dateCodeCode);
		// assemblyCode
		String assemblyCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC2\" | find /i \"AssemblyCode\"";
		String assembly = CommandRegUtil.regValue(assemblyCode);

		dc2.setServialNumber(dateCode + "." + assembly + "." + baseSerialNumber);
		dc2.setDateCode(dateCode);

		// Firmware version
		String firmWareMajorCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC2\" | find /i \"FirmwareMajor\"";
		String firmWareMajor = CommandRegUtil.regValue(firmWareMajorCode);
		String firmWareMinorCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC2\" | find /i \"FirmwareMinor\"";
		String firmWareMinor = CommandRegUtil.regValue(firmWareMinorCode);
		String firmWareInternalCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC2\" | find /i \"FirmwareInternal\"";
		String firmWareInternal = CommandRegUtil.regValue(firmWareInternalCode);
		String firmWareVersion = String.valueOf(Integer.parseInt(
				firmWareMajor.substring(2), 16))
				+ "."
				+ String.valueOf(Integer.parseInt(firmWareMinor.substring(2),
						16))
				+ "."
				+ String.valueOf(Integer.parseInt(
						firmWareInternal.substring(2), 16));
		dc2.setFirmwareVersion(firmWareVersion);

		// termination
		String terminationCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC2\" | find /i \"Termination\"";
		String termination = CommandRegUtil.regValue(terminationCode);
		dc2.setTermination(String.valueOf(Integer.parseInt(
				termination.substring(2), 16)));

		String dChanelCode = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\7\\DC2\" | find /i \"DChOptions\"";
		String dChanel = CommandRegUtil.regValue(dChanelCode);
		dc2.setdChannel(String.valueOf(Integer.parseInt(dChanel.substring(2),
				16)));

		/*
		 * //tdmEncoding String tdmEncodingStr =
		 * "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\6\" | find /i \"TDMEncoding\""
		 * ; String tdmEncodingCode = CommandRegUtil.regValue(tdmEncodingStr);
		 * dc1.setTdmEncoding(Long.valueOf( tdmEncodingCode.substring(2),
		 * 16)+"");
		 */
		return dc2;
	}

	/*
	 * public static void main(String[] args) { SmartBoard a = new SmartBoard();
	 * a.setBoardType("101"); a.setdChannel("22"); a.setTermination("111");
	 * SmartControlImpl controlImpl = new SmartControlImpl(); User user = new
	 * User(); user.setUserName("222"); try { controlImpl.updateNgx(user, a,
	 * null, null); } catch (ServiceException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } //System.out.println((Integer.parseInt(a)));
	 * 
	 * // try { // controlImpl.getDc2(); // } catch (ServiceException e) { //
	 * e.printStackTrace(); // } }
	 */

	@Override
	public Long getEncoding(int configurationId) throws ServiceException {
		String tdmEncodingStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\" | find /i \"TDMEncoding\"";
		String tdmEncodingCode = CommandRegUtil.regValue(tdmEncodingStr);
		return Long.valueOf(tdmEncodingCode.substring(2), 16);
	}

	@Override
	public String getStartingIndex() throws ServiceException {
		// GCIStartingIndex 信息抓取
		String gciStrartingIndexStr = "reg query \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Parameters\" | find /i \"GCIStartingIndex\"";
		String startingIndex = CommandRegUtil.regValue(gciStrartingIndexStr);
		return startingIndex.substring(2);
	}

	@Override
	public void updateNgx(User user, SmartBoard boardBase, SmartBoard boardDc1,
			SmartBoard boardDc2, int startingIndex,int configurationId) throws ServiceException {
		File smartControlRegFile = new File("c://macaw/temp/"
				+ user.getUserName() + System.currentTimeMillis() + ".reg");
		if (!smartControlRegFile.exists()) {
			try {
				smartControlRegFile.createNewFile();
			} catch (IOException e) {
				throw new ServiceException();
			}
		}
		FileWriter writer = null;
		try {
			writer = new FileWriter(smartControlRegFile, true);
			// 写文件头部
			writer.append("Windows Registry Editor Version 5.00")
					.append("\r\n");
			writer.append("\r\n");
			if (boardBase != null) {
				writer.append("\r\n");
				writer.append("[HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"]");
				writer.append("\r\n");
				writer.append("\"PbxType\"")
						.append("=")
						.append("dword:")
						.append(Integer.toHexString(Integer.parseInt(boardBase
								.getPbxType()))).append("\r\n");
				writer.append("\"DChOptions\"").append("=").append("dword:")
						.append(boardBase.getdChannel()).append("\r\n");
				writer.append("\"Termination\"").append("=").append("dword:")
						.append(boardBase.getTermination()).append("\r\n");
			}

			if (boardDc1 != null) {
				writer.append("\r\n");
				writer.append("[HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\\DC1]");
				writer.append("\r\n");
				writer.append("\"PbxType\"")
						.append("=")
						.append("dword:")
						.append(Integer.toHexString(Integer.parseInt(boardDc1
								.getPbxType()))).append("\r\n");
				writer.append("\"DChOptions\"").append("=").append("dword:")
						.append(boardDc1.getdChannel()).append("\r\n");
				writer.append("\"Termination\"").append("=").append("dword:")
						.append(boardDc1.getTermination()).append("\r\n");
			}
			if (boardDc2 != null) {
				writer.append("\r\n");
				writer.append("[HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"\\DC2]");
				writer.append("\r\n");
				writer.append("\"PbxType\"")
						.append("=")
						.append("dword:")
						.append(Integer.toHexString(Integer.parseInt(boardDc2
								.getPbxType()))).append("\r\n");
				writer.append("\"DChOptions\"").append("=").append("dword:")
						.append(boardDc2.getdChannel()).append("\r\n");
				writer.append("\"Termination\"").append("=").append("dword:")
						.append(boardDc2.getTermination()).append("\r\n");
			}
			// 写tdm encoding，starting index
			writer.append("\r\n");
			writer.append(
					"[HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Parameters]")
					.append("\r\n");
			writer.append("\"GCIStartingIndex\"").append("=").append("dword:")
					.append(startingIndex + "").append("\r\n");
			writer.append("\r\n");
			// 写tdm编码选择
			writer.append(
					"[HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\services\\Ntidrv\\Devices\\MtxBrd\\"+configurationId+"]")
					.append("\r\n");
			writer.append("\"TDMEncoding\"").append("=")
					.append("dword:" + boardBase.getTdmEncoding())
					.append("\r\n");
			writer.flush();
			CommandRegUtil.importReg(smartControlRegFile.getPath());
			SmartConLogWriter.writeLog("-w",
					"ngx:" + "       Operator:" + user.getUserName());

		} catch (IOException e) {
			throw new ServiceException("修改失败！");
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				throw new ServiceException();
			}
		}

	}

}
