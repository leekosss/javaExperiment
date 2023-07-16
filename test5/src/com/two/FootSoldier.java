package com.two;

public class FootSoldier extends Soldier implements Land,AttackLand{
    public FootSoldier() {
        super("步兵");
    }
    @Override
    public void attack(Arms arms) {
        System.out.print(attackInfo(arms));
        if(arms instanceof Land ){
            attack((Land) arms);
        } else {
            System.out.println("不能攻击！");
        }
    }
}
