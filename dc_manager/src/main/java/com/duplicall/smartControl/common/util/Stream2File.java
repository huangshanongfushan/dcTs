package com.duplicall.smartControl.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @Description 
 * @author mli
 * @date Jun 5, 2014 2:07:35 PM 
 * @version V1.3.1
 */
public class Stream2File
{
    public static void stream2File(String path,InputStream mediaStream,File file)
    {
        if  (!file .exists()  && !file .isDirectory())      
        {       
            file .mkdir();    
        }
        File mediaFile=new File(path);
        if (mediaFile .exists())   
        {       
            return;  
        }
        BufferedInputStream bis = new BufferedInputStream(mediaStream);
        OutputStream os = null;
        try
        {
            os = new FileOutputStream(path);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte buffer[] = new byte[1024];
            while (bis.read(buffer) != -1)
            {
                bos.write(buffer);
                os.flush();
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                os.close();
                mediaStream.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }
}
