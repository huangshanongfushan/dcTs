package com.duplicall.entities;

public class TsConfig {
	private long interval;
	private String lastTime;
	private String enable;

	public long getInterval() {
		return interval;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "TsConfig [interval=" + interval + ", lastTime=" + lastTime
				+ ", enable=" + enable + "]";
	}

}
