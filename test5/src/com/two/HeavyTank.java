package com.two;

public class HeavyTank extends Tank implements AttackAirLand{
    public HeavyTank() {
        super("重型坦克");
    }
    public void attack(Air air) {
        System.out.println("用导弹攻击空军！");
    }
    public void attack(Land land) {
        System.out.println("用炮弹攻击陆军！");
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
