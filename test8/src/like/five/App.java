package like.five;

import java.util.Random;

public class App {
    public static void main(String[] args) throws InterruptedException {
        BufferArea ba = new BufferArea(10);
        ThreadPutNumber t = new ThreadPutNumber(ba);
        ThreadGetNumber t2 = new ThreadGetNumber(ba);
        t.start();
        t2.start();
        t.join();
        t2.join();
        System.out.println("main is over!");
    }
}

/**
 * 产生1-100随机整数
 */
class BufferArea {
    private int top, max;
    private int buffered[];
    static volatile boolean flag = false;

    public int getInt() {
        Random r = new Random();
        return r.nextInt(100) + 1;
    }


    public BufferArea() {
    }

    public BufferArea(int max) {
        this.max = max;
        buffered = new int[max];
        top = 0;
    }

    public void push(int num) {
        if (top < max) {
            buffered[top] = num;
            top++;
        }
    }

    public int pop() {
        return buffered[--top];
    }

}


class ThreadPutNumber extends Thread {

    private BufferArea ba;

    public ThreadPutNumber(BufferArea ba) {
        this.ba = ba;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            synchronized (ba) {

                if (!BufferArea.flag) {
                    int num = ba.getInt();
                    ba.push(num);
                    System.out.println("put num is: " + num);
                    BufferArea.flag = true;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }
                    ba.notifyAll();

                } else {
                    try {
                        ba.wait();
                    } catch (InterruptedException e) {
//                            e.printStackTrace();
                    }
                }

            }
        }
    }
}

class ThreadGetNumber extends Thread {
    private BufferArea ba;

    public ThreadGetNumber(BufferArea ba) {
        this.ba = ba;
    }

    public boolean isPrime(int num) {
        int i;
        for (i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        for (int i = 0; i < 6; i++) {
            synchronized (ba) {
                if (BufferArea.flag) {
                    int num = ba.pop();
                    if (isPrime(num)) {
                        System.out.println(num + " is a prime!");
                    } else {
                        System.out.println(num + " is not prime!");
                    }
                    BufferArea.flag = false;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {

                    }
                    ba.notifyAll();


                } else {
                    try {
                        ba.wait();
                    } catch (InterruptedException e) {
//                            e.printStackTrace();
                    }
                }
            }
        }

    }

}
