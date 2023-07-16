package com.one;

public class NetCard implements PCI{
    @Override
    public void start() {
        System.out.println("网卡卡启动~~");
    }

    @Override
    public void run() {
        System.out.println("网卡运行~~");
    }

    @Override
    public void stop() {
        System.out.println("网卡停止~~");
    }
}
