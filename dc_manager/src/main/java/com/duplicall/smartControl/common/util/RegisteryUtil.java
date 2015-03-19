package com.duplicall.smartControl.common.util;

import java.io.FileOutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.NodeChangeEvent;
import java.util.prefs.NodeChangeListener;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

public class RegisteryUtil
{
    /**
     * 添加注册表信息
     * @Description 
     * @author mli
     * @param keysStr
     * @param valuesStr
     */
    public static void putRegistery(String keysStr[], String valuesStr[])
    {
        // String keysStr[] = {"One", "Two", "Five", "Ten", "Twenty"};
        // String valuesStr[] = {"Washington", "Jefferson", "Lincoln", "Hamilton", "Jackson"};
        NodeChangeListener nodeChangeListener = new NodeChangeListener()
        {
            public void childAdded(NodeChangeEvent event)
            {
                Preferences parent = event.getParent();
                Preferences child = event.getChild();
            }
            
            public void childRemoved(NodeChangeEvent event)
            {
                Preferences parent = event.getParent();
                Preferences child = event.getChild();
            }
        };
        
        PreferenceChangeListener preferenceChangeListener = new PreferenceChangeListener()
        {
            public void preferenceChange(PreferenceChangeEvent event)
            {
                String key = event.getKey();
                String value = event.getNewValue();
                Preferences node = event.getNode();
            }
        };
        
        // Look up user root
        Preferences prefs = Preferences.userRoot().node("/net/zukowski/ibm");
        // Add listeners
        prefs.addNodeChangeListener(nodeChangeListener);
        prefs.addPreferenceChangeListener(preferenceChangeListener);
        
        // Save a bunch of key-value pairs
        for (int i = 0, n = keysStr.length; i < n; i++)
        {
            prefs.put(keysStr[i], valuesStr[i]);
        }
        
        // Display all the entries
        try
        {
            String keys[] = prefs.keys();
            for (int i = 0, n = keys.length; i < n; i++)
            {
                System.out.println(keys[i] + ": :" + prefs.get(keys[i], "Unknown"));
            }
        }
        catch (BackingStoreException e)
        {
            System.err.println("Unable to read backing store: " + e);
        }
        
        // Create child
        Preferences child = Preferences.userRoot().node("/net/zukowski/ibm/foo");
        
        // Save to XML file
        try
        {
            FileOutputStream fos = new FileOutputStream("d://prefs.out");
            prefs.exportNode(fos);
        }
        catch (Exception e)
        {
            System.err.println("Unable to export nodes: " + e);
        }
        
        // Clean up
        try
        {
            prefs.removeNode();
        }
        catch (BackingStoreException e)
        {
            System.err.println("Unable to access backing store: " + e);
        }
    }
    /**
     * 获取
     * @Description 
     * @author mli
     * @param keyStr
     * @return
     */
    public static String getRegistery(String keyStr)
    {
        
        return null;
    }
    /**
     * 删除
     * @Description 
     * @author mli
     * @param keyStr
     */
    public static void removeRegistery(String keyStr)
    {
        
    }
    
    public static void main(String[] args)
    {
         String keysStr[] = {"One", "Two", "Five", "Ten", "Twenty"};
         String valuesStr[] = {"Washington", "Jefferson", "Lincoln", "Hamilton", "Jackson"};
         putRegistery(keysStr, valuesStr);
    }
}