package com.duplicall.common;


public class Main {
    //入口，进行定时任务
    public static void main(String[] args) {
//        IMaDevices maDevicesImpl = new MaDevicesImpl();
//        long callDeId = maDevicesImpl.getCallDeliveryId();
//        maDevicesImpl.getmapping(callDeId);
        new MyTimer();
    }
}
