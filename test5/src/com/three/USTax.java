package com.three;

public class USTax implements Tax{
    @Override
    public double getTax(int quantity, double price, String goodsId) {
        return 0.3;
    }
}
