package like.test4;

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank(1000);
        Thread t1 = new Thread(bank,"aa");
        Thread t2 = new Thread(bank,"bb");
        t1.start();
        t2.start();

    }
}

class Bank implements Runnable {
    private double money;
    private final Object object;
    public Bank(double money) {
        this.money = money;
        object = new Object();
    }
    @Override
    public void run() {
        for(int i=0;i<3;i++) {
            synchronized (object) {
                System.out.println("银行当前余额为："+ money+","+Thread.currentThread().getName()+"第"+(i+1)+"次存入100元");
                money += 100;
                System.out.println("当前银行总额为:" + money);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}