package like.test5;

import java.util.Random;

public class App {
    public static void main(String[] args) throws InterruptedException {

        BufferedArea ba = new BufferedArea(20, true);
        ThreadPutNumber threadPutNumber = new ThreadPutNumber(ba);
        ThreadGetNumber threadGetNumber = new ThreadGetNumber(ba);
        threadPutNumber.start();
        threadGetNumber.start();
        threadPutNumber.join();
        threadGetNumber.join();
        System.out.println("main is over!");
    }
}

class BufferedArea {
    int buffer, num;
    Random r;
    boolean isEmpty;

    public BufferedArea(int num, boolean isEmpty) {
        r = new Random();
        this.num = num;
        this.isEmpty = isEmpty;
    }

    public int getRandomInt() {
        return r.nextInt(100) + 1;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public int getBuffer() {
        return buffer;
    }

    public boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        int i;
        for (i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}

class ThreadPutNumber extends Thread {
    BufferedArea ba;

    public ThreadPutNumber(BufferedArea ba) {
        this.ba = ba;
    }

    public void run() {
        while (ba.num > 0) {

            synchronized (ba) {
                if (!ba.isEmpty) {
                    try {
                        ba.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int num = ba.getRandomInt();
                    ba.buffer = num;
                    ba.isEmpty = false;
                    System.out.println("put number is : " + num);
                    ba.notifyAll();
                }

            }

        }
    }

}

class ThreadGetNumber extends Thread {
    BufferedArea ba;

    public ThreadGetNumber(BufferedArea ba) {
        this.ba = ba;
    }

    public void run() {
        while (ba.num > 0) {

            synchronized (ba) {
                if (ba.isEmpty) {
                    try {
                        ba.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int num = ba.getBuffer();
                    ba.isEmpty = true;
                    boolean isPrime = ba.isPrime(num);
                    if (isPrime) {
                        System.out.println(num + " is a prime!");
                    } else {
                        System.out.println(num + " is not a prime!");
                    }
                    ba.num--;
                    ba.notifyAll();
                }

            }

        }
    }
}