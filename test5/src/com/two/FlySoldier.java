package com.two;

public class FlySoldier extends Soldier implements Air,AttackAirLand{
    public FlySoldier() {
        super("航空兵");
    }
    @Override
    public void attack(Arms arms) {
        System.out.print(attackInfo(arms));
        if (arms instanceof Air) {
            attack((Air) arms);
        } else if(arms instanceof Land ){
            attack((Land) arms);
        } else {
            System.out.println("不能攻击！");
        }
    }
}
