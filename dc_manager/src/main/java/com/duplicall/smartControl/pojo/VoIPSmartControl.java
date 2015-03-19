package com.duplicall.smartControl.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description
 * @author mli
 * @date Jul 12, 2014 2:34:53 PM
 * @version V1.3.1
 */
public class VoIPSmartControl implements Serializable {
	/** @Fields serialVersionUID: */

	private static final long serialVersionUID = 6819291884287503235L;

	private int boardNumber;

	private String boardType = "HPX";

	private String boardVersion;

	private String boadrdBuild;

	private List<NetInterCard> port0NicList = new ArrayList<NetInterCard>();

	private List<NetInterCard> port1NicList = new ArrayList<NetInterCard>();

	private int monitorPort0Enable;

	private int monitorPort1Enable;

	private NetInterCard monitorPort0Selected;

	private NetInterCard monitorPort1Selected;

	private int rtpEnable = 1;

	private String rtpTimeOut;

	private int rtcpQos = 1;// default enable 值为1

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public String getBoardType() {
		return boardType;
	}

	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}

	public String getBoardVersion() {
		return boardVersion;
	}

	public void setBoardVersion(String boardVersion) {
		this.boardVersion = boardVersion;
	}

	public String getBoadrdBuild() {
		return boadrdBuild;
	}

	public void setBoadrdBuild(String boadrdBuild) {
		this.boadrdBuild = boadrdBuild;
	}

	public List<NetInterCard> getPort0NicList() {
		return port0NicList;
	}

	public void setPort0NicList(List<NetInterCard> port0NicList) {
		this.port0NicList = port0NicList;
	}

	public List<NetInterCard> getPort1NicList() {
		return port1NicList;
	}

	public void setPort1NicList(List<NetInterCard> port1NicList) {
		this.port1NicList = port1NicList;
	}

	public int getMonitorPort0Enable() {
		return monitorPort0Enable;
	}

	public void setMonitorPort0Enable(int monitorPort0Enable) {
		this.monitorPort0Enable = monitorPort0Enable;
	}

	public int getMonitorPort1Enable() {
		return monitorPort1Enable;
	}

	public void setMonitorPort1Enable(int monitorPort1Enable) {
		this.monitorPort1Enable = monitorPort1Enable;
	}

	public NetInterCard getMonitorPort0Selected() {
		return monitorPort0Selected;
	}

	public void setMonitorPort0Selected(NetInterCard monitorPort0Selected) {
		this.monitorPort0Selected = monitorPort0Selected;
	}

	public NetInterCard getMonitorPort1Selected() {
		return monitorPort1Selected;
	}

	public void setMonitorPort1Selected(NetInterCard monitorPort1Selected) {
		this.monitorPort1Selected = monitorPort1Selected;
	}

	public int getRtpEnable() {
		return rtpEnable;
	}

	public void setRtpEnable(int rtpEnable) {
		this.rtpEnable = rtpEnable;
	}

	public String getRtpTimeOut() {
		return rtpTimeOut;
	}

	public void setRtpTimeOut(String rtpTimeOut) {
		this.rtpTimeOut = rtpTimeOut;
	}

	public int getRtcpQos() {
		return rtcpQos;
	}

	public void setRtcpQos(int rtcpQos) {
		this.rtcpQos = rtcpQos;
	}

	@Override
	public String toString() {
		return "VoIPSmartControl [boardNumber=" + boardNumber + ", boardType="
				+ boardType + ", boardVersion=" + boardVersion
				+ ", boadrdBuild=" + boadrdBuild + ", port0NicList="
				+ port0NicList + ", port1NicList=" + port1NicList
				+ ", monitorPort0Enable=" + monitorPort0Enable
				+ ", monitorPort1Enable=" + monitorPort1Enable
				+ ", monitorPort0Selected=" + monitorPort0Selected
				+ ", monitorPort1Selected=" + monitorPort1Selected
				+ ", rtpEnable=" + rtpEnable + ", rtpTimeOut=" + rtpTimeOut
				+ ", rtcpQos=" + rtcpQos + "]";
	}
	

}
