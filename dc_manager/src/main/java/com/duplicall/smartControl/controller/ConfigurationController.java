package com.duplicall.smartControl.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duplicall.smartControl.common.util.ZipUtil;
import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.service.confFile.IConfFile;

@Controller
@RequestMapping("conf")
public class ConfigurationController {
	@Resource
	private IConfFile commonConfFileImpl;
	@Resource
    private IConfFile ngxConfFileImpl;
	@Resource
    private IConfFile pbxConfFileImpl;
	@Resource
    private IConfFile voipConfFileImpl;
	@RequestMapping("downloadCommonConf")
	public void downloadCommonConf(HttpServletRequest request,
			HttpServletResponse response) {
		String ctxPath = request.getSession().getServletContext()
				.getRealPath("");
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
		    commonConfFileImpl.gatherConfFile("d:\\temp\\");
			ZipUtil.toZip("d:\\temp\\", "d:\\commonConf.zip");
			// 获取下载文件露肩(未压缩前)
			String filepath = "d:\\commonConf.zip";

			// 获取文件的长度
			long fileLength = new File(filepath).length();
			// 设置文件输出类型
			response.setContentType("application/octet-stream");
			response.setHeader("Content-disposition", "attachment; filename="
					+ "commonConf.zip");
			// 设置输出长度
			response.setHeader("Content-Length", String.valueOf(fileLength));
			// 获取输入流
			bis = new BufferedInputStream(new FileInputStream(
					"d:\\commonConf.zip"));
			// 输出流
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
			// 关闭流
			bis.close();
			bos.close();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
		    e.printStackTrace();
		}

	}
	
	@RequestMapping("downloadCommonConf")
    public void downloadNgxConf(HttpServletRequest request,
            HttpServletResponse response) {
        String ctxPath = request.getSession().getServletContext()
                .getRealPath("");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
          ngxConfFileImpl.gatherConfFile("d:\\temp\\");
            ZipUtil.toZip("d:\\temp\\", "d:\\commonConf.zip");
            // 获取下载文件露肩(未压缩前)
            String filepath = "d:\\commonConf.zip";

            // 获取文件的长度
            long fileLength = new File(filepath).length();
            // 设置文件输出类型
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename="
                    + "commonConf.zip");
            // 设置输出长度
            response.setHeader("Content-Length", String.valueOf(fileLength));
            // 获取输入流
            bis = new BufferedInputStream(new FileInputStream(
                    "d:\\commonConf.zip"));
            // 输出流
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            // 关闭流
            bis.close();
            bos.close();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	
	@RequestMapping("downloadCommonConf")
    public void downloadPbxConf(HttpServletRequest request,
            HttpServletResponse response) {
        String ctxPath = request.getSession().getServletContext()
                .getRealPath("");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
          pbxConfFileImpl.gatherConfFile("d:\\temp\\");
            ZipUtil.toZip("d:\\temp\\", "d:\\commonConf.zip");
            // 获取下载文件露肩(未压缩前)
            String filepath = "d:\\commonConf.zip";

            // 获取文件的长度
            long fileLength = new File(filepath).length();
            // 设置文件输出类型
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename="
                    + "commonConf.zip");
            // 设置输出长度
            response.setHeader("Content-Length", String.valueOf(fileLength));
            // 获取输入流
            bis = new BufferedInputStream(new FileInputStream(
                    "d:\\commonConf.zip"));
            // 输出流
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            // 关闭流
            bis.close();
            bos.close();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	@RequestMapping("downloadCommonConf")
    public void downloadVoipConf(HttpServletRequest request,
            HttpServletResponse response) {
        String ctxPath = request.getSession().getServletContext()
                .getRealPath("");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            voipConfFileImpl.gatherConfFile("d:\\temp\\");
            ZipUtil.toZip("d:\\temp\\", "d:\\commonConf.zip");
            // 获取下载文件露肩(未压缩前)
            String filepath = "d:\\commonConf.zip";

            // 获取文件的长度
            long fileLength = new File(filepath).length();
            // 设置文件输出类型
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment; filename="
                    + "commonConf.zip");
            // 设置输出长度
            response.setHeader("Content-Length", String.valueOf(fileLength));
            // 获取输入流
            bis = new BufferedInputStream(new FileInputStream(
                    "d:\\commonConf.zip"));
            // 输出流
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
            // 关闭流
            bis.close();
            bos.close();
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
