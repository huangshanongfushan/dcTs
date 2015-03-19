package com.duplicall.smartControl.service.confFile.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.duplicall.smartControl.common.util.FloderCopyUtil;
import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.service.common.VoipConfigFile;
import com.duplicall.smartControl.service.confFile.IConfFile;

@Service("voipConfFileImpl")
public class VoipConfFileImpl implements IConfFile {

	@Override
	public void gatherConfFile(String destinationFile) throws ServiceException {
		try {
			FileCopyUtils.copy(VoipConfigFile.logConfFile, new File(
					destinationFile + VoipConfigFile.logConfFile.getName()));
			FileCopyUtils.copy(VoipConfigFile.smartWorksFile, new File(
					destinationFile + VoipConfigFile.smartWorksFile.getName()));
			FileCopyUtils.copy(VoipConfigFile.voipCnfFile, new File(
					destinationFile + VoipConfigFile.voipCnfFile.getName()));
			FloderCopyUtil.copyFolder(
					VoipConfigFile.logFloder.getAbsolutePath(), destinationFile
							+ VoipConfigFile.logFloder.getName());
			List<File> ipxFileList = getIpxXmlFiles(VoipConfigFile.ipxFiles);
			for (File file : ipxFileList) {
				FileCopyUtils.copy(file,
						new File(destinationFile + file.getName()));
			}
			List<File> voipFileList = getScxmFiles(VoipConfigFile.hpxScxmFiles);
			for (File file : voipFileList) {
				FileCopyUtils.copy(file,
						new File(destinationFile + file.getName()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void uploadconfFile(File srcFile, String fileName)
			throws ServiceException {
		try {
			if (fileName.startsWith("IPX") && fileName.endsWith(".xml")) {
				FileUtils.copyFileToDirectory(srcFile, VoipConfigFile.ipxFiles);
				return;
			}
			if ("Voip.cfg".equals(fileName)) {
				FileUtils.copyFile(srcFile, VoipConfigFile.voipCnfFile);
				return;
			}
			if ("logconfig.xml".equals(fileName)) {
				FileUtils.copyFile(srcFile, VoipConfigFile.logConfFile);
				return;
			}
			if ("SmartWORKS.ini".equals(fileName)) {
				FileUtils.copyFile(srcFile, VoipConfigFile.smartWorksFile);
				return;
			}
			if (fileName.endsWith(".scxml")) {
				FileUtils.copyFileToDirectory(srcFile,
						VoipConfigFile.hpxScxmFiles);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 根绝文件夹，获取.scxml结尾的文件
	public List<File> getScxmFiles(File parentFile) {
		List<File> fileList = new ArrayList<File>();
		File[] fileArray = parentFile.listFiles();
		for (File file : fileArray) {
			if (file.getName().endsWith(".scxml")) {
				fileList.add(file);
			}
		}
		return fileList;
	}

	// 抓取IPX_打头的配置文件
	public List<File> getIpxXmlFiles(File parentFile) {
		List<File> fileList = new ArrayList<File>();
		File[] fileArray = parentFile.listFiles();
		for (File file : fileArray) {
			if (file.getName().startsWith("IPX_")) {
				fileList.add(file);
			}
		}
		return fileList;
	}
}
