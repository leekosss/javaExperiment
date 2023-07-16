package like.test2;

import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws InterruptedException {
        final int max = 1000;
        int[] a = new int[max];
        int sum1 = 0, sum2 = 0, step = 10, num = 4;
        //每个线程每次至多累加 10 个数，共有 4 个线程
        for (int i = 0; i < max; i++) {//先计算出正确的累加和，以方便对比
            a[i] = i;
            sum1 = sum1 + a[i];
        }
        Pos p=new Pos(max,step);
        sum2=SumByThread(p, a,num,step);
        System.out.print("顺序："+sum1+"，并发："+sum2);
    }

    public static int SumByThread(Pos p,int[] a,int num,int step) throws InterruptedException {

        MyThread[] t = new MyThread[4];
        for(int i=0;i<num;i++) {
            t[i] = new MyThread(p,step,a);
            t[i].start();
        }
//        for(Thread ti :t) {
//            ti.join();
//        }
        Thread.sleep(1000);
        return MyThread.sum;
    }
}

class Pos {
    private int max, step,pos;
    public Pos(int max,int step) {
        this.max = max;
        this.step = step;
        pos = 0;
    }

    public int getPos() {
        if(pos < max) {
            return pos;
        }
        return -1;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }

}
class MyThread extends Thread {
    static int sum=0;
    private int step;
    private Pos p;
    private int[] a;
    private boolean flag;
    public MyThread(Pos p,int step,int[] a) {
        this.p = p;
        this.step = step;
        this.a = a;
        flag = false;
    }
    public void run() {
        while(true) {
            for(int i=0;i<step;i++) {
                synchronized (p) {
                        if(p.getPos() != -1) {
                            sum+=a[p.getPos()];
                            System.out.println(Thread.currentThread().getName()+" num:"+a[p.getPos()]+ " sum:"+sum);
                            p.setPos(p.getPos()+1);
                        } else {
                            return;
                        }

                }
            }
                try {
                    this.wait();
                    this.notifyAll();
                } catch (Exception e) {

                }
        }
    }

}