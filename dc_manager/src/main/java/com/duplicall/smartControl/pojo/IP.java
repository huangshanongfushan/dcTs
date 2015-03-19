package com.duplicall.smartControl.pojo;

public class IP {
    private Integer nicId;
    
    private String nicName;
    
    // ip地址
    private String ipAddress;
    
    // 子网掩码
    private String mask;
    
    // 默认网关
    private String defaultGeteWay;
    
    // 首选dns
    private String firstDNS;
    
    // 备选dns
    private String subDNS;
    
    public String getIpAddress() {
        return ipAddress;
    }
    
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
    public String getMask() {
        return mask;
    }
    
    public void setMask(String mask) {
        this.mask = mask;
    }
    
    public String getDefaultGeteWay() {
        return defaultGeteWay;
    }
    
    public void setDefaultGeteWay(String defaultGeteWay) {
        this.defaultGeteWay = defaultGeteWay;
    }
    
    public Integer getNicId() {
        return nicId;
    }
    
    public void setNicId(Integer nicId) {
        this.nicId = nicId;
    }
    
    public String getFirstDNS() {
        return firstDNS;
    }
    
    public void setFirstDNS(String firstDNS) {
        this.firstDNS = firstDNS;
    }
    
    public String getSubDNS() {
        return subDNS;
    }
    
    public void setSubDNS(String subDNS) {
        this.subDNS = subDNS;
    }
    
    public String getNicName() {
        return nicName;
    }
    
    public void setNicName(String nicName) {
        this.nicName = nicName;
    }
    
    @Override
    public String toString() {
        return "IP [nicId=" + nicId + ", nicName=" + nicName + ", ipAddress=" + ipAddress + ", mask=" + mask + ", defaultGeteWay=" + defaultGeteWay + ", firstDNS=" + firstDNS + ", subDNS=" + subDNS
            + "]";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((defaultGeteWay == null) ? 0 : defaultGeteWay.hashCode());
        result = prime * result + ((firstDNS == null) ? 0 : firstDNS.hashCode());
        result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
        result = prime * result + ((mask == null) ? 0 : mask.hashCode());
        result = prime * result + ((subDNS == null) ? 0 : subDNS.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        IP other = (IP)obj;
        if (defaultGeteWay == null) {
            if (other.defaultGeteWay != null)
                return false;
        }
        else if (!defaultGeteWay.equals(other.defaultGeteWay))
            return false;
        if (firstDNS == null) {
            if (other.firstDNS != null)
                return false;
        }
        else if (!firstDNS.equals(other.firstDNS))
            return false;
        if (ipAddress == null) {
            if (other.ipAddress != null)
                return false;
        }
        else if (!ipAddress.equals(other.ipAddress))
            return false;
        if (mask == null) {
            if (other.mask != null)
                return false;
        }
        else if (!mask.equals(other.mask))
            return false;
        if (subDNS == null) {
            if (other.subDNS != null)
                return false;
        }
        else if (!subDNS.equals(other.subDNS))
            return false;
        return true;
    }
    
}
