package com.duplicall.smartControl.entity;

public class Ngx {
	private int mtxBrdNumber;
	private String busNumber;
	private String boarNumber;
	private int totalChanels;
	public int getMtxBrdNumber() {
		return mtxBrdNumber;
	}
	public void setMtxBrdNumber(int mtxBrdNumber) {
		this.mtxBrdNumber = mtxBrdNumber;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}
	public String getBoarNumber() {
		return boarNumber;
	}
	public void setBoarNumber(String boarNumber) {
		this.boarNumber = boarNumber;
	}
	public int getTotalChanels() {
		return totalChanels;
	}
	public void setTotalChanels(int totalChanels) {
		this.totalChanels = totalChanels;
	}
	@Override
	public String toString() {
		return "Ngx [mtxBrdNumber=" + mtxBrdNumber + ", busNumber=" + busNumber
				+ ", boarNumber=" + boarNumber + ", totalChanels="
				+ totalChanels + "]";
	}
	
}
