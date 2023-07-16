package com.one;

public class Demo {
    public static void main(String[] args) {
        MainBoard mainBoard = new MainBoard();
        mainBoard.add(new DisplayCard());
        mainBoard.add(new NetCard());
        mainBoard.add(new SoundCard());
        mainBoard.start();
        mainBoard.run();
        mainBoard.stop();
    }
}
