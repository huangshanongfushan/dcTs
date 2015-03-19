package com.duplicall.common;

import java.util.Timer;

import com.duplicall.task.MyTask;

public class MyTimer{     
    public MyTimer() {
        Timer timer = new Timer();     
        MyTask myTask1 = new MyTask();     
        timer.schedule(myTask1, 1000, 10000);  //任务1 一秒钟后执行，每两秒执行一次。   
    }
}   