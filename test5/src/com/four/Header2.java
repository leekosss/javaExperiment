package com.four;

public class Header2 extends Decorator {

    public Header2() {
    }

    public Header2(Component c) {
        super(c);
    }

    @Override
    public void printTicket() {
        System.out.println("Header2:");
        dc.printTicket();
    }
}
