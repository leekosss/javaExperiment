package com.two;

public class App {
    public static void main(String[] args) {
        Arms[] a = {new HeavyTank(),new LowTank(),new FlySoldier(),new FootSoldier(),new HeavyTank()};
        Arms[] b = {new Bomb(),new Helicopter(),new FlySoldier(),new FootSoldier(),new LowTank()};
        for(int i=0;i<a.length;i++) {
            a[i].attack(b[i]);
        }
    }
}
