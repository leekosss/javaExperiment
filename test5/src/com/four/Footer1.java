package com.four;

public class Footer1 extends Decorator {

    public Footer1() {
    }

    public Footer1(Component c) {
        super(c);
    }

    @Override
    public void printTicket() {
        dc.printTicket();
        System.out.println(":Footer1");
    }
}
