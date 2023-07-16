package com.two;

/**
 * 直升机
 */
public class Helicopter extends AirVehicle implements AttackAirLand {
    public Helicopter() {
        super("直升机");
    }
    @Override
    public void attack(Arms arms) {
        System.out.print(attackInfo(arms));
        if(arms instanceof Land) {
            attack((Land) arms);
        } else if (arms instanceof Air){
            attack((Air) arms);
        } else {
            System.out.println("不能攻击！");
        }
    }
}
