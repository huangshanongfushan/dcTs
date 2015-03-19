package com.duplicall.smartControl.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.pojo.User;
import com.duplicall.smartControl.pojo.VoIPSmartControl;
import com.duplicall.smartControl.service.smartControl.impl.SmartControlImpl;

@Controller
@RequestMapping("voip")
public class DCVoIPController {
	@Resource
	private SmartControlImpl smartControlImpl;
	@RequestMapping("updateVoip.do")
	public void updateVoip(PrintWriter out,VoIPSmartControl voIPSmartControl,
			String monitor0Selected,String monitorProt1Selected, HttpSession session) {
		User user = (User) session.getAttribute("user");
		System.out.println(voIPSmartControl);
		try {
			//更新voip
			smartControlImpl.updateVoIp(user, null);
			out.print("success");
		} catch (ServiceException e) {
			out.print("fail");
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

}
