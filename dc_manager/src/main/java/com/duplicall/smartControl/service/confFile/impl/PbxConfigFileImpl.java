package com.duplicall.smartControl.service.confFile.impl;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.service.common.PbxConfigFile;
import com.duplicall.smartControl.service.confFile.IConfFile;

@Service("pbxConfFileImpl")
public class PbxConfigFileImpl implements IConfFile {
	@Override
	public void gatherConfFile(String destinationFile) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void uploadconfFile(File srcFile, String uploadFileName)
			throws ServiceException {
		try {
			if ("LD.xml".equals(uploadFileName)) {
				FileUtils.copyFile(srcFile, PbxConfigFile.ldFile);
				return;
			} 
			if ("SmartWORKS.ini".equals(uploadFileName)) {
				FileUtils.copyFile(
						srcFile,PbxConfigFile.smartwxFile);
				return;
			}
			if ("logconfig.xml".equals(uploadFileName)) {
				FileUtils.copyFile(srcFile, PbxConfigFile.logConfigFile);
				return;
			}
			if ("activitydetection.scxml".equals(uploadFileName)) {
				FileUtils.copyFile(srcFile, PbxConfigFile.activDetectConfFile);
				return;
			}
			if ("ldgeneric.scxml".equals(uploadFileName)) {
				FileUtils.copyFile(srcFile, PbxConfigFile.ldgeFile);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
