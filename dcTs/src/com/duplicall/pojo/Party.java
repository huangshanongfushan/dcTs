package com.duplicall.pojo;

import java.io.Serializable;

/**
 * 
 * @Description 
 * @author mli
 * @date 2015年3月16日 下午12:09:15 
 * @version V1.3.1
 */
public class Party implements Serializable{
    
    /** @Fields serialVersionUID: */
      	
    private static final long serialVersionUID = -1717186080005779960L;

    private String genericDigits;

    private String ipAddress;

    public String getGenericDigits() {
        return genericDigits;
    }

    public void setGenericDigits(String genericDigits) {
        this.genericDigits = genericDigits;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "Party [genericDigits=" + genericDigits + ", ipAddress=" + ipAddress + "]";
    }

    public Party() {
        super();
    }

    public Party(String genericDigits, String ipAddress) {
        super();
        this.genericDigits = genericDigits;
        this.ipAddress = ipAddress;
    }
}
