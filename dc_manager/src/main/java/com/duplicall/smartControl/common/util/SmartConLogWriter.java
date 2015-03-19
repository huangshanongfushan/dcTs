package com.duplicall.smartControl.common.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * <一句话功能简述>
 * 
 * @author mli
 * @version [V1.00, 2014年7月11日]
 * @see [reference class/method]
 * @since V1.00
 */
public class SmartConLogWriter {
	public static File logFile = new File("C://macaw/log/DCControl.log");

	public static void writeLog(String type, String content) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(logFile, true);
			writer.append(PresentTime.presentTime()).append("  ").append(type)
					.append("  ").append(content).append("\r\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
