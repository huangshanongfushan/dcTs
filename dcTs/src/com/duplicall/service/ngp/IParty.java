package com.duplicall.service.ngp;

import com.duplicall.exception.ServiceException;
import com.duplicall.pojo.Party;

public interface IParty {
    /**
     * 
     * @Description 更新主被叫信息
     * @author mli
     * @param callId
     * @param callingParty
     * @param calledParty
     * @param answeringParty
     * @throws ServiceException
     */
    public void updateParty(long callId, Party callingParty, Party calledParty, Party answeringParty)
        throws ServiceException;
}
