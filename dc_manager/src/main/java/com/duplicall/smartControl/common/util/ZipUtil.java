package com.duplicall.smartControl.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩接口， sourcFloder 要压缩的文件夹（完整路径） destinFile 压缩后的文件（完整路径）
 * 
 * @author Administrator
 * 
 */
public class ZipUtil {
    public static void toZip(String sourcFloder, String destinFile)
        throws Exception
    {
        File f = new File(sourcFloder);
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(destinFile));
        zip(out, f, null);
        out.close();
    }
    
    private static void zip(ZipOutputStream out, File f, String base)
        throws Exception
    {
        if (f.isDirectory()) {
            File[] fc = f.listFiles();
            if (base != null)
                out.putNextEntry(new ZipEntry(base + "/"));
            base = base == null ? "" : base + "/";
            for (int i = 0; i < fc.length; i++) {
                zip(out, fc[i], base + fc[i].getName());
            }
        }
        else {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            while ((b = in.read()) != -1)
                out.write(b);
            in.close();
        }
    }
    
    public static void main(String[] args)
        throws Exception
    {
        File f = new File("d:\\Temp");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream("d:\\aa.zip"));
        zip(out, f, null);
        out.close();
    }
}