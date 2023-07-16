package com.two;

public interface AttackAir {
    public default void attack(Air air) {
        System.out.println("可以攻击空军");
    }
}
