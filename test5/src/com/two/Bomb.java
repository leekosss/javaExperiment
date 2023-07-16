package com.two;


/**
 * 轰炸机
 */
public class Bomb extends AirVehicle implements AttackLand {
    public Bomb() {
        super("轰炸机");
    }
    @Override
    public void attack(Arms arms) {
        System.out.print(attackInfo(arms));
        if(arms instanceof Land) {
            attack((Land) arms);
        }else {
            System.out.println("不能攻击！");
        }
    }
}
