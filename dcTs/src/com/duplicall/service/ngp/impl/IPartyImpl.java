package com.duplicall.service.ngp.impl;

import com.duplicall.dao.ngp.IPartyDao;
import com.duplicall.dao.ngp.impl.PartyDaoImpl;
import com.duplicall.exception.ServiceException;
import com.duplicall.pojo.Party;
import com.duplicall.service.ngp.IParty;

public class IPartyImpl implements IParty {
    private IPartyDao partyDaoImpl;
    @Override
    public void updateParty(long callId, Party callingParty, Party calledParty, Party answeringParty)
        throws ServiceException
    {
        partyDaoImpl = new PartyDaoImpl();
        try {
            partyDaoImpl.updateCallingParty(callId, callingParty);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            partyDaoImpl.updateAnsweringParty(callId, calledParty);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            partyDaoImpl.updateCalledParty(callId, answeringParty);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
