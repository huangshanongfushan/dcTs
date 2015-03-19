package com.duplicall.smartControl.service.card;

import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.pojo.ManagerCardInfor;

/**
 * 
 * @读取板卡类型等信息
 * @author mli
 * @date 2015年2月25日 下午4:35:27 
 * @version V1.3.1
 */
public interface ISmartCard {
    /**
     * 
     * @Description 
     * @author mli
     * @return
     * @throws ServiceException
     */
    public  ManagerCardInfor initManagerCard()
        throws ServiceException;
}
