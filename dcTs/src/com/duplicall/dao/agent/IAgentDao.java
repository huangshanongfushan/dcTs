package com.duplicall.dao.agent;

import java.util.List;

import com.duplicall.entities.Agent;

public interface IAgentDao {
    /**
     * 
     * @Description 
     * @author mli
     * @return
     * @throws Exception
     */
    public List<Agent> getAgentList()
        throws Exception;
    /**
     * 
     * @Description 
     * @author mli
     * @return
     * @throws Exception
     */
    public Agent getAgentByAgent(String agent)
        throws Exception;
    
}
