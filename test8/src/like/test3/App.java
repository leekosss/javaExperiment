package like.test3;

public class App {
    public static void main(String[] args) {
        DianHuaTing d=new DianHuaTing();
        String[] s1={"1","2","3"};
        String[] s2={"A","B","C","D","E"};
        String[] s3={"你好，","我也好，","大家都好！"};
        Talkers t1=new Talkers(d,"张三",s1);
        Talkers t2=new Talkers(d,"李四",s2);
        Talkers t3=new Talkers(d,"王五",s3);
        t1.start (); t2.start (); t3.start ();

    }
}
class DianHuaTing {
    private final String dht = "电话亭";
}

class Talkers extends Thread {

     private DianHuaTing dht;
     private String[] sentences;
     private String name;
     public Talkers(DianHuaTing dht,String name,String[] sentences) {
         this.dht = dht;
         this.sentences = sentences;
         this.name = name;
     }

     public void run() {

         synchronized(dht) {
             System.out.print(name +" say: ");
             for(String s: sentences){
                 System.out.print( s + " ");
             }
             System.out.println();
         }

     }

}