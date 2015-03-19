package com.duplicall.smartControl.service.common;

import java.io.File;

public interface CommonConfigFile {
	// common
	public static File decdecodeFile = new File(
			"C:\\Windows\\SysWOW64\\dcdecode.dll");

	public static File smrtwrksSrvc = new File(
			"C:\\Program Files (x86)\\Ai-Logix\\SmartWORKS\\SmrtwrksSrvc.exe");

	public static File systemDatFile = new File(
			"C:\\Program Files (x86)\\Ai-Logix\\SmartWORKS");

	public static File acHmpFile = new File(
			"C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\MS\\Server\\Bin\\ac-hmp20.ini");

	public static File hmpServiceFile = new File(
			"C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\MS\\Server\\Bin\\HMPService.exe");

	public static File hpxHmpConf = new File(
			"C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\MS\\Log\\hpxmedia-hmp-log4cxx-config.xml");

	public static File hpxRtsConf = new File(
			"C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\MS\\Log\\hpxmedia-rts-log4cxx-config.xml");

	public static File hmpsvcOutputFloder = new File(
			"C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\MS\\Log\\hmpsvc_output");
	public static File rtsvcOutputFloder = new File(
			"C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\MS\\Log\\rtsvc_output");
	public static File logsFloder = new File(
			"C:\\Program Files (x86)\\Ai-Logix\\SmartWORKS\\Logs");

	// Voip
	// public static File decdecodeFile = new File("");
	//
	// public static File decdecodeFile = new File("");
	// public static File decdecodeFile = new File("");
	// public static File decdecodeFile = new File("");

}
