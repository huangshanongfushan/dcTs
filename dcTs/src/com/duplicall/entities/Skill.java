package com.duplicall.entities;

public class Skill {
    private String skill;
    
    private String skillName;
    
    private String description;
    
    private int enabled;
    
    public String getSkill() {
        return skill;
    }
    
    public void setSkill(String skill) {
        this.skill = skill;
    }
    
    public String getSkillName() {
        return skillName;
    }
    
    public void setSkillName(String skillName) {
        this.skillName = skillName;
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
}
