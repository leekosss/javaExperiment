package com.two;

public class LowTank extends Tank implements AttackLand{
    public LowTank() {
        super("轻型坦克");
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
