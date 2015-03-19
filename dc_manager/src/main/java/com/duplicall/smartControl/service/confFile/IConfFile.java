package com.duplicall.smartControl.service.confFile;

import java.io.File;

import com.duplicall.smartControl.exception.ServiceException;

public interface IConfFile {
	/**
	 * 統一配置文件
	 * 
	 * @param destinationFile
	 * @throws ServiceException
	 */
	public void gatherConfFile(String destinationFile) throws ServiceException;

	/**
	 * 上传File
	 * 
	 * @param
	 * @throws ServiceException
	 */
	public void uploadconfFile(File srcFile, String uploadFileName)
			throws ServiceException;

}
