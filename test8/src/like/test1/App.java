package like.test1;

public class App {
    public static void main(String[] args) {
//        MyThread m1 = new MyThread(true);
//        m1.start();
//        MyThread m2 = new MyThread(false);
//        m2.start();

//        MyRunnable m = new MyRunnable(true);
//        Thread t = new Thread(m);
//        t.start();

//        MyThread3 m = new MyThread3(false);
//        m.start();
        MyThread4 m = new MyThread4(false);
        m.start();


    }
}

class MyThread extends Thread {
    boolean isOdd;

    public MyThread(boolean isOdd) {
        this.isOdd = isOdd;
    }

    public void run() {
        for (int i = 1; i <= 50; i++) {
            if (isOdd && i % 2 == 1) {
                System.out.println("奇数：");
                System.out.println(i + " "); //输出奇数
            }
            if (!isOdd && i % 2 == 0) {
                System.out.println("偶数：");
                System.out.println(i + " "); //输出偶数
            }
        }
    }
}

class MyRunnable implements Runnable {

    boolean isOdd;

    public MyRunnable(boolean isOdd) {
        this.isOdd = isOdd;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            if (isOdd && i % 2 == 1) {
                System.out.println("奇数：");
                System.out.println(i + " "); //输出奇数
            }
            if (!isOdd && i % 2 == 0) {
                System.out.println("偶数：");
                System.out.println(i + " "); //输出偶数
            }
        }
    }
}

class MyThread3 {
    Thread t;

    public MyThread3(boolean isOdd) {
        MyRunnable m = new MyRunnable(isOdd);
        t = new Thread(m);

    }

    public void start() {
        t.start();
    }

    class MyRunnable implements Runnable {
        boolean isOdd;

        public MyRunnable(boolean isOdd) {
            this.isOdd = isOdd;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 50; i++) {
                if (isOdd && i % 2 == 1) {
                    System.out.println("奇数：");
                    System.out.println(i + " "); //输出奇数
                }
                if (!isOdd && i % 2 == 0) {
                    System.out.println("偶数：");
                    System.out.println(i + " "); //输出偶数
                }
            }
        }
    }

}

class MyThread4 implements Runnable {
    Thread t;
    boolean isOdd;

    public MyThread4(boolean isOdd) {
        this.isOdd = isOdd;
        t = new Thread(this);
    }

    public void start() {
        t.start();
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            if (isOdd && i % 2 == 1) {
                System.out.println("奇数：");
                System.out.println(i + " "); //输出奇数
            }
            if (!isOdd && i % 2 == 0) {
                System.out.println("偶数：");
                System.out.println(i + " "); //输出偶数
            }
        }
    }
}
