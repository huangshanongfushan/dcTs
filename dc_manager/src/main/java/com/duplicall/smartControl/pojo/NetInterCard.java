package com.duplicall.smartControl.pojo;

import java.io.Serializable;

/**
 * 网卡信息
 * @Description 
 * @author mli
 * @date Jul 12, 2014 3:04:38 PM 
 * @version V1.3.1
 */
public class NetInterCard implements Serializable
{

    /** @Fields serialVersionUID: */
    private static final long serialVersionUID = 957034951746316392L;
    private String description;
    private String serviceName;
    private int choosed;
    public int getChoosed()
    {
        return choosed;
    }
    public void setChoosed(int choosed)
    {
        this.choosed = choosed;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public String getServiceName()
    {
        return serviceName;
    }
    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }
    @Override
	public String toString() {
		return "NetInterCard [description=" + description + ", serviceName="
				+ serviceName + ", choosed=" + choosed + "]";
	}
    
}
