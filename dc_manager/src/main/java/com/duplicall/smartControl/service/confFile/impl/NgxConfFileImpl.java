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
import com.duplicall.smartControl.service.common.NgxConfigFile;
import com.duplicall.smartControl.service.confFile.IConfFile;

@Service("ngxConfFileImpl")
public class NgxConfFileImpl implements IConfFile {
	@Override
	public void gatherConfFile(String destinationFile) throws ServiceException {
		try {
			FileCopyUtils.copy(NgxConfigFile.logConfFile, new File(
					destinationFile + NgxConfigFile.logConfFile.getName()));
			FileCopyUtils.copy(NgxConfigFile.smartwxInfoFile, new File(
					destinationFile + NgxConfigFile.smartwxInfoFile.getName()));
			FloderCopyUtil.copyFolder(
					NgxConfigFile.logFloder.getAbsolutePath(), destinationFile
							+ NgxConfigFile.logFloder.getName());
			List<File> ngxConfFileList = getNgxXmlFiles(NgxConfigFile.ngxConfiFiles);
			for (File file : ngxConfFileList) {
				FileCopyUtils.copy(file,
						new File(destinationFile + file.getName()));
			}

			List<File> ngxSxmlFileList = getScxmFiles(NgxConfigFile.ngxScxmlFiles);
			for (File file : ngxSxmlFileList) {
				FileCopyUtils.copy(file,
						new File(destinationFile + file.getName()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void uploadconfFile(File srcFile, String uploadFileName)
			throws ServiceException {
		try {
			// do something with file;
			if (uploadFileName.startsWith("NGX")
					&& uploadFileName.endsWith(".xml")) {
				FileUtils.copyFileToDirectory(srcFile,
						NgxConfigFile.ngxConfiFiles);
				return;
			}
			if ("SmartWORKS.ini".equals(uploadFileName)) {
				FileUtils.copyFile(srcFile, NgxConfigFile.smartwxInfoFile);
				return;
			}
			if ("logconfig.xml".equals(uploadFileName)) {
				FileUtils.copyFileToDirectory(srcFile,
						NgxConfigFile.logConfFile);
				return;
			}
			if (uploadFileName.endsWith(".scxml")) {
				FileUtils.copyFileToDirectory(srcFile,
						NgxConfigFile.ngxScxmlFiles);
				return;
			}
			if (uploadFileName.endsWith(".ngx")
					|| uploadFileName.endsWith(".txt")) {
				FileUtils.copyFileToDirectory(srcFile,
						NgxConfigFile.firmwareFloder);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
//		FileUtils.copyURLToFile(source, destination);

	}

	// 抓取NGX打头的文件
	public List<File> getNgxXmlFiles(File parentFile) {
		List<File> ngxXmlFileList = new ArrayList<File>();
		File[] files = parentFile.listFiles();
		for (File file : files) {
			if (file.getName().startsWith("NGX_")) {
				ngxXmlFileList.add(file);
			}
		}
		return ngxXmlFileList;
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
}
