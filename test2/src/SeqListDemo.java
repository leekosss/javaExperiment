import java.util.Scanner;


class SeqListDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SeqList list = new SeqList();
        System.out.println("请输入顺序表总长度:");
        list.setList(sc.nextInt());
        list.create();
        list.show();
//        list.insert(5,100);
//        list.show();
//        list.delete(0);
//        list.show();
//        list.insertToUp(3);
//        list.show();

        SeqList list2 = new SeqList();
        System.out.println("请输入顺序表总长度:");
        list2.setList(sc.nextInt());
        list2.create();
        list2.show();

        SeqList newList = list.merge(list, list2);
        newList.show();
    }
}

class SeqList {  //顺序表
    int[] list;
    int len;  //表长
    public SeqList() {

    }
    public SeqList(int maxSize) {
        list = new int[maxSize];
    }
    public void setList(int maxSize) {
        list = new int[maxSize];
    }

    public void create() {  //创建顺序表
        System.out.println("请输入顺序表建表序列:");
        Scanner sc = new Scanner(System.in);
        int x,i=0;
        x = sc.nextInt();
        while(x != -1) {
            list[i] = x;
            i++;
            x = sc.nextInt();
        }
        len = i;

    }

    public void insert(int pos, int x) {  //插入
        if(pos<0 || pos>len || len == list.length) {
            return;
        }
        for(int i=len-1;i>=pos;i--) {
            list[i+1] = list[i];

        }
        list[pos] = x;
        len++;
    }

    public void delete(int pos) { //删除
        if(pos<0 || pos>=len) {
            return;
        }
        for(int i=pos;i<len-1;i++) {
            list[i] = list[i+1];
        }
        len--;
    }

    public int search(int x) {  //查询值为x的元素，返回对应的下标
        for(int i=0;i<len;i++) {
            if(x==list[i]) {
                return i;
            }
        }
        return -1;
    }

    public void show() {  //打印顺序表
        for(int i=0;i<len; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public void insertToUp(int x) {   //在升序表中插入元素依然有序
        if(len == list.length) {
            return;  //顺序表满了就不插入
        }
        int pos=0;
        while(pos<len&&x>list[pos]) {
            pos++;
        }
        for(int i=len-1;i>=pos;i--) {
            list[i+1] = list[i];
        }
        list[pos] = x;
        len++;
    }

    public SeqList merge(SeqList seqList1,SeqList seqList2) {  //两个升序合成一个新的升序

        SeqList newSeqList = new SeqList(seqList1.len+seqList2.len);
        int i=0,j=0,newPos=0;

        while(i< seqList1.len&&j< seqList2.len) {

            if(seqList1.list[i]<seqList2.list[j]) {
                newSeqList.list[newPos] = seqList1.list[i];
                i++;
            } else {
                newSeqList.list[newPos] = seqList2.list[j];
                j++;
            }
            newPos++;

        }
        while(i<seqList1.len) {
            newSeqList.list[newPos] = seqList1.list[i];
            newPos++;
            i++;
        }
        while(j<seqList2.len) {
            newSeqList.list[newPos] = seqList2.list[j];
            newPos++;
            j++;
        }
        newSeqList.len = newPos;
        return newSeqList;
    }
}
