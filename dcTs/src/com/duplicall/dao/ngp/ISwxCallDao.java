package com.duplicall.dao.ngp;

import java.util.List;

import com.duplicall.exception.ServiceException;

public interface ISwxCallDao {
    /**
     * 
     * @Description 
     * @author mli
     * @param caseId
     * @return
     */
    public List<Object> getCallIdByCaseId(String caseId,String starteTime,String endTime)
        throws ServiceException;
    
}
