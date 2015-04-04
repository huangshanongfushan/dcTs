package com.duplicall.service.agent.impl;

import com.duplicall.dao.agent.IAgentDao;
import com.duplicall.dao.agent.impl.AgentDaoImpl;
import com.duplicall.entities.Agent;
import com.duplicall.exception.ServiceException;
import com.duplicall.service.agent.IAgent;

public class AgentImpl implements IAgent{
    private IAgentDao agentDao = new AgentDaoImpl();

    @Override
    public String getLoginId(String agentName)
        throws ServiceException
    {
        try {
            agentDao.getAgentByAgent(agentName);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getUserId(String longId)
        throws ServiceException
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void updateAgent(Agent agent)
        throws ServiceException
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void createAgentTab()
        throws ServiceException
    {
       String sql="";
        
    }

    @Override
    public void dropAgentTab()
        throws ServiceException
    {
        // TODO Auto-generated method stub
        
    }
    
}
