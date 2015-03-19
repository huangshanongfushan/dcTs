package com.duplicall.swxapi.impl;

import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.junit.Test;

import com.duplicall.swxapi.IResource;

public class ResourceImpl implements IResource{
    
    @Override
    public String getResources(String uri, int timeOut)
        throws Exception
    {
        String resultStr = null;
        String username = "admin";
        String password = "admin";
        HttpClient httpClient = new HttpClient();
        // 通过验证的用户名和密码
        httpClient.getState().setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials(username,
                        password));
        // Get请求，以及对应资源的URI
        GetMethod getMethod = new GetMethod(uri);
        getMethod.setDoAuthentication(true);
        // 设定请求返回数据的格式
        getMethod.setRequestHeader("Accept", "application/json");
        getMethod.setRequestHeader("Cache-Control", "no-cache");
        try {
            // 请求返回状态码，表名请求是否成功
            int responseCode = httpClient.executeMethod(getMethod);
            System.out.println(responseCode);
            // 如果是返回200，则请求成功
            if ((responseCode+"").startsWith("2")) {
                // 得到请求返回的json数据
                resultStr = getMethod.getResponseBodyAsString();
                return resultStr;
            }
        } catch (Exception e) {
        }
        return resultStr;
    }

    @Override
    public Map<Boolean, String> getResource(String uri, int timeOut)
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Test
    public void testGetResources(){
        String uri = "http://192.168.1.117/rs/audiocodes/recorder/managed_devices/info";
        try {
            this.getResources(uri, 5000);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
