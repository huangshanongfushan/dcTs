package com.duplicall.service.callDetail;

import java.util.List;

import com.duplicall.entities.CallDetail;
import com.duplicall.exception.ServiceException;

public interface ICallDetail {
    /**
     * 根据时间段查询callDetail
     * 
     * @Description
     * @author mli
     * @param startTime
     * @param endTime
     * @return
     * @throws ServiceException
     */
    public List<CallDetail> getCallDetail(String startTime, String endTime)
        throws ServiceException;
    
}
