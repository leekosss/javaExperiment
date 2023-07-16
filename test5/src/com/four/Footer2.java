package com.four;

public class Footer2 extends Decorator {

    public Footer2() {
    }

    public Footer2(Component c) {
        super(c);
    }

    @Override
    public void printTicket() {
        dc.printTicket();
        System.out.println(":Footer2");
    }
}
