import java.util.Scanner;

public class LinkedListDemo {
    public static void main(String[] args) {

        LinkedList myList = new LinkedList();
        myList.create();
        myList.show();
        LinkedList list = new LinkedList();
        list.create();
        list.show();
//        LinkedList merge = myList.merge(myList, list);
//        merge.show();
        LinkedList merge = myList.merge(list);
        merge.show();
//        myList.insert(myList.next.next,list);
//        myList.delete(myList.next);
//        myList.query(list);
//        myList.show();





    }


}

class LinkedList {
    int data;
    LinkedList next = null;

    public void create() {  //创建单链表
        int x,num=0;
        LinkedList head = this;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入建表序列，以-1结束");
        x = sc.nextInt();
        while(x!=-1) {
            LinkedList list = new LinkedList();
            list.data = x;
            list.next = head.next;
            head.next = list;
            num++;
            x = sc.nextInt();
        }
        head.data = num;

    }

    public void insert(LinkedList list,LinkedList myList) {  //单链表在list节点前插入myList
        LinkedList pre = this,p=this.next;
        while(p!=null && p.data != list.data) {
            p = p.next;
            pre = pre.next;
        }
        myList.next = p;
        pre.next = myList;

    }

    public void delete(LinkedList list) { //删除单链表中的某个节点
        LinkedList pre=this,p=this.next;
        while(p!=null && (p.data!=list.data)) {
            p=p.next;
            pre = pre.next;
        }
        if(p!=null) {
            pre.next = p.next;
        }


    }

    public void query(LinkedList list) {  //查询
        LinkedList p = this.next;
        while(p!=null && p.data!=list.data) {
            p=p.next;
        }
        if(p!=null) {
            System.out.println("found it!");
        } else {
            System.out.println("not found!");
        }
    }

    public LinkedList merge(LinkedList L1,LinkedList L2) {  //将升序表合并成降序表
        LinkedList newList = new LinkedList();
        LinkedList head = newList;
        LinkedList p=L1.next,q=L2.next;
        LinkedList temp;
        int num=0;
        while(p!=null&&q!=null) {
            if(p.data<q.data) {
                temp = p;
                p=p.next;

            } else {
                temp = q;
                q=q.next;
            }
            temp.next=head.next;
            head.next=temp;
            num++;
        }
        while(p!=null) {
            temp=p;
            p=p.next;
            temp.next=head.next;
            head.next=temp;
            num++;
        }
        while(q!=null) {
            temp=q;
            q=q.next;
            temp.next=head.next;
            head.next=temp;
            num++;
        }
        newList.data = num;
        return newList;

    }

    public LinkedList merge(LinkedList L) {  //升序表合成为升序表
        LinkedList newList = new LinkedList();
        LinkedList tail=newList;
        LinkedList p=this.next,q=L.next;
        LinkedList temp;
        int num=0;
        while(p!=null&&q!=null) {
            if(p.data<q.data) {
                temp = p;
                p=p.next;

            } else {
                temp = q;
                q=q.next;
            }

            tail.next = temp;
            tail = temp;


            num++;
        }
        while(p!=null) {
            temp=p;
            p=p.next;
            tail.next = temp;
            tail = temp;
            num++;
        }
        while(q!=null) {
            temp=q;
            q=q.next;
            tail.next = temp;
            tail = temp;
            num++;
        }
        newList.data = num;
        return newList;


    }



    public void show() {  //输出单链表
        LinkedList list = this;
        while(list.next != null) {
            System.out.print(list.next.data + " ");
            list = list.next;
        }
        System.out.println();

    }

}