package com.duplicall.smartControl.controller;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.pojo.IP;
import com.duplicall.smartControl.service.smartControl.impl.SmartControlImpl;

@Controller
@Scope("prototype")
public class DCIpAction implements Serializable {

	/** @Fields serialVersionUID: */

	private static final long serialVersionUID = -411008512370711597L;

	@Resource
	private SmartControlImpl smartControlImpl;

	private String resultStr;

	public String getResultStr() {
		return resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}

	/**
	 * 
	 * @Description
	 * @author mli
	 * @return
	 */
	@RequestMapping("ipInformation")
	public String getIPView(Model model) {
		List<String> nicList = null;
		List<IP> ipList = new ArrayList<IP>();
		try {
			nicList = smartControlImpl.getNICList();
			if (nicList == null || nicList.size() < 1) {
				return "";
			}
			for (String nicName : nicList) {
				IP ip = smartControlImpl.getIpInformation(nicName);
				ip.setNicName(nicName);
				ipList.add(ip);
			}
			model.addAttribute("ipList", ipList);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "nicSetting";
	}

	@RequestMapping("updateIp.do")
	public void updateIPInformation(IP ip, PrintWriter out) {
		try {
			if (smartControlImpl.updateIp(ip)) {
				out.write("success");
			}
			out.write("fail");
		} catch (ServiceException e) {
			out.write("fail");
		} finally {
			out.close();
		}
	}

	@RequestMapping("restartOs.do")
	public void restartOs(PrintWriter out) {
		try {
			smartControlImpl.restartOs();
			out.write("success");
			out.flush();
			out.close();
		} catch (ServiceException e) {
			out.write("fail");
		}
	}

	@RequestMapping("shutdown.do")
	public void shutdown(PrintWriter out) {
		try {
			smartControlImpl.shutdownOs();
			out.write("success");
			out.flush();
			out.close();
		} catch (ServiceException e) {
			out.write("fail");
		}
	}
}
