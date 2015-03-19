//package com.duplicall.smartControl.service.confFile.impl;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//import org.springframework.util.FileCopyUtils;
//
//import com.duplicall.smartControl.common.util.FloderCopyUtil;
//import com.duplicall.smartControl.exception.ServiceException;
//import com.duplicall.smartControl.service.common.CommonConfigFile;
//import com.duplicall.smartControl.service.common.NgxConfigFile;
//import com.duplicall.smartControl.service.common.VoipConfigFile;
//import com.duplicall.smartControl.service.confFile.IConfFile;
//@Service
//public class ConfFileImpl implements IConfFile {
//
//	@Override
//	public void gatherPulicConfFile(String destinationFile)
//			throws ServiceException {
//		try {
//			// 第二个参数为目的路径
//			FileCopyUtils.copy(CommonConfigFile.acHmpFile, new File(
//					destinationFile + CommonConfigFile.acHmpFile.getName()));
//
//			FileCopyUtils
//					.copy(CommonConfigFile.decdecodeFile,
//							new File(destinationFile
//									+ CommonConfigFile.decdecodeFile.getName()));
//
//			FileCopyUtils.copy(
//					CommonConfigFile.hmpServiceFile,
//					new File(destinationFile
//							+ CommonConfigFile.hmpServiceFile.getName()));
//
//			FileCopyUtils.copy(CommonConfigFile.hpxHmpConf, new File(
//					destinationFile + CommonConfigFile.hpxHmpConf.getName()));
//
//			FileCopyUtils.copy(CommonConfigFile.hpxRtsConf, new File(
//					destinationFile + CommonConfigFile.hpxRtsConf.getName()));
//
//			FileCopyUtils.copy(CommonConfigFile.smrtwrksSrvc, new File(
//					destinationFile + CommonConfigFile.smrtwrksSrvc.getName()));
//			// swx授权文件
//			File systemDataFile = getSystemDatFile(CommonConfigFile.systemDatFile);
//			FileCopyUtils.copy(systemDataFile, new File(destinationFile
//					+ systemDataFile.getName()));
//
//			FloderCopyUtil.copyFolder(
//					CommonConfigFile.hmpsvcOutputFloder.getAbsolutePath(),
//					destinationFile
//							+ CommonConfigFile.hmpsvcOutputFloder.getName());
//			FloderCopyUtil.copyFolder(
//					CommonConfigFile.rtsvcOutputFloder.getAbsolutePath(),
//					destinationFile
//							+ CommonConfigFile.rtsvcOutputFloder.getName());
//			FloderCopyUtil.copyFolder(
//					CommonConfigFile.logsFloder.getAbsolutePath(),
//					destinationFile + CommonConfigFile.logsFloder.getName());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	@Override
//	public void gatherVoipConfFile(String destinationFile)
//			throws ServiceException {
//		try {
//			FileCopyUtils.copy(VoipConfigFile.logConfFile, new File(
//					destinationFile + VoipConfigFile.logConfFile.getName()));
//			FileCopyUtils.copy(VoipConfigFile.smartWorksFile, new File(
//					destinationFile + VoipConfigFile.smartWorksFile.getName()));
//			FileCopyUtils.copy(VoipConfigFile.voipCnfFile, new File(
//					destinationFile + VoipConfigFile.voipCnfFile.getName()));
//			FloderCopyUtil.copyFolder(
//					VoipConfigFile.logFloder.getAbsolutePath(), destinationFile
//							+ VoipConfigFile.logFloder.getName());
//			List<File> ipxFileList = getIpxXmlFiles(VoipConfigFile.ipxFiles);
//			for (File file : ipxFileList) {
//				FileCopyUtils.copy(file,
//						new File(destinationFile + file.getName()));
//			}
//			List<File> voipFileList = getScxmFiles(VoipConfigFile.hpxScxmFiles);
//			for (File file : voipFileList) {
//				FileCopyUtils.copy(file,
//						new File(destinationFile + file.getName()));
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void gatherNgxConfFile(String destinationFile)
//			throws ServiceException {
//		try {
//			FileCopyUtils.copy(NgxConfigFile.logConfFile, new File(
//					destinationFile + NgxConfigFile.logConfFile.getName()));
//			FileCopyUtils.copy(NgxConfigFile.smartwxInfoFile, new File(
//					destinationFile + NgxConfigFile.smartwxInfoFile.getName()));
//			FloderCopyUtil.copyFolder(
//					NgxConfigFile.logFloder.getAbsolutePath(), destinationFile
//							+ NgxConfigFile.logFloder.getName());
//			List<File> ngxConfFileList = getNgxXmlFiles(NgxConfigFile.ngxConfiFiles);
//			for (File file : ngxConfFileList) {
//				FileCopyUtils.copy(file,
//						new File(destinationFile + file.getName()));
//			}
//
//			List<File> ngxSxmlFileList = getScxmFiles(NgxConfigFile.ngxScxmlFiles);
//			for (File file : ngxSxmlFileList) {
//				FileCopyUtils.copy(file,
//						new File(destinationFile + file.getName()));
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	@Override
//	public void gatherPbxConfFile(String destinationFile)
//			throws ServiceException {
//		// TODO Auto-generated method stub
//
//	}
//	// 抓取NGX打头的文件
//	public List<File> getNgxXmlFiles(File parentFile) {
//		List<File> ngxXmlFileList = new ArrayList<File>();
//		File[] files = parentFile.listFiles();
//		for (File file : files) {
//			if (file.getName().startsWith("NGX_")) {
//				ngxXmlFileList.add(file);
//			}
//		}
//		return ngxXmlFileList;
//	}
//
//	// 抓取IPX_打头的配置文件
//	public List<File> getIpxXmlFiles(File parentFile) {
//		List<File> fileList = new ArrayList<File>();
//		File[] fileArray = parentFile.listFiles();
//		for (File file : fileArray) {
//			if (file.getName().startsWith("IPX_")) {
//				fileList.add(file);
//			}
//		}
//		return fileList;
//	}
//	// 根據文件夹，获取swx授权文件
//	public File getSystemDatFile(File parentFile) {
//		// File file = new File();
//		File[] childFile = parentFile.listFiles();
//		for (File file : childFile) {
//			if (file.getName().startsWith("System-")
//					&& file.getName().endsWith(".dat")) {
//				return file;
//			}
//		}
//		return null;
//	}
//	// 根绝文件夹，获取.scxml结尾的文件
//	public List<File> getScxmFiles(File parentFile) {
//		List<File> fileList = new ArrayList<File>();
//		File[] fileArray = parentFile.listFiles();
//		for (File file : fileArray) {
//			if (file.getName().endsWith(".scxml")) {
//				fileList.add(file);
//			}
//		}
//		return fileList;
//	}
//	public static void main(String[] args) {
//		try {
//			new ConfFileImpl().gatherNgxConfFile("d:\\Temp\\");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
