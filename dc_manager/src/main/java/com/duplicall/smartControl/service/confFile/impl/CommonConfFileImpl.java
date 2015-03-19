package com.duplicall.smartControl.service.confFile.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.duplicall.smartControl.common.util.FloderCopyUtil;
import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.service.common.CommonConfigFile;
import com.duplicall.smartControl.service.confFile.IConfFile;

@Service("commonConfFileImpl")
public class CommonConfFileImpl implements IConfFile {

	@Override
	public void gatherConfFile(String destinationFile) throws ServiceException {
		try {
			// 第二个参数为目的路径
			FileCopyUtils.copy(CommonConfigFile.acHmpFile, new File(
					destinationFile + CommonConfigFile.acHmpFile.getName()));

			FileCopyUtils
					.copy(CommonConfigFile.decdecodeFile,
							new File(destinationFile
									+ CommonConfigFile.decdecodeFile.getName()));

			FileCopyUtils.copy(
					CommonConfigFile.hmpServiceFile,
					new File(destinationFile
							+ CommonConfigFile.hmpServiceFile.getName()));

			FileCopyUtils.copy(CommonConfigFile.hpxHmpConf, new File(
					destinationFile + CommonConfigFile.hpxHmpConf.getName()));

			FileCopyUtils.copy(CommonConfigFile.hpxRtsConf, new File(
					destinationFile + CommonConfigFile.hpxRtsConf.getName()));

			FileCopyUtils.copy(CommonConfigFile.smrtwrksSrvc, new File(
					destinationFile + CommonConfigFile.smrtwrksSrvc.getName()));
			// swx授权文件
			File systemDataFile = getSystemDatFile(CommonConfigFile.systemDatFile);
			FileCopyUtils.copy(systemDataFile, new File(destinationFile
					+ systemDataFile.getName()));

			FloderCopyUtil.copyFolder(
					CommonConfigFile.hmpsvcOutputFloder.getAbsolutePath(),
					destinationFile
							+ CommonConfigFile.hmpsvcOutputFloder.getName());
			FloderCopyUtil.copyFolder(
					CommonConfigFile.rtsvcOutputFloder.getAbsolutePath(),
					destinationFile
							+ CommonConfigFile.rtsvcOutputFloder.getName());
			FloderCopyUtil.copyFolder(
					CommonConfigFile.logsFloder.getAbsolutePath(),
					destinationFile + CommonConfigFile.logsFloder.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void uploadconfFile(File srcFile, String uploadFileName)
			throws ServiceException {
		try {
			// do something with file;
			if ("dcdecode.dll".equals(uploadFileName)) {
				FileUtils.copyFile(srcFile, CommonConfigFile.decdecodeFile);
				return;
			} 
			if ("SmrtwrksSrvc.exe".equals(uploadFileName)) {
				FileUtils.copyFile(
						srcFile,
						new File(CommonConfigFile.smrtwrksSrvc.getPath()
								.substring(
										0,
										CommonConfigFile.smrtwrksSrvc.getPath()
												.lastIndexOf("\\"))
								+ "\\" + uploadFileName));
				return;
			}
			if (uploadFileName.endsWith(".dat")) {
				FileUtils.copyFileToDirectory(srcFile,
						CommonConfigFile.systemDatFile);
				return;
			}
			if ("ac-hmp20.ini".equals(uploadFileName)) {
				FileUtils.copyFile(srcFile, CommonConfigFile.acHmpFile);
				return;
			}
			if ("HMPService.exe".equals(uploadFileName)) {
				FileUtils.copyFile(srcFile, CommonConfigFile.hmpServiceFile);
				return;
			}
			if ("hpxmedia-hmp-log4cxx-config.xml".equals(uploadFileName)) {
				FileUtils.copyFile(srcFile, CommonConfigFile.hpxHmpConf);
				return;
			}
			if ("hpxmedia-rts-log4cxx-config.xml".equals(uploadFileName)) {
				FileUtils.copyFile(srcFile, CommonConfigFile.hpxRtsConf);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 根據文件夹，获取swx授权文件
	public File getSystemDatFile(File parentFile) {
		// File file = new File();
		File[] childFile = parentFile.listFiles();
		for (File file : childFile) {
			if (file.getName().startsWith("System-")
					&& file.getName().endsWith(".dat")) {
				return file;
			}
		}
		return null;
	}

}
