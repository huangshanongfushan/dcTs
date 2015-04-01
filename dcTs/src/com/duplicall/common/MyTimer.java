package com.duplicall.common;

import java.io.File;
import java.util.Timer;

import org.apache.log4j.Logger;

import com.duplicall.entities.TsConfig;
import com.duplicall.task.MyTask;

public class MyTimer {
	static Logger log = Logger.getLogger(MyTimer.class);

	public MyTimer() {
		TsConfig tsConfig = null;
		try {
			tsConfig = ConfigUtil.readConfig(new File(Constant.CONPATH));
		} catch (Exception e) {
			log.error("read conf file fails!");
		}
		Timer timer = new Timer();
		MyTask myTask1 = new MyTask();
		timer.schedule(myTask1, 1000, tsConfig.getInterval()); // 任务1
	}
}