package com.four;

public class Header1 extends Decorator {

    public Header1() {
    }

    public Header1(Component c) {
        super(c);
    }

    @Override
    public void printTicket() {
        System.out.println("Header1:");
        dc.printTicket();
    }
}
