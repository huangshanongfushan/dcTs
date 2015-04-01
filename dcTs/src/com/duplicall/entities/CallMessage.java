package com.duplicall.entities;

/**
 * 记录主被叫Id
 * 
 * @author mli
 * 
 */
public class CallMessage {
	private long id;
	private long callingPartyId; // 主叫对应的party Id
	private long calledPartyId; // 被叫对应的party Id

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCallingPartyId() {
		return callingPartyId;
	}

	public void setCallingPartyId(long callingPartyId) {
		this.callingPartyId = callingPartyId;
	}

	public long getCalledPartyId() {
		return calledPartyId;
	}

	public void setCalledPartyId(long calledPartyId) {
		this.calledPartyId = calledPartyId;
	}

	@Override
	public String toString() {
		return "CallMessage [id=" + id + ", callingPartyId=" + callingPartyId
				+ ", calledPartyId=" + calledPartyId + "]";
	}


}
