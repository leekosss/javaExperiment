package leekos.four;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        LinkList linkList = new LinkList();
//        linkList.create();
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.dat"));
//        oos.writeObject(linkList);
//        oos.close();
//        linkList.printLinkList();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.dat"));
        LinkList linkList2 = (LinkList) ois.readObject();
        ois.close();
//        linkList.printLinkList();
        linkList2.printLinkList();
    }
}

/**
 * 带头结点的单链表
 */
class LinkList implements Serializable {
    int data;
    LinkList next,tail;

    public void create() {
        tail = this;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一组数，以-1结束:");
        int x;
        x = sc.nextInt();
        while(x!=-1) {
            LinkList list = new LinkList();
            list.data = x;
            list.next = null;
            tail.next = list;
            tail = list;
            x = sc.nextInt();
        }
    }
    public void addNodeToTail(int data) {
        LinkList list = new LinkList();
        list.data = data;
        list.next = null;
        tail.next = list;
        tail = list;
    }

    public void printLinkList() {
        LinkList p = this.next;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

}