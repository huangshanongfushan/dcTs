package com.duplicall.dao.callDetail;

import java.util.List;

import com.duplicall.entities.CallDetail;

public interface ICallDetailDao {
    /**
     * 查询多个callDetail
     * 
     * @Description
     * @author mli
     * @return
     * @throws Exception
     */
    public List<CallDetail> getCallDetail(String startTime, String endTime)
        throws Exception;
    
}
