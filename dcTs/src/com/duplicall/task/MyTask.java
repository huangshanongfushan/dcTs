package com.duplicall.task;

import java.util.List;

import com.duplicall.dao.ngp.IPartyDao;
import com.duplicall.dao.ngp.ISwxCallDao;
import com.duplicall.dao.ngp.impl.PartyDaoImpl;
import com.duplicall.dao.ngp.impl.SwxCallDaoImpl;
import com.duplicall.entities.CallDetail;
import com.duplicall.exception.ServiceException;
import com.duplicall.pojo.Party;
import com.duplicall.service.callDetail.ICallDetail;
import com.duplicall.service.callDetail.impl.CallDetailImpl;

public class MyTask extends java.util.TimerTask {
    private ICallDetail detailImpl = new CallDetailImpl();
    
    //
    private ISwxCallDao swxCallDaoImpl = new SwxCallDaoImpl();
    
    //
    private IPartyDao partyDaoImpl = new PartyDaoImpl();
    
    @Override
    public void run() {
        String startTime = "2014-03-15 12:47:23";
        String endTime = "2015-03-18 12:47:23";
        List<CallDetail> detailList = null;
        try {
            detailList = detailImpl.getCallDetail(startTime, endTime);
            System.out.println(detailList);
        }
        catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 遍历需要处理的通话
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
            List<Object> callIdList = null;
            try {
                callIdList = swxCallDaoImpl.getCallIdByCaseId(callDetail.getNgpUserId(), startTime, endTime);
                System.out.println(callIdList);
                // partyDaoImpl.up
            }
            catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (ServiceException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // 处理每个通话
            for (Object object : callIdList) {
                // 获取每个call的Id
                Long callid = (Long)object;
                try {
                    partyDaoImpl.updateCalledParty(callid, callingParty);
                    partyDaoImpl.updateCallingParty(callid, calledParty);
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }
        
        //File file = new File("");
        //写记录最后备份时间
        
    }
    
}