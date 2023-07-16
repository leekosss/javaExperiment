package six;

import java.util.Scanner;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入5个数字(头插法):");
        System.out.println("请输入5个数字(尾插法):");
        for(int i=0;i<5;i++) {
            int x = sc.nextInt();
//            linkedList.addHeadNode(x);
            linkedList.addTailNode(x);
        }
        linkedList.showLinkedList();
    }
}
//头节点型单链表
class LinkedList {
    private Node node;
    private Node head;
    private Node tail;

    public LinkedList() {
        node = new Node();
        head = node;
        tail = node;
    }


    //节点内部类
    public class Node {
        int data;
        Node next;
        public Node() {
            this.data = -1;
            next = null;
        }
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    /**
     * 在头节点后面添加节点
     * @param data
     */
    public void addHeadNode(int data) {
        Node newNode = new Node(data);
        newNode.next = head.next;
        if(head.next == null) {
            this.tail = newNode;
        }
        head.next = newNode;

    }

    /**
     * 在尾节点后面添加节点
     * @param data
     */
    public void addTailNode(int data) {
        Node newNode = new Node(data);
        this.tail.next = newNode;
        tail = tail.next;
    }

    /**
     * 输出单链表
     */
    public void showLinkedList() {
        Node p = this.head.next;
        System.out.println("单链表数据如下:");
        while(p!=null) {
            System.out.print(p.data + "=>");
            p = p.next;
        }
        System.out.println();
    }

}
