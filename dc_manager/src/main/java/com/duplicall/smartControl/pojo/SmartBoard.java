package com.duplicall.smartControl.pojo;

import java.io.Serializable;

public class SmartBoard implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1432283072444619800L;

	private String boardType = "SmartTAP NGX";
	private String pbxType;
	private String channels;
	private String servialNumber;
	private String firmwareVersion;
	private String dChannel;
	private String termination;
	private String tdmEncoding;
	private String dateCode;

	public String getDateCode() {
		return dateCode;
	}

	public void setDateCode(String dateCode) {
		this.dateCode = dateCode;
	}

	@Override
	public String toString() {
		return "SmartBoard [boardType=" + boardType + ", pbxType=" + pbxType
				+ ", channels=" + channels + ", servialNumber=" + servialNumber
				+ ", firmwareVersion=" + firmwareVersion + ", dChannel="
				+ dChannel + ", termination=" + termination + ", tdmEncoding="
				+ tdmEncoding + ", dateCode=" + dateCode + "]";
	}
	
	public String getChannels() {
		return channels;
	}

	public void setChannels(String channels) {
		this.channels = channels;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getPbxType() {
		return pbxType;
	}

	public void setPbxType(String pbxType) {
		this.pbxType = pbxType;
	}

	public String getServialNumber() {
		return servialNumber;
	}

	public void setServialNumber(String servialNumber) {
		this.servialNumber = servialNumber;
	}

	public String getFirmwareVersion() {
		return firmwareVersion;
	}

	public void setFirmwareVersion(String firmwareVersion) {
		this.firmwareVersion = firmwareVersion;
	}

	public String getdChannel() {
		return dChannel;
	}

	public void setdChannel(String dChannel) {
		this.dChannel = dChannel;
	}

	public String getTermination() {
		return termination;
	}

	public void setTermination(String termination) {
		this.termination = termination;
	}

	public String getTdmEncoding() {
		return tdmEncoding;
	}

	public void setTdmEncoding(String tdmEncoding) {
		this.tdmEncoding = tdmEncoding;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
