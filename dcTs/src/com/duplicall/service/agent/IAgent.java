package com.duplicall.service.agent;

import com.duplicall.entities.Agent;
import com.duplicall.exception.ServiceException;

public interface IAgent {
    /**
     * 
     * @Description 在dclog 数据库中，根据callDetail表中的的agent,获得user 在ngp对应的longId/主键id
     * @author mli
     * @param agentName
     * @return
     * @throws ServiceException
     */
    public String getLoginId(String agentName)
        throws ServiceException;
    
    /**
     * 
     * @Description 在ngp数据库中，根据longId 获得User 的主键Id
     * @author mli
     * @param agentName
     * @return
     * @throws ServiceException
     */
    public long getUserId(String longId)
        throws ServiceException;
  /**
   * 更新agent
   * @Description 
   * @author mli
   * @param agent
   * @throws ServiceException
   */
    public void updateAgent(Agent agent)
        throws ServiceException;
    /**
     * 创建agentTab
     * @Description 
     * @author mli
     * @throws ServiceException
     */
    public void createAgentTab()
        throws ServiceException;
    /**
     * 刪除agent表
     * @Description 
     * @author mli
     * @throws ServiceException
     */
    public void dropAgentTab()
        throws ServiceException;
    
}
