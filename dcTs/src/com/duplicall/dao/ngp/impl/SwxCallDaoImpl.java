package com.duplicall.dao.ngp.impl;

import java.util.List;

import org.junit.Test;

import com.duplicall.dao.ngp.ISwxCallDao;
import com.duplicall.dao.util.DBUtil;
import com.duplicall.entities.Agent;
import com.duplicall.exception.ServiceException;

public class SwxCallDaoImpl implements ISwxCallDao{
    private DBUtil<Agent> dbUtil = new DBUtil<Agent>("ngp");
    @Override
    public List<Object> getCallIdByCaseId(String caseId,String startTime,String endTime)
        throws ServiceException
    {
        String sql ="SELECT id FROM laes_calls WHERE case_id = "+caseId+" AND FROM_UNIXTIME(RIGHT(callid_seq_num, 10)) BETWEEN '"+startTime+"' AND '"+endTime+"';";
        List<Object> callIdList = null;
        try {
            System.out.println(sql);
            callIdList = dbUtil.queryForList(sql, Long.class);
            return callIdList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return callIdList;
    }
    @Test
    public void testGetCallIdByCaseId(){
        /*try {
            
            System.out.println(this.getCallIdByCaseId(102));
        }
        catch (ServiceException e) {
            e.printStackTrace();
        }*/
    }
    
}
