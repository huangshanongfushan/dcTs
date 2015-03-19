package com.duplicall.smartControl.service.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface NgxConfigFile {
	public static File ngxConfiFiles = new File(
			"C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\CD-DS\\Config");
	public static File smartwxInfoFile = new File(
			"C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\CD-DS\\Config\\SmartWORKS.ini");
	public static File logConfFile = new File(
			"C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\CD-DS\\Config\\logconfig.xml");
	public static File ngxScxmlFiles = new File(
			"C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\CD-DS\\Config\\NgxScxml");
	public static File logFloder = new File(
			"C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\CD-DS\\Logs");
	// public static File logFloder = new
	// File("C:\\Program Files (x86)\\AudioCodes\\SmartWORKS PLUS\\CD-DS\\Logs");
	public static File firmwareFloder = new File(
			"C:\\Program Files (x86)\\Ai-Logix\\SmartWORKS\\Firmware");
	public static List<File> fileList = new ArrayList<File>();

}
