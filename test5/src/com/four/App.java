package com.four;

public class App {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Component component = factory.getComponent();
        component.printTicket();
    }
}
