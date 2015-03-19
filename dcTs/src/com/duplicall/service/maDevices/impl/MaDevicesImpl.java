package com.duplicall.service.maDevices.impl;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.duplicall.exception.ServiceException;
import com.duplicall.service.maDevices.IMaDevices;
import com.duplicall.swxapi.IResource;
import com.duplicall.swxapi.impl.ResourceImpl;

public class MaDevicesImpl implements IMaDevices {
    private IResource resourceImpl = new ResourceImpl();
    
    private static String port = "12161";
    
    private static String managedDevicesuri = "http://192.168.1.117/rs/audiocodes/recorder/managed_devices/info";
    
    @Override
    public long getCallDeliveryId()
        throws ServiceException
    {
        String resultStr = null;
        try {
            resultStr = resourceImpl.getResources(managedDevicesuri, 5000);
            System.out.println(resultStr);
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObjSplit;
            jsonObjSplit = new JSONObject(resultStr);
            jsonArray = jsonObjSplit.getJSONArray("managedDevices"); // 遍历
            if (jsonArray.length() > 0) {
                // 遍历json数组
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject manaDeJson = (JSONObject)jsonArray.get(i);
                    // 判断当前managedDevice 是否为类型是否为Ip的
                    if (port.equals(manaDeJson.getString("port"))) {
                        return manaDeJson.getLong("id");
                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    @Override
    public JSONArray getmapping(long callDeliveryId)
        throws ServiceException
    {
        String callDeliveryurl = "http://192.168.1.117/rs/audiocodes/recorder/managed_devices/call_delivery/" + callDeliveryId + "/target_mapping";
        String resultStr = null;
        try {
            resultStr = resourceImpl.getResources(callDeliveryurl, 5000);
            JSONArray jsonArray = new JSONArray();
            JSONObject jsonObjSplit;
            jsonObjSplit = new JSONObject(resultStr);
            jsonArray = jsonObjSplit.getJSONArray("entries"); // 遍历
            return jsonArray;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Test
    public void testGetCallDeli() {
        try {
            this.getmapping(9);
        }
        catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
