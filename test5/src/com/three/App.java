package com.three;

public class App {
    public static void main(String[] args) {
        Customer customer1 = new Customer("张三","中国人民大学","36220120000101");
        Customer customer2 = new Customer("李四","美国哈佛大学","36220120021212");
        Order order1 = new Order(customer1,58,99,"133","HUAWEIP50","001");
        Order order2 = new Order(customer2,99.9,36,"588","iPhone14","002");
        order1.process();
        order2.process();
    }
}
