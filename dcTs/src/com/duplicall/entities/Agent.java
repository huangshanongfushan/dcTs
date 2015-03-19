package com.duplicall.entities;
/**
 * 
 * @Description 坐席实体
 * @author mli
 * @date 2015年3月13日 上午10:37:08 
 * @version V1.3.1
 */
public class Agent {
    private String agent;
    
    private String agentName;
    
    private String description;
    
    private int enabled;

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
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
        return "Agent [agent=" + agent + ", agentName=" + agentName + ", description=" + description + ", enabled=" + enabled + "]";
    }

}
