package com.duplicall.smartControl.pojo;

public class Card {
	private String boardNumber;
	private String busno;
	private String slotno;
	private int configurationId;
    public String getBoardNumber() {
        return boardNumber;
    }
    public void setBoardNumber(String boardNumber) {
        this.boardNumber = boardNumber;
    }
    public String getBusno() {
        return busno;
    }
    public void setBusno(String busno) {
        this.busno = busno;
    }
    public String getSlotno() {
        return slotno;
    }
    public void setSlotno(String slotno) {
        this.slotno = slotno;
    }
    public int getConfigurationId() {
        return configurationId;
    }
    public void setConfigurationId(int configurationId) {
        this.configurationId = configurationId;
    }
    @Override
    public String toString() {
        return "Card [boardNumber=" + boardNumber + ", busno=" + busno + ", slotno=" + slotno + ", configurationId=" + configurationId + "]";
    }
}
