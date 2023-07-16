import java.util.Random;
import java.util.Scanner;

public class JuZhenDemo {
    public static void main(String[] args) {
        JuZhen juZhen = new JuZhen(2,3);
        juZhen.create();
        juZhen.show();
        JuZhen zhuanZhi = juZhen.zhuanZhi();
        zhuanZhi.show();
        JuZhen juZhen2 = new JuZhen(2,3);
        juZhen2.create();
        juZhen.add(juZhen2);
        juZhen.show();
//        JuZhen juZhen = new JuZhen(3,4);
//        juZhen.randomCreate();
//        juZhen.show();


    }
}

class JuZhen {  //矩阵

    int[][] array;
    int row,col;

    public void setArray(int row,int col) {
        array = new int[row][col];
        this.row = row;
        this.col = col;
    }

    public JuZhen() {}
    public JuZhen(int row,int col) {
        array = new int[row][col];
        this.row = row;
        this.col = col;
    }

    /**
     * 初始化矩阵
     */
    public void create() {
        System.out.println("请输入一个"+row+"行"+col+"列的矩阵");
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                array[i][j] = sc.nextInt();
            }
        }

    }
    public void randomCreate() {
        Random r = new Random();
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                array[i][j] = r.nextInt(100);
            }
        }
    }

    /**
     * 矩阵转置
     */
    public JuZhen zhuanZhi() {
        int col = this.row;
        int row = this.col;
        JuZhen newJuZhen = new JuZhen(row,col);
        for(int i=0;i< this.row;i++) {
            for(int j=0;j<this.col;j++) {
                newJuZhen.array[j][i] = this.array[i][j];
            }
        }
        return newJuZhen;
    }

    /**
     * 矩阵的加法
     * @param juZhen
     */
    public void add(JuZhen juZhen) {
        if(juZhen.row == this.row && juZhen.col == this.col) {
            for(int i=0;i<this.row;i++) {
                for(int j=0;j<this.col;j++) {
                    this.array[i][j] += juZhen.array[i][j];
                }
            }
        } else {
            System.out.println("该矩阵无法相加");
        }


    }


    /**
     * 输出矩阵
     */
    public void show() {
        for(int i=0;i<this.row;i++) {
            for(int j=0;j<this.col;j++) {
                System.out.print(this.array[i][j]+" ");
            }
            System.out.println();
        }
    }
}
