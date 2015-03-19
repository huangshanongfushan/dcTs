package com.duplicall.smartControl.pojo;

import java.util.List;

public class ManagerCardInfor {
    private List<Ngx> ngxList;
    
    private List<Voip> voipList;
    
    private List<Pbx> pbxList;
    
    public List<Ngx> getNgxList() {
        return ngxList;
    }
    
    public void setNgxList(List<Ngx> ngxList) {
        this.ngxList = ngxList;
    }
    
    public List<Voip> getVoipList() {
        return voipList;
    }
    
    public void setVoipList(List<Voip> voipList) {
        this.voipList = voipList;
    }
    
    public List<Pbx> getPbxList() {
        return pbxList;
    }
    
    public void setPbxList(List<Pbx> pbxList) {
        this.pbxList = pbxList;
    }

    @Override
    public String toString() {
        return "ManagerCardInfor [ngxList=" + ngxList + ", voipList=" + voipList + ", pbxList=" + pbxList + "]";
    }
    
}
