package com.duplicall.entities;

/**
 * 实体表
 * 
 * @Description
 * @author mli
 * @date 2015年3月13日 上午10:38:26
 * @version V1.3.1
 */
public class Extention {
    
    private String extention;
    
    private String extentionName;
    
    private String description;
    
    private int enabled;
    
    public String getExtention() {
        return extention;
    }
    
    public void setExtention(String extention) {
        this.extention = extention;
    }
    
    public String getExtentionName() {
        return extentionName;
    }
    
    public void setExtentionName(String extentionName) {
        this.extentionName = extentionName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getEnabled() {
        return enabled;
    }
    
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    
    @Override
    public String toString() {
        return "Extention [extention=" + extention + ", extentionName=" + extentionName + ", description=" + description + ", enabled=" + enabled + "]";
    }
    
}
