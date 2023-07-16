package com.four;

public class Factory {
    public Component getComponent() {
        Component c;
//        c = new Header1(new Footer2(new Ticket("张三","001")));
        c = new Footer2(new Header1(new Header2(new Ticket("李四","007"))));
        return c;
    }
}
