package com.duplicall.smartControl.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duplicall.smartControl.common.constant.SuperUser;
import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.pojo.ManagerCardInfor;
import com.duplicall.smartControl.pojo.User;
import com.duplicall.smartControl.service.card.ISmartCard;

/**
 * 
 * @Description
 * @author mli
 * @date
 * @version V1.3.1
 */
@Controller
@RequestMapping("user")
public class DCUserAction {
    @Resource
    private ISmartCard smartCardImpl;
    @RequestMapping(value = "login")
    public String login(String username, String password, HttpSession session, Model model) {
        // 用户验证
        if (!(SuperUser.USERNAME.equals(username) && SuperUser.PASSWORD.equals(password))) {
            model.addAttribute("ErrorMessage", "login.fail");
            return "login";
        }
        // ManagerConf;
        User user = new User();
        user.setUserName(username);
        ManagerCardInfor managerCardInfo = null;
        try {
            managerCardInfo = smartCardImpl.initManagerCard();
            System.out.println(managerCardInfo);
        }
        catch (ServiceException e) {
            e.printStackTrace();
        }
        // 将用户存入session
        session.setAttribute("user", user);
        model.addAttribute("managerCardInfo", managerCardInfo);
        return "DC-Main";
    }
    
    @RequestMapping("exit")
    public String logoff(HttpSession session) {
        session.invalidate();
        return "login";
    }
    
    @RequestMapping("index")
    public String index() {
        return "login";
    }
}
