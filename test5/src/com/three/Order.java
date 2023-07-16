package com.three;

/**
 * 订单类
 */
public class Order {
    private Customer customer; //客户信息
    private double price;  //价格
    private int quantity;  //数量
    private String goodsId, goodsName, orderNum; //商品id，名称，订单编号

    public Order() {

    }

    public Order(Customer customer, double price, int quantity, String goodsId, String goodsName, String orderNum) {
        this.customer = customer;
        this.price = price;
        this.quantity = quantity;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.orderNum = orderNum;
    }

    public Tax getTax(String address) {
        if (address.contains("中国")) {
            return new ChinaTax();
        }
        if (address.contains("美国")) {
            return new USTax();
        }
        return null;
    }

    //处理订单
    public void process() {
        String address = customer.getAddress();
        Tax t = getTax(address);
        double tax = 0;
        if (t != null) {
            tax = t.getTax(quantity, price, goodsId);
        }
        System.out.println("订单号:" + orderNum + " 客户:" + customer);
        System.out.println("\t编号: " + goodsId + " 名称：" + goodsName + " 价格 " + price + " 数量: " + " 税率: " + tax + " 总价: " + price * quantity + (tax + 1));

    }

}
