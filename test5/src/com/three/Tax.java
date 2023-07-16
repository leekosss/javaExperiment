package com.three;

/**
 * 税率接口
 */
public interface Tax {
    public abstract double getTax(int quantity,double price,String goodsId);
    //根据商品数量，商品单价，商品种类计算税率
}
