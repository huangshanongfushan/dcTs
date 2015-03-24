package com.duplicall.common;

import java.io.File;

public class Main {
	public static String filePath = "C://macaw/config/avayaConfig.xml";

	// 入口，进行定时任务
	public static void main(String[] args) {
		File file = new File(filePath);
		// 如果
		if (!file.exists()) {
			return;
		}
		new MyTimer();
	}
}
