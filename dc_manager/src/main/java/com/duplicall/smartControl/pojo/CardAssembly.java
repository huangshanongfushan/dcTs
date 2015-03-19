package com.duplicall.smartControl.pojo;

import java.util.List;

/**
 * 板卡类型及对应的assemblynumber信息，会从配置文件中读取
 * 
 * @Description
 * @author mli
 * @date 2015年2月10日 上午11:23:18
 * @version V1.3.1
 */
public class CardAssembly {
    // 板卡类型，LD，NGX，IP
    private String cardType;
    
    // 各板卡对应的assembly号码
    private List<String> assemblyNumber;
    
    public String getCardType() {
        return cardType;
    }
    
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
    
    public List<String> getAssemblyNumber() {
        return assemblyNumber;
    }
    
    public void setAssemblyNumber(List<String> assemblyNumber) {
        this.assemblyNumber = assemblyNumber;
    }
    
    public CardAssembly() {
        
    }
    
    public CardAssembly(String cardType, List<String> assemblyNumber) {
        this.cardType = cardType;
        this.assemblyNumber = assemblyNumber;
    }
    
}
