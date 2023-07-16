package com.two;


/**
 * 坦克类
 */
public abstract class Tank extends Arms implements Land {
    public Tank(String type) {
        super(type);
    }
}
