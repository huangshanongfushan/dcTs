package com.duplicall.common;

import java.io.File;
import java.util.Timer;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.duplicall.entities.TsConfig;
import com.duplicall.task.MyTask;

public class MyTimer {
	static Logger log = Logger.getLogger(MyTimer.class);
	private static MyTimer mytimer;
	private MyTimer() {
		TsConfig tsConfig = null;
		try {
			tsConfig = this.readConfig(new File(Constant.CONPATH));
		} catch (Exception e) {
			log.error("read conf file fails!");
		}
		Timer timer = new Timer();
		MyTask myTask1 = new MyTask();
		timer.schedule(myTask1, 1000, tsConfig.getInterval()); // 任务1000
	}
	public static MyTimer getInstant(){
		if(mytimer==null){
			return new MyTimer();
		}
		return mytimer;
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