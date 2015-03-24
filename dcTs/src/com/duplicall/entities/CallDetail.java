package com.duplicall.entities;

public class CallDetail {
	@Override
	public String toString() {
		return "CallDetail [ucid=" + ucid + ", createTime=" + createTime
				+ ", callId=" + callId + ", callingParty=" + callingParty
				+ ", calledParty=" + calledParty + ", answeringParty="
				+ answeringParty + ", origCalling=" + origCalling
				+ ", origCalled=" + origCalled + ", Type=" + Type + ", agent="
				+ agent + ", extention=" + extention + ", lastDirection="
				+ lastDirection + ", skill=" + skill + ", trunk=" + trunk
				+ ", ringTime=" + ringTime + ", DialedTime=" + DialedTime
				+ ", EstablishTime=" + EstablishTime + ", endTime=" + endTime
				+ ", uui=" + uui + ", ngpUserId=" + ngpUserId + "]";
	}

	private long ucid;

	private String createTime;

	private long callId;

	private String callingParty;

	private String calledParty;

	private String answeringParty;

	private String origCalling;

	private String origCalled;

	private String Type;

	private String agent;

	private String extention;

	private String lastDirection;

	private String skill;

	private String trunk;

	private String ringTime;

	private String DialedTime;

	private String EstablishTime;

	private String endTime;

	private String uui;
	private String ngpUserId;

	public String getNgpUserId() {
		return ngpUserId;
	}

	public void setNgpUserId(String ngpUserId) {
		this.ngpUserId = ngpUserId;
	}

	public long getUcid() {
		return ucid;
	}

	public void setUcid(long ucid) {
		this.ucid = ucid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public long getCallId() {
		return callId;
	}

	public void setCallId(long callId) {
		this.callId = callId;
	}

	public String getCallingParty() {
		return callingParty;
	}

	public void setCallingParty(String callingParty) {
		this.callingParty = callingParty;
	}

	public String getCalledParty() {
		return calledParty;
	}

	public void setCalledParty(String calledParty) {
		this.calledParty = calledParty;
	}

	public String getAnsweringParty() {
		return answeringParty;
	}

	public void setAnsweringParty(String answeringParty) {
		this.answeringParty = answeringParty;
	}

	public String getOrigCalling() {
		return origCalling;
	}

	public void setOrigCalling(String origCalling) {
		this.origCalling = origCalling;
	}

	public String getOrigCalled() {
		return origCalled;
	}

	public void setOrigCalled(String origCalled) {
		this.origCalled = origCalled;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	public String getLastDirection() {
		return lastDirection;
	}

	public void setLastDirection(String lastDirection) {
		this.lastDirection = lastDirection;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getTrunk() {
		return trunk;
	}

	public void setTrunk(String trunk) {
		this.trunk = trunk;
	}

	public String getRingTime() {
		return ringTime;
	}

	public void setRingTime(String ringTime) {
		this.ringTime = ringTime;
	}

	public String getDialedTime() {
		return DialedTime;
	}

	public void setDialedTime(String dialedTime) {
		DialedTime = dialedTime;
	}

	public String getEstablishTime() {
		return EstablishTime;
	}

	public void setEstablishTime(String establishTime) {
		EstablishTime = establishTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUui() {
		return uui;
	}

	public void setUui(String uui) {
		this.uui = uui;
	}

}
