package com.duplicall.smartControl.pojo;

import java.io.Serializable;

/**
 * 
 * <一句话功能简述>
 * 
 * @author mli
 * @version [V1.00, 2014年7月11日]
 * @see [reference class/method]
 * @since V1.00
 */
public class SmartControlSystem implements Serializable
{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -5169283543443170982L;
    
    private String driverVersion;
    
    private String driverBuild;
    
    private String driverMajor;
    
    private String driverMinor;
    
    private String controlPanVersion;
    
    private String driverInterval;
    
    private String dcPanelVersion;
    
    public String getDcPanelVersion()
    {
        return dcPanelVersion;
    }

    public void setDcPanelVersion(String dcPanelVersion)
    {
        this.dcPanelVersion = dcPanelVersion;
    }

    public String getDriverInterval()
    {
        return driverInterval;
    }
    
    public void setDriverInterval(String driverInterval)
    {
        this.driverInterval = driverInterval;
    }
    
    public String getDriverMajor()
    {
        return driverMajor;
    }
    
    public void setDriverMajor(String driverMajor)
    {
        this.driverMajor = driverMajor;
    }
    
    public String getDriverMinor()
    {
        return driverMinor;
    }
    
    public void setDriverMinor(String driverMinor)
    {
        this.driverMinor = driverMinor;
    }
    
    public String getDriverVersion()
    {
        return driverVersion;
    }
    
    public void setDriverVersion(String driverVersion)
    {
        this.driverVersion = driverVersion;
    }
    
    public String getDriverBuild()
    {
        return driverBuild;
    }
    
    public void setDriverBuild(String driverBuild)
    {
        this.driverBuild = driverBuild;
    }
    
    public String getControlPanVersion() {
		return controlPanVersion;
	}

	public void setControlPanVersion(String controlPanVersion) {
		this.controlPanVersion = controlPanVersion;
	}

    
    @Override
	public String toString() {
		return "SmartControlSystem [driverVersion=" + driverVersion
				+ ", driverBuild=" + driverBuild + ", driverMajor="
				+ driverMajor + ", driverMinor=" + driverMinor
				+ ", controlPanVersion=" + controlPanVersion
				+ ", driverInterval=" + driverInterval + ", dcPanelVersion="
				+ dcPanelVersion + "]";
	}
}
