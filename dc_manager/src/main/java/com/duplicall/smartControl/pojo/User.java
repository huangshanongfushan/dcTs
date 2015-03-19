
/**   
 * @Title: User.java 
 * @Package: com.duplicall.smartControl.pojo 
 * @Description: TODO
 * @author mli 
 * @date 2014年10月27日 下午6:33:23 
 * @update 
 * @date 2014年10月27日 下午6:33:23
 * @version 1.3.1 
 */


package com.duplicall.smartControl.pojo;

import java.io.Serializable;

/** 
 * @Description 
 * @author mli
 * @date 2014年10月27日 下午6:33:23 
 * @version V1.3.1
 */

public class User implements Serializable{
    /** @Fields serialVersionUID: */
    private static final long serialVersionUID = -1672653387197489463L;
    private String userName;
    private String password;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User [userName=" + userName + ", password=" + password + "]";
    }
    
    
}
