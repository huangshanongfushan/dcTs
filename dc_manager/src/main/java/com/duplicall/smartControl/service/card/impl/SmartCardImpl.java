package com.duplicall.smartControl.service.card.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duplicall.smartControl.common.util.CommandRegUtil;
import com.duplicall.smartControl.exception.ServiceException;
import com.duplicall.smartControl.pojo.ManagerCardInfor;
import com.duplicall.smartControl.pojo.Ngx;
import com.duplicall.smartControl.pojo.Pbx;
import com.duplicall.smartControl.pojo.Voip;
import com.duplicall.smartControl.service.card.ISmartCard;
@Service
public class SmartCardImpl implements ISmartCard{
    public  ManagerCardInfor managerCardInfo;
    public static void main(String[] args) {
        try {
            System.out.println(new SmartCardImpl().initManagerCard());
        }
        catch (ServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 获取bus slot 用以判断板卡类型
     * @Description 
     * @author mli
     * @param commandStr
     * @return
     */
    public List<String> getBusList(String commandStr)
    {
        Process process = null;
        InputStream fis = null;
        List<String> results = new ArrayList<String>();
        try
        {
            process = Runtime.getRuntime().exec("cmd /c " + commandStr);
            fis = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                // 正則，用空格分開字符串
                line = line.substring(line.lastIndexOf("\\") + 1);
                
                if((line==null||!line.contains("Bus"))){
                    continue;
                }
                results.add(line.trim());
            }
            return results;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public  ManagerCardInfor initManagerCard()
        throws ServiceException
    {
        List<Pbx> pbxList = new ArrayList<Pbx>();
        List<Ngx> ngxList = new ArrayList<Ngx>();
        List<Voip> voipList = new ArrayList<Voip>();
        SmartCardImpl sci= new SmartCardImpl();
        List<String> resultList = sci.getBusList("reg query HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\MtxBrd");
            for(String line:resultList){
               /* String active = CommandRegUtil.regValue("reg query HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\MtxBrd"+"\\"+line+" | find /i \"ActiveStatus\"");
                if("0x0".equals(active.trim())){
                    continue;
                }*/
                String confiId = CommandRegUtil.regValue("reg query HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\MtxBrd"+"\\"+line+" | find /i \"ConfigurationId\"");
                int configId = Integer.parseInt(confiId.substring(2), 10);
                line = line.replace("Bus", " ");
                line = line.replace("Slot", " ");
                String[] temp = line.trim().split(" ");
                String assemblyNum = CommandRegUtil.regValue("reg query HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\MtxBrd"+"\\"+configId+" | find /i \"AssemblyNumber\"");
                
                if(assemblyNum.startsWith("152-115")){
                    Pbx pbx = new Pbx();
                    pbx.setBusno(temp[0]);
                    pbx.setSlotno(temp[1]);
                    pbx.setConfigurationId(configId);
                    pbxList.add(pbx);
                    continue;
                }
                //
                if(assemblyNum.startsWith("152-1024-001")){
                    Ngx ngx = new Ngx();
                    ngx.setBusno(temp[0]);
                    ngx.setSlotno(temp[1]);
                    ngx.setConfigurationId(configId);
                    ngxList.add(ngx);
                    continue;
                }
                //Ip卡初始化
                if(assemblyNum.startsWith("153-0010-001")){
                    Voip voip = new Voip();
                    voip.setBusno(temp[0]);
                    voip.setSlotno(temp[1]);
                    voip.setConfigurationId(configId);
                    voipList.add(voip);
                    continue;
                }
//               System.out.println(Integer.parseInt(confiId.substring(2), 10));
            }
            //初始返回结果
            managerCardInfo = new ManagerCardInfor();
            if(pbxList.size()>0){
                managerCardInfo.setPbxList(pbxList);
            }
            if(ngxList.size()>0){
                managerCardInfo.setNgxList(ngxList);
            }
            if(voipList.size()>0){
                managerCardInfo.setVoipList(voipList);
            }
        return managerCardInfo;
    }
    
}
