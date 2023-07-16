package com.four;


/**
 * 票据
 */
public class Ticket extends Component {
    private String customer,orderId;  //客户，订单号

    public Ticket() {}
    public Ticket(String customer,String orderId) {
        this.customer = customer;
        this.orderId = orderId;
    }
    @Override
    public void printTicket() {
        System.out.println("订单号:"+orderId+" 客户:"+customer);
    }
}
