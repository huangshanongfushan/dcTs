package com.duplicall.service.callDetail.impl;

import java.util.List;

import org.junit.Test;

import com.duplicall.dao.callDetail.ICallDetailDao;
import com.duplicall.dao.callDetail.impl.CallDetailDaoImpl;
import com.duplicall.entities.CallDetail;
import com.duplicall.exception.ServiceException;
import com.duplicall.service.callDetail.ICallDetail;

public class CallDetailImpl implements ICallDetail {
    private ICallDetailDao callDetailDaoImpl = new CallDetailDaoImpl();
    @Override
    public List<CallDetail> getCallDetail(String startTime, String endTime)
        throws ServiceException
    {
        List<CallDetail>  detailList = null;
        try {
            // 查询出所有需要处理的通话
            detailList = callDetailDaoImpl.getCallDetail(startTime, endTime);
           /* // 遍历需要处理的通话
            for (CallDetail callDetail : detailList) {
                // 主叫方信息
                Party callingParty = new Party();
                callingParty.setIpAddress(callDetail.getAgent());
                callingParty.setGenericDigits(callDetail.getExtention());
                // callingParty.setGenericDigits(callDetail.get);
                // 被叫方信息
                Party calledParty = new Party();
                calledParty.setIpAddress(callDetail.getCalledParty());
                calledParty.setGenericDigits(callDetail.getExtention());
                String agent = callDetail.getAgent();
                List<Object> callIdList = swxCallDaoImpl.getCallIdByCaseId(Long.parseLong(callDetail.getNgpUserId()), startTime, endTime);
                // 处理每个通话
                for (Object object : callIdList) {
                    // 获取每个call的Id
                    Long callid = (Long)object;
                    partyDaoImpl.updateCalledParty(callid, callingParty);
                    partyDaoImpl.updateCalledParty(callid, calledParty);
                    // swxCallDaoImpl.
                }
                
            }*/
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return detailList;
    }
    
    @Test
    public void testCallDetail() {
        String starttime = "2015-03-16 12:47:23";
        String endtime = "2015-03-16 13:47:23";
        try {
            this.getCallDetail(starttime, endtime);
        }
        catch (ServiceException e) {
            e.printStackTrace();
        }
    }
    
}
