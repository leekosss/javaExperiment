package com.like.game;

public class Game {
    public static void main(String[] args) {
        Integer red = 0;
        Integer black = 0;
        Stick red1= new Stick("红方");
        Stick black3= new Stick("黑方");
        Tiger red2 = new Tiger("红方");
        Tiger black1 = new Tiger("黑方");
        Chicken red3 = new Chicken("红方");
        Chicken black4 = new Chicken("黑方");
        Insect red4 = new Insect("红方");
        Insect black2 = new Insect("黑方");
        Chicken red5 = new Chicken("红方");
        Chicken black5 = new Chicken("黑方");

        /*int result1 = red1.compareTo(black1);
        int result2 = red2.compareTo(black2);
        int result3 = red3.compareTo(black3);
        int result4 = red4.compareTo(black4);
        int result5 = red5.compareTo(black5);
        compare(red1,black1,result1,red,black);
        compare(red2,black2,result2,red,black);
        compare(red3,black3,result3,red,black);
        compare(red4,black4,result4,red,black);
        compare(red5,black5,result5,red,black);
        System.out.println(red);
        System.out.println(black);*/


    }
    /*public static void compare(Animal a,Animal b,int result,Integer red,Integer black) {
        if(result == 0) {
            System.out.println(a.getName() + "  vs  "+b.getName() + "   和局");
            red++;
            black++;
        }else if (result >0 ) {
            System.out.println(a.getName() + "  vs  "+b.getName() + "   "+a.getTeam()+"胜！");
            red++;
        }else {
            System.out.println(a.getName() + "  vs  "+b.getName() + "   "+b.getTeam()+"胜！");
            black++;
        }
    }*/

}

/*class Animal {


    public String getTeam() {
        return "black";
    }
    public String getName() {
        return null;
    }

}*/

//木棒类
class Stick {

    private final String name = "棒子";
    private String team;
    public Stick() {}

    public Stick(String team) {
        this.team = team;
    }

    public int compareTo(Tiger tiger) {
        return 1;
    }
    public int compareTo(Stick stick) {
        return 0;
    }
    public int compareTo(Chicken chicken) {
        return 0;
    }
    public int compareTo(Insect insect) {
        return -1;
    }
}
//老虎类
class Tiger {
    private final String name = "老虎";
    private String team;

    public Tiger() {
    }

    public Tiger(String team) {
        this.team = team;
    }

    public int compareTo(Tiger tiger) {
        return 0;
    }
    public int compareTo(Stick stick) {
        return -1;
    }
    public int compareTo(Chicken chicken) {
        return 1;
    }
    public int compareTo(Insect insect) {
        return 0;
    }
}
//鸡类
class Chicken {
    private final String name = "鸡";
    private String team;

    public Chicken() {
    }

    public Chicken(String team) {
        this.team = team;
    }
    public int compareTo(Chicken chicken) {
        return 0;
    }

    public int compareTo(Stick stick) {
        return 0;
    }
    public int compareTo(Tiger tiger) {
        return -1;
    }
    public int compareTo(Insect insect) {
        return 1;
    }

}
// 虫子类
class Insect {
    private final String name = "虫子";
    private String team;

    public Insect() {
    }

    public Insect(String team) {
        this.team = team;
    }
    public int compareTo(Insect insect) {
        return 0;
    }

    public int compareTo(Stick stick) {
        return 1;
    }
    public int compareTo(Tiger tiger) {
        return 0;
    }
    public int compareTo(Chicken chicken) {
        return -1;
    }


}



