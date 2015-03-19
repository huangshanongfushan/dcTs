package com.duplicall.smartControl.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.duplicall.smartControl.service.common.CommonConfigFile;

@Controller
public class TestController {
	@RequestMapping("testup")
	public String testUp(@RequestParam MultipartFile[] filedata,
			HttpServletRequest request) {
		for (MultipartFile myfile : filedata) {
			// FileCopyUtils.copy(in, out);
			if (myfile.isEmpty()) {
			} else {
				// 如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中
				// String realPath = request.getSession().getServletContext()
				// .getRealPath("root");
				String path = request.getServletContext().getRealPath("files");
				// FileCopyUtils.copy
				// //
				// 这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉，我是看它的源码才知道的
				System.out.println(myfile.getOriginalFilename());
				try {
					if ("dcdecode.dll".equals(myfile.getOriginalFilename())) {
						FileUtils.copyInputStreamToFile(
								myfile.getInputStream(),
								CommonConfigFile.decdecodeFile);
						continue;
					}
					if ("SmrtwrksSrvc.exe".equals(myfile.getOriginalFilename())) {
						System.out.println("00000");
						System.out.println(CommonConfigFile.smrtwrksSrvc.getPath().substring(0,CommonConfigFile.smrtwrksSrvc.getPath().lastIndexOf("\\")));
						FileUtils.copyInputStreamToFile(
								myfile.getInputStream(),
								new File(CommonConfigFile.smrtwrksSrvc.getPath().substring(0,CommonConfigFile.smrtwrksSrvc.getPath().lastIndexOf("\\"))));
						continue;
					}
					if (myfile.getOriginalFilename().endsWith(".dat")) {
						System.out.println("666666666666");
						FileUtils.copyInputStreamToFile(
								myfile.getInputStream(),
								new File(CommonConfigFile.systemDatFile
										.getPath()
										+ "/"
										+ myfile.getOriginalFilename()));
						System.out.println(CommonConfigFile.systemDatFile
										.getPath()
										+ "/"
										+ myfile.getOriginalFilename());
						continue;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "testpage";
	}
}
