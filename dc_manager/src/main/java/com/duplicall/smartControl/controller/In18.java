
/**   
 * @Title: In18.java 
 * @Package: com.duplicall.smartControl.controller 
 * @Description: 测试spring MVC国际化
 * @author mli 
 * @date 2014年10月28日 上午9:21:07 
 * @update 
 * @date 2014年10月28日 上午9:21:07
 * @version 1.3.1 
 */


package com.duplicall.smartControl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @Description 
 * @author mli
 * @date 2014年10月28日 上午9:21:07 
 * @version V1.3.1
 */
@Controller
public class In18 {
    @RequestMapping("/in18.do")
    public String toStart()
    {
        return "start";
    }
    
}
