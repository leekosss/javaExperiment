package com.one;

public class DisplayCard implements PCI{
    @Override
    public void start() {
        System.out.println("显卡启动~~");
    }

    @Override
    public void run() {
        System.out.println("显卡运行~~");
    }

    @Override
    public void stop() {
        System.out.println("显卡停止~~");
    }
}
