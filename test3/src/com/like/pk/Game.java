package com.like.pk;

interface Player{
    public static int c=0,c1=0;
    public abstract void pk(Object obj);
}

class Stick implements Player{
    public static int c=0,c1=0;
    public void pk(Object obj) {
        if(obj instanceof Stick) {
            System.out.println("棒子  VS  棒子  和局");
        } else if(obj instanceof Tiger) {
            System.out.println("棒子  VS  老虎  赢了");
            c++;
        } else if(obj instanceof Chicken) {
            System.out.println("棒子  VS  鸡   和局");
        } else if(obj instanceof Insect) {
            System.out.println("棒子  VS  虫   红方输");
            c1++;
        }
    }
}

class Tiger implements Player{
    public static int c=0,c1;
    public void pk(Object obj) {
        if(obj instanceof Stick) {
            System.out.println("老虎  VS  棒子  红方输");
            c1++;
        } else if(obj instanceof Tiger) {
            System.out.println("老虎  VS  老虎  和局");
        } else if(obj instanceof Chicken) {
            System.out.println("老虎  VS  鸡   红方胜");
            c++;
        } else if(obj instanceof Insect) {
            System.out.println("老虎  VS  虫   和局");
        }
    }
}

class Chicken implements Player{
    public static int c=0,c1=0;
    public void pk(Object obj) {
        if(obj instanceof Stick) {
            System.out.println("鸡   VS  棒子  和局");
        } else if(obj instanceof Tiger) {
            System.out.println("鸡   VS  老虎  红方输");
            c1++;
        } else if(obj instanceof Chicken) {
            System.out.println("鸡   VS  鸡   和局");
        } else if(obj instanceof Insect) {
            System.out.println("鸡   VS  虫   红方胜");
            c++;
        }
    }
}

class Insect implements Player {
    public static int c=0,c1=0;
    public void pk(Object obj) {
        if(obj instanceof Stick) {
            System.out.println("虫   VS  棒子  红方胜");
            c++;
        } else if(obj instanceof Tiger) {
            System.out.println("虫   VS  老虎  和局");
        } else if(obj instanceof Chicken) {
            System.out.println("虫   VS  鸡   红方输");
            c1++;
        } else if(obj instanceof Insect) {
            System.out.println("虫   VS  虫   和局");
        }
    }
}

class Test1{
    public static void main(String[] args) {
        String []red = {"棒子","老虎","鸡","虫","老虎"};
        String []black = {"虫","老虎","虫","鸡","棒子"};
        Stick s = new Stick();
        Tiger  t = new Tiger();
        Chicken  c = new Chicken();
        Insect i = new Insect();
        s.pk(i);
        t.pk(t);
        c.pk(i);
        i.pk(c);
        t.pk(s);
        int redScore = s.c+t.c+c.c+i.c;
        int blackScore = s.c1+t.c1+c.c1+i.c1;
        String result;
        if(redScore>blackScore) {
            result = "红方胜";
        } else if(redScore<blackScore) {
            result = "红方输";
        } else {
            result = "平局";
        }
        System.out.println("总比分: 红方VS黑方 = "+redScore+":"+blackScore+","+result);
    }
}
