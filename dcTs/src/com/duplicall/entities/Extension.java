package com.duplicall.entities;

/**
 * 实体表
 * 
 * @Description
 * @author mli
 * @date 2015年3月13日 上午10:38:26
 * @version V1.3.1
 */
public class Extension {
    
    private String extension;
    
    private String extensionName;
    
    private String description;
    
    private int enabled;
    
    
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getExtensionName() {
		return extensionName;
	}

	public void setExtensionName(String extensionName) {
		this.extensionName = extensionName;
	}

	@Override
	public String toString() {
		return "Extension [extension=" + extension + ", extensionName="
				+ extensionName + ", description=" + description + ", enabled="
				+ enabled + "]";
	}
    
}
