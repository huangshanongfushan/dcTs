package com.duplicall.smartControl.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 操作注册表
 * 
 * @author mli
 * @version [V1.00, 2014年7月11日]
 * @see [reference class/method]
 * @since V1.00
 */
public class CommandRegUtil
{
    public static String regValue(String commandStr)
    {
        Process process = null;
        InputStream fis = null;
        try
        {
            process = Runtime.getRuntime().exec("cmd /c " + commandStr);
            fis = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                // 正則，用空格分開字符串
                String a[] = line.trim().split("\\s{1,}");
                line = a[2];
                if (a.length > 3)
                {
                    
                    for (int i = 3; i < a.length; i++)
                    {
                        a[2] = a[2] + " " + a[i];
                    }
                }
                return new String(a[2].getBytes("ISO-8859-1"), "utf-8");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<String> getResultsList(String commandStr)
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
                // String a[] = line.trim().split("\\s{1,}");
                line = line.substring(line.lastIndexOf("\\") + 1);
                results.add(line);
            }
            return results;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<String> getStringList(String commandStr)
    {
        Process process = null;
        InputStream fis = null;
        List<String> results = new ArrayList<String>();
        try
        {
            process = Runtime.getRuntime().exec("cmd /c " + commandStr);
            fis = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "GBK"));
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                // 正則，用空格分開字符串
                if (line != null && !("".equals(line.trim())))
                {
                    results.add(line);
                }
            }
            return results;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args)
    {
        getStringList("net use k: \\192.168.1.117\backup DupliCALL2013 /user:administrator");
    }
    
    public static void importReg(String filePath)
    {
        Process process = null;
        filePath = filePath.replaceAll("\\\\", "/");
        try
        {
            process = Runtime.getRuntime().exec("cmd /c reg import " + filePath);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void exuteCommand(String commandStr)
    {
        Process process = null;
        try
        {
            process = Runtime.getRuntime().exec("cmd /c " + commandStr);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
}
