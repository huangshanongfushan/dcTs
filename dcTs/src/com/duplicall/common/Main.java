package com.duplicall.common;

import java.io.File;

import org.apache.log4j.Logger;

import com.duplicall.entities.TsConfig;

public class Main {
	static Logger log = Logger.getLogger(Main.class);

	// 入口，进行定时任务
	public static void main(String[] args) {
		File file = new File(Constant.CONPATH);
		// 如果
		if (!file.exists()) {
			log.error("No configure file!");
			return;
		}
		TsConfig tsConfig = null;
		try {
			// 读取配置文件
			tsConfig = ConfigUtil.readConfig(new File(Constant.CONPATH));
		} catch (Exception e) {
			log.error("read conf file fails!");
			e.printStackTrace();
		}
		// Ts开启
		if ("true".equals(tsConfig.getEnable().trim())) {
			new MyTimer();
		}
	}
}
