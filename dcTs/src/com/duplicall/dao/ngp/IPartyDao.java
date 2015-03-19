package com.duplicall.dao.ngp;

import com.duplicall.exception.DataAccessException;
import com.duplicall.pojo.Party;

public interface IPartyDao {
    /**
     * 更新answeringParty
     * @Description 
     * @author mli
     * @param callId
     * @param party
     * @throws DataAccessException
     */
    public void updateAnsweringParty(long callId,Party party)
        throws Exception ;
    
    /**
     * 更新callingParty
     * @Description 
     * @author mli
     * @param callId
     * @throws DataAccessException
     */
    public void updateCallingParty(long callId,Party party)
        throws Exception ;
    
    /**
     * 更新
     * @Description 
     * @author mli
     * @param callId
     * @throws DataAccessException
     */
    public void updateCalledParty(long callId,Party party)
        throws Exception ;
    
}
