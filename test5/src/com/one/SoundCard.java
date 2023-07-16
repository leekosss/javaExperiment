package com.one;

public class SoundCard implements PCI{
    @Override
    public void start() {
        System.out.println("声卡启动~~");
    }

    @Override
    public void run() {
        System.out.println("声卡运行~~");
    }

    @Override
    public void stop() {
        System.out.println("声卡停止~~");
    }
}
