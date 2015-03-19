package com.duplicall.smartControl.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.service.confFile.IConfFile;

@Controller
public class UploadController {
	private static String savePath = "/resources/files";
	private static final int BUFFER_SIZE = 2 * 1024;
	@Resource
	private IConfFile commonConfFileImpl;
	@Resource
	private IConfFile ngxConfFileImpl;
	@Resource
	private IConfFile voipConfFileImpl;
	@Resource
	private IConfFile pbxConfFileImpl;

	@RequestMapping("fileupload")
	public void upload(HttpServletRequest request,
			HttpServletResponse response, int chunk, String name, int chunks)
			throws IllegalStateException, IOException {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// String dstPath = request.getServletContext().getRealPath(
		// savePath + "\\" + name);

		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				File dstFile = new File(request.getServletContext()
						.getRealPath(
								savePath + "\\" + file.getOriginalFilename()));
				if (chunk == 0 && dstFile.exists()) {
					dstFile.delete();
					dstFile = new File(request.getServletContext().getRealPath(
							savePath + "\\" + file.getOriginalFilename()));
				}

				this.copy(file.getInputStream(), dstFile);
			}
		}
		if (chunk == chunks - 1) {
			// TODO 完成一个文件
		}
		// System.out.println("上传："+upload);
		// System.out.println("savePath："+savePath);
	}

	/**
	 * 文件拼接
	 * 
	 * @param src
	 * @param dst
	 */
	private void copy(InputStream src, File dst) {
		InputStream in = null;
		OutputStream out = null;
		try {
			if (dst.exists()) {
				out = new BufferedOutputStream(new FileOutputStream(dst, true),
						BUFFER_SIZE);
			} else {
				out = new BufferedOutputStream(new FileOutputStream(dst),
						BUFFER_SIZE);
			}
			in = new BufferedInputStream(src, BUFFER_SIZE);

			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 最后提交
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("commonSubmit")
	public void commonSubmit(HttpServletRequest request,
			HttpServletResponse response) {
		String filePath = request.getServletContext().getRealPath(savePath);
		// 本次上传文件个数
		int count = Integer.parseInt(request.getParameter("uploader_count"));
		// 遍历每个文件
		for (int i = 0; i < count; i++) {
			String uploadFileName = request.getParameter("uploader_" + i
					+ "_name");
			File srcFile = new File(filePath + "\\" + uploadFileName);
			try {
				// 转移当前遍历的文件
				commonConfFileImpl.uploadconfFile(srcFile, uploadFileName);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("ngxSubmit")
	public void ngxSubmit(HttpServletRequest request,
			HttpServletResponse response) {
		String filePath = request.getServletContext().getRealPath(savePath);
		// 本次上传文件个数
		int count = Integer.parseInt(request.getParameter("uploader_count"));
		// 遍历每个文件
		for (int i = 0; i < count; i++) {
			String uploadFileName = request.getParameter("uploader_" + i
					+ "_name");
			File srcFile = new File(filePath + "\\" + uploadFileName);
			try {
				// 转移当前遍历的文件
				ngxConfFileImpl.uploadconfFile(srcFile, uploadFileName);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping("pbxSubmit")
	public void pbxSubmit(HttpServletRequest request,
			HttpServletResponse response) {
		String filePath = request.getServletContext().getRealPath(savePath);
		// 本次上传文件个数
		int count = Integer.parseInt(request.getParameter("uploader_count"));
		// 遍历每个文件
		for (int i = 0; i < count; i++) {
			String uploadFileName = request.getParameter("uploader_" + i
					+ "_name");
			File srcFile = new File(filePath + "\\" + uploadFileName);
			try {
				// 转移当前遍历的文件
				pbxConfFileImpl.uploadconfFile(srcFile, uploadFileName);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("voipSubmit")
	public void voipSubmit(HttpServletRequest request,
			HttpServletResponse response) {
		String filePath = request.getServletContext().getRealPath(savePath);
		// 本次上传文件个数
		int count = Integer.parseInt(request.getParameter("uploader_count"));
		// 遍历每个文件
		for (int i = 0; i < count; i++) {
			String uploadFileName = request.getParameter("uploader_" + i
					+ "_name");
			File srcFile = new File(filePath + "\\" + uploadFileName);
			try {
				// 转移当前遍历的文件
				voipConfFileImpl.uploadconfFile(srcFile, uploadFileName);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
	}
}
