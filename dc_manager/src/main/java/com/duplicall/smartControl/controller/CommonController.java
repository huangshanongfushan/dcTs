/**
 * @Title: CommonController.java
 * @Package: com.duplicall.smartControl.controller
 * @Description: TODO
 * @author mli
 * @date 2014年10月27日 下午4:00:20
 * @update
 * @date 2014年10月27日 下午4:00:20
 * @version 1.3.1
 */

package com.duplicall.smartControl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @author mli
 * @date 2014年10月27日 下午4:00:20
 * @version V1.3.1
 */
@Controller
public class CommonController {
    /**
     * 
     * @Description
     * @author mli
     * @return
     */
    @RequestMapping("index")
    public String toLogin() {
        return "login";
    }
    
}
