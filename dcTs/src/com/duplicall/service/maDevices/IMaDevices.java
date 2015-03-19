package com.duplicall.service.maDevices;

import org.json.JSONArray;

import com.duplicall.exception.ServiceException;

/**
 * 处理managed_devices api
 * 
 * @Description
 * @author mli
 * @date 2015年3月18日 上午10:53:57
 * @version V1.3.1
 */
public interface IMaDevices {
    /**
     * 查询录callDeliveryId
     * @Description 
     * @author mli
     * @return
     * @throws ServiceException
     */
    public long getCallDeliveryId()
        throws ServiceException;
    /**
     * 
     * @Description 
     * @author mli
     * @param callDeliveryId
     * @return
     * @throws ServiceException
     */
    public JSONArray getmapping(long callDeliveryId)
        throws ServiceException;
}
