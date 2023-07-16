//package test;
//
//class App2 {
//
////    public static void main(String[] args) throws Exception {
//
//        char[] c1 = {'1', '2', '3', '4', '5'}; //传给 t1
//
//        char[] c2 = {'a', 'b', 'c', 'd', 'e'}; //传给 t2
//
//        char[] c3 = {'我', '你', '他', '她', '它'}; //传给 t3
//
//        ShareResource s = new ShareResource();
//
//        System.out.print("线程开始：");
//
//        /* 补充代码*/
//        TT t1 = new TT(s, c1, 0, 1);
//        TT t2 = new TT(s, c2, 1, 2);
//        TT t3 = new TT(s, c3, 2, 0);
//        t1.start();
//        t2.start();
//        t3.start();
//        t1.join();
//        t2.join();
//        t3.join();
//        System.out.print("线程结束。"); //最后输出
//
//    }
//
//}
//
//class ShareResource { //线程间的共享资源
//
//    /* 补充代码，可能包含属性、方法*/
//    private int num = 2;
//
//    public void setNum(int num) {
//        this.num = num;
//    }
//
//    public int getNum() {
//        return num;
//    }
//
//}
//
////class T implements Runnable {//要求内嵌线程的方式
////    private Thread t;
////    private char[] chars;
////    private ShareResource shareResource;
////    private int sta, end;
////
////    public T(ShareResource shareResource, char[] chars, int sta, int end) {
////        t = new Thread(this);
////        this.chars = chars;
////        this.shareResource = shareResource;
////        this.sta = sta;
////        this.end = end;
////
////    }
////
////    public void start() {
////        t.start();
////    }
////
////    public void join() throws InterruptedException {
////        t.join();
////    }
////
////    @Override
////    public void run() {
////        for (char c : chars) {
////            synchronized (shareResource) {
////                while (shareResource.getNum() != sta) {
////                    try {
////                        shareResource.wait();
////                    } catch (InterruptedException e) {
////                    }
////                }
////                System.out.print(c);
////                shareResource.setNum(end);
////                shareResource.notifyAll();
////            }
////
////
////        }
////    }
////}
//
//
//class T implements Runnable {//要求内嵌线程的方式
//    private Thread t;
//    private char[] chars;
//    private ShareResource shareResource;
//    private int sta, end;
//
//    public T(ShareResource shareResource, char[] chars, int sta, int end) {
//        t = new Thread(this);
//        this.chars = chars;
//        this.shareResource = shareResource;
//        this.sta = sta;
//        this.end = end;
//
//    }
//
//    public void start() {
//        t.start();
//    }
//
//    public void join() throws InterruptedException {
//        t.join();
//    }
//
//    @Override
//    public void run() {
//        synchronized (shareResource) {
//            for (char c : chars) {
//                if(shareResource.getNum() == sta) {
//                    System.out.print(c);
//                    shareResource.setNum(end);
//                    try {
//                        shareResource.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//                else {
//
//                    shareResource.notifyAll();
//
//                }
//            }
//
//
//        }
//    }
//}