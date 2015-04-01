package com.duplicall.dao.agent.impl;

import java.util.List;

import org.junit.Test;

import com.duplicall.dao.agent.IAgentDao;
import com.duplicall.dao.mapper.AgentMapper;
import com.duplicall.dao.util.DBUtil;
import com.duplicall.entities.Agent;

public class AgentDaoImpl implements IAgentDao {
    private DBUtil<Agent> dbUtil = new DBUtil<Agent>("dclog");

    @Override
    public List<Agent> getAgentList()
        throws Exception
    {
        String sql = "select * from agent";
        List<Agent> agentList = dbUtil.queryForList(sql, new AgentMapper());
        return agentList;
    }
    

    @Override
    public Agent getAgentByAgent(String agent)
        throws Exception
    {
        String sql = "select * from agent where agent='"+agent+"'";
        return dbUtil.queryForObject(sql, new AgentMapper());
    }
    @Test
    public void testGetAgent() {
        try {
            this.getAgentByAgent("192.168.1.120");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
