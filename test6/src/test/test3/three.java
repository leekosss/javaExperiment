package test.test3;

import java.util.Random;

public class three {
    public static void main(String[] args) {
        System.out.println("随机数为：");
        System.out.println(getYZM2());

    }
    public static String getYZM() {
        String s="589abcdfgiTjklW4Vmno1pq0rtu6vwxyhzAB章CeD王EFG李UHI37JKsLM2NOPQRSXYZ@#$%&()!+-";
        Random r = new Random();
        StringBuilder str= new StringBuilder();
        for(int i=0;i<4;i++) {
            int random = r.nextInt(s.length());
            str.append(s.charAt(random));
        }
        return str.toString();
    }
    public static String getYZM2() {
        String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        StringBuilder str= new StringBuilder();
        for(int i=0;i<4;i++) {
            int random = r.nextInt(s.length());
            str.append(s.charAt(random));
        }
        return str.toString();
    }
}
