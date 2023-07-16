package test;

class App {
    public static void main(String[] args) throws Exception {
        char[] c1 = {'1', '3', '5', '7', '9'};
        char[] c2 = {'a', 'b', 'c', 'd', 'e'};
        char[] c3 = {'2', '4', '6', '8', '0'};
        D s = new D();
        System.out.print("线程开始：");
        TT t1, t2, t3;
        t1 = new TT(s, c1, 0, 1);
        t1.start();
        t2 = new TT(s, c2, 1, 2);
        t2.start();
        t3 = new TT(s, c3, 2, 0);
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.print("线程结束。");
    }
}

class D {
    int d = 0;
//    public void read_write(int x, int y){
//        while(d!=x)
//            try{ wait(); }catch(Exception e){;}
//        d=y; notifyAll();// 用 notify()扣 3 分
//    }
}

class TT extends Thread {
    private D s;
    private int pre, here;
    private char[] ca;

    public TT(D s1, char[] c, int x, int y) {
        s = s1;
        ca = c;
        pre = x;
        here = y;
    }

    public void run() {
        synchronized (s) {
            for (char c : ca) {
//                s.read_write(pre, here);
                while (pre != s.d) {
                    try {
                        s.wait();
                    } catch (Exception e) {
                    }
                }
                s.d=here;
                s.notifyAll();
                try {
                    sleep(100);
                } catch (Exception e) {
                    ;
                }
                System.out.print(c);
            }
        }
    }
}