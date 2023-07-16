package com.two;

public interface AttackLand {
    public default void attack(Land land) {
        System.out.println("可以攻击陆军");
    }
}
