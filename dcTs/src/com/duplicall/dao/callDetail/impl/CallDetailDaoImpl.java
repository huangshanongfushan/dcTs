package com.duplicall.dao.callDetail.impl;

import java.util.List;

import org.junit.Test;

import com.duplicall.dao.callDetail.ICallDetailDao;
import com.duplicall.dao.mapper.CallDetailMapper;
import com.duplicall.dao.util.DBUtil;
import com.duplicall.entities.CallDetail;

public class CallDetailDaoImpl implements ICallDetailDao {
    private DBUtil<CallDetail> dbUtil = new DBUtil<CallDetail>("dclog");
    
    @Override
    public List<CallDetail> getCallDetail(String startTime, String endTime)
        throws Exception
    {
//        String sql = "select b.agentname,a.* from calldetail a,agent b where a.createTime between '" + startTime + "' AND '" + endTime + "'";
        String sql = "SELECT b.agentname,a.* FROM calldetail a, agent b WHERE b.agent = a.agent AND a.createTime BETWEEN '"+startTime+"' AND '"+endTime+"'";
        List<CallDetail> callDetailList = dbUtil.queryForList(sql, new CallDetailMapper());
        return callDetailList;
    }
    
    @Test
    public void testGetCallDetail() {
        try {
            String starttime = "2015-03-16 12:47:23";
            String endtime = "2015-03-16 13:47:23";
            List<CallDetail> callDetail = this.getCallDetail(starttime, endtime);
            System.out.println(callDetail);
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
