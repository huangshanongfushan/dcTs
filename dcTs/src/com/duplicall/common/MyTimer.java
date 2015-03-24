package com.duplicall.common;

import java.util.Timer;

import com.duplicall.task.MyTask;

public class MyTimer{
	private long interval=600000;
    public MyTimer() {
        Timer timer = new Timer();     
        MyTask myTask1 = new MyTask();     
        timer.schedule(myTask1, 1000, interval);  //任务1 一秒钟后执行，每两秒执行一次。   
    }
}   