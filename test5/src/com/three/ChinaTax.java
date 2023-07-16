package com.three;

public class ChinaTax implements Tax{
    @Override
    public double getTax(int quantity, double price, String goodsId) {
        return 0.2;
    }
}
