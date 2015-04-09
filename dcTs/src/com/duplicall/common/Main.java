package com.duplicall.common;

import java.io.File;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.duplicall.entities.TsConfig;

public class Main {
	static Logger log = Logger.getLogger(Main.class);

	// 入口，进行定时任务
	public static void main(String[] args) {
		Main main = new Main();
		// 一直执行
		File file = new File(Constant.CONPATH);
		// 如果
		if (!file.exists()) {
			log.error("No configure file!");
			return;
		}
		TsConfig tsConfig = null;
		try {
			// 读取配置文件
			tsConfig = main.readConfig(new File(Constant.CONPATH));
		} catch (Exception e) {
			log.error("read conf file fails!");
			e.printStackTrace();
		}
		// Ts开启
		if ("true".equals(tsConfig.getEnable().trim())) {
			MyTimer.getInstant();
		}
	}

	/**
	 * 读取配置文件
	 * 
	 * @param file
	 * @return
	 */
	public TsConfig readConfig(File file) throws Exception {
		SAXReader saxReader = new SAXReader();
		Document matchFiledocument = null;
		matchFiledocument = saxReader.read(file);
		Element rootElement = matchFiledocument.getRootElement();
		String enable = rootElement.attributeValue("enable");
		Element lastTimeElement = rootElement.element("lasttime");
		String lasttime = lastTimeElement.getTextTrim();
		Element freElement = rootElement.element("frequency");
		long interval = Long.parseLong(freElement.getTextTrim());
		TsConfig tsConfig = new TsConfig();
		tsConfig.setEnable(enable);
		tsConfig.setInterval(interval);
		tsConfig.setLastTime(lasttime);
		return tsConfig;
	}
}
