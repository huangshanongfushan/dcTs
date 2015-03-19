package com.duplicall.smartControl.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 
 * @Description
 * @author mli
 * @date Jul 1, 2014 11:59:03 AM
 * @version V1.3.1
 */
public class WinCommandUtil
{
    
    public static void writeReg()
    {
        Process process = null;
        try
        {
            // String str = "HKEY_CURRENT_USER\\Software\\alipay\\Cert\\7bade3c628f6eb7a6d70d50ee7f898d607a6fe5c";
            // 执行命令reg import
            // process = Runtime.getRuntime().exec("cmd /c reg import d://s.reg");
            process = Runtime.getRuntime().exec("d://s.reg");
            // 取得命令结果的输出流
            InputStream fis = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, " "));
            StringBuffer sb = new StringBuffer();
            String line = null;
            try
            {
                while ((line = reader.readLine()) != null)
                {
                    sb.append(line + "\n");
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    fis.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        exeuteCommand("");
    }
    
    public static InputStream exeuteCommand(String commandStr)
    {
        commandStr = "regedit /e E:/4.reg \"HKEY_LOCAL_MACHINE\\SYSTEM\\CurrentControlSet\\Services\\Ntidrv\\Devices\\DriverMajor\"";
        Process process = null;
        Runtime runtime = Runtime.getRuntime();
        InputStream fis = null;
        try
        {
            process = runtime.exec("cmd /c " + commandStr);
//            process = runtime.exec("type E://4.reg | find \"PortNumber\"");
            fis = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            StringBuffer sb = new StringBuffer();
            String line = null;
            try
            {
                while ((line = reader.readLine()) != null)
                {
                    sb.append(line + "\n");
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    fis.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        // 取得命令结果的输出流
        return fis;
    }
    
    
}
