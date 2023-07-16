package com.three;

/**
 * 顾客类
 */
public class Customer {
    private String name, address, id;

    public Customer() {

    }

    public Customer(String name, String address, String id) {
        this.name = name;
        this.address = address;
        this.id = id;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return
                "姓名:'" + name + '\'' +
                ", 住址:'" + address + '\'' +
                ", 身份证号:'" + id + '\''
                ;
    }
}
