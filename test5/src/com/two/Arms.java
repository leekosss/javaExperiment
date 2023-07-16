package com.two;


/**
 * 兵种类
 */
public abstract class Arms {

    private String type; // 兵种类型
    public Arms(String t) {
        type = t;
    }
    public abstract void attack(Arms arms);  //因为每一种兵种之间都可以相互攻击，所以定义抽象方法，供子类实现
    public String attackInfo(Arms arms) {
        return type+"\t遇见了\t"+arms.type+":\t";
    }

}
