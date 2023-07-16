package pac1;

class hoDog {
    char[] buf = new char[2];
    boolean isFull = false;
    boolean isEmpty = true;
    int next = 0;

    public synchronized void add(char c) {
        while (isFull == true) {
            try {
                wait();
                System.out.println(666);
            } catch (InterruptedException e) {

            }
        }
        buf[next] = c;
        next++;
        if (next == 2) isFull = true;
        isEmpty = false;
        notifyAll();
    }

    public synchronized char get() {
        while (isEmpty == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        next--;
        if (next == 0) isEmpty = true;
        isFull = false;
        notifyAll();
        return buf[next];
    }
}

class producer extends Thread {
    hoDog hd;
    String alp = "HotDog";

    public producer(hoDog h) {
        hd = h;
    }

    public void run() {
        char c;
        //synchronized (hd){
        for (int i = 0; i < 6; i++) {
            c = alp.charAt(i);
            hd.add(c);
            System.out.println("product a hotdog:" + c);
        }
        //}

    }
}

class consumer extends Thread {
    hoDog hd;

    public consumer(hoDog h) {
        hd = h;
    }

    public void run() {
        char c;
        //synchronized (hd){
        for (int i = 0; i < 6; i++) {
            c = hd.get();
            System.out.println("get a hotdog:" + c);
        }
        //}

    }
}

class hdT {
    public static void main(String[] args) {
        hoDog h = new hoDog();
        producer p = new producer(h);
        consumer c = new consumer(h);
        p.start();
        c.start();
    }
}