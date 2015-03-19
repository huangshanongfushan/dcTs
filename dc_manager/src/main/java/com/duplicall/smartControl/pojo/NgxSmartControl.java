package com.duplicall.smartControl.pojo;

public class NgxSmartControl {
    private int configurationId;
    private String busNo;
    private String slotNo;
	private SmartBoard boardBase;
	private SmartBoard boardDC1;
	private SmartBoard boardDC2;

    public int getConfigurationId() {
        return configurationId;
    }

    public void setConfigurationId(int configurationId) {
        this.configurationId = configurationId;
    }


    public SmartBoard getBoardBase() {
		return boardBase;
	}

	public void setBoardBase(SmartBoard boardBase) {
		this.boardBase = boardBase;
	}

	public SmartBoard getBoardDC1() {
		return boardDC1;
	}

	public void setBoardDC1(SmartBoard boardDC1) {
		this.boardDC1 = boardDC1;
	}

	public SmartBoard getBoardDC2() {
		return boardDC2;
	}

	public void setBoardDC2(SmartBoard boardDC2) {
		this.boardDC2 = boardDC2;
	}

	public String getBusNo() {
        return busNo;
    }

    public void setBusNo(String busNo) {
        this.busNo = busNo;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(String slotNo) {
        this.slotNo = slotNo;
    }

    @Override
    public String toString() {
        return "NgxSmartControl [configurationId=" + configurationId + ", busNo=" + busNo + ", slotNo=" + slotNo + ", boardBase=" + boardBase + ", boardDC1=" + boardDC1 + ", boardDC2=" + boardDC2
            + "]";
    }

}
