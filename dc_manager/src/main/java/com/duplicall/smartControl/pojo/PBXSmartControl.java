package com.duplicall.smartControl.pojo;

import java.io.Serializable;

/**
 * 
 * @Description
 * @author mli
 * @date Jul 12, 2014 10:34:18 AM
 * @version V1.3.1
 */
public class PBXSmartControl implements Serializable
{
    
    /** @Fields serialVersionUID: */
    
    private static final long serialVersionUID = 9012700401835828293L;
    
    private int boardNumber;
    private int configurationId;
    private int busNo;
    
    private int slotNo;
    
    private int totalChannels;
    
	private String gciStartIndex;
	
	public int getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(int configurationId) {
        this.configurationId = configurationId;
    }

    public String getGciStartIndex() {
		return gciStartIndex;
	}

	public void setGciStartIndex(String gciStartIndex) {
		this.gciStartIndex = gciStartIndex;
	}
	// private String boardType="SmartTAP LD2409";
    // private int channels;
    private String serialNumber;
    
    private String firmwareVersion;
    
    
    public static long getSerialversionuid() {
		return serialVersionUID;
	}
	// private String dateCode;
    // private String buil;
    private String tdmEncoding;// 0:u-law fffffff:a-law
    
    public int getBoardNumber()
    {
        return boardNumber;
    }
    
    public void setBoardNumber(int boardNumber)
    {
        this.boardNumber = boardNumber;
    }
    
    public int getBusNo()
    {
        return busNo;
    }
    
    public void setBusNo(int busNo)
    {
        this.busNo = busNo;
    }
    
    public int getSlotNo()
    {
        return slotNo;
    }
    
    public void setSlotNo(int slotNo)
    {
        this.slotNo = slotNo;
    }
    
    public int getTotalChannels()
    {
        return totalChannels;
    }
    
    public void setTotalChannels(int totalChannels)
    {
        this.totalChannels = totalChannels;
    }
    
    public String getSerialNumber()
    {
        return serialNumber;
    }
    
    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }
    
    public String getFirmwareVersion()
    {
        return firmwareVersion;
    }
    
    public void setFirmwareVersion(String firmwareVersion)
    {
        this.firmwareVersion = firmwareVersion;
    }
    
    public String getTdmEncoding()
    {
        return tdmEncoding;
    }
    
    public void setTdmEncoding(String tdmEncoding)
    {
        this.tdmEncoding = tdmEncoding;
    }

    @Override
    public String toString() {
        return "PBXSmartControl [boardNumber=" + boardNumber + ", configurationId=" + configurationId + ", busNo=" + busNo + ", slotNo=" + slotNo + ", totalChannels=" + totalChannels
            + ", gciStartIndex=" + gciStartIndex + ", serialNumber=" + serialNumber + ", firmwareVersion=" + firmwareVersion + ", tdmEncoding=" + tdmEncoding + "]";
    }
    
}
