package com.duplicall.dao.mapper;
import java.sql.ResultSet;
import com.duplicall.dao.common.IRowMapper;
import com.duplicall.entities.Agent;

public class AgentMapper implements IRowMapper<Agent> {
    
    @Override
    public Agent getResults(ResultSet rs)
        throws Exception
    {
        Agent agent = new Agent();
        agent.setAgent(rs.getString("agent"));
        agent.setAgentName(rs.getString("agentName"));
        System.out.println(agent);
        return agent;
    }
    
}
