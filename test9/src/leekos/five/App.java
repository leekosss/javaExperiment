package leekos.five;

import java.io.*;

public class App {
    public static void main(String[] args) {
        C c = new C();
        c.x = 99;
        B b = new B();
        b.s = "b";
        b.c = c;
        A a = new A();
        a.x = 97;
        a.b = b;
        try {
            FileOutputStream fos = new FileOutputStream("a.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);
            FileInputStream fis = new FileInputStream("a.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            A new_a = (A) ois.readObject();
            compare(a, new_a);
        } catch (Exception e) {
            System.out.println("两者状态不同");
        }

    }

    public static void compare(A old_a, A new_a) {
        boolean flag = true;
        flag = old_a.equals(new_a);
        if (flag) {
            System.out.println("两者状态相同");
        } else {
            System.out.println("两者状态不同");
        }
    }
}

class A implements Serializable {
    int x;
    B b;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        if (x != a.x) return false;
        return b != null ? b.equals(a.b) : a.b == null;
    }

}

class B implements Serializable {
    String s;
    C c;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        B b = (B) o;

        if (s != null ? !s.equals(b.s) : b.s != null) return false;
        return c != null ? c.equals(b.c) : b.c == null;
    }

}

class C implements Serializable {
    int x;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        C c = (C) o;

        return x == c.x;
    }

}