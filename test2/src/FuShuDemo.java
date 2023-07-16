public class FuShuDemo {
    public static void main(String[] args) {
        FuShu f1 = new FuShu(3,6);
        FuShu f2 = new FuShu(3,6);
        f1.add(f2);
        System.out.println(f1.toString());
        f1.minus(f2);
        System.out.println(f1.toString());
        System.out.println(f1.compare(f2));

    }
}

class FuShu {
    private int shi,xu;  //实部、虚部

    public FuShu() {

    }
    public FuShu(int shi,int xu) {
        this.shi = shi;
        this.xu = xu;
    }

    public int getShi() {
        return shi;
    }

    public void setShi(int shi) {
        this.shi = shi;
    }

    public int getXu() {
        return xu;
    }

    public void setXu(int xu) {
        this.xu = xu;
    }

    public void add(FuShu f) {   //复数的加法
        this.shi += f.shi;
        this.xu += f.xu;
    }
    public FuShu add(FuShu f1,FuShu f2) {
        FuShu fuShu = new FuShu();
        fuShu.shi = f1.shi + f2.shi;
        fuShu.xu = f1.xu + f2.xu;
        return fuShu;
    }

    public void minus(FuShu f) {   //复数的减法
        this.shi -= f.shi;
        this.xu -= f.xu;
    }
    public FuShu minus(FuShu f1,FuShu f2) {
        FuShu fuShu = new FuShu();
        fuShu.shi = f1.shi - f2.shi;
        fuShu.xu = f1.xu - f2.xu;
        return fuShu;
    }

    public String toString() {
        String str = null;
        if(xu>0) {
            str = "复数: "+shi +"+"+xu +"i";
        } else if(xu==0) {
            str = "复数:" +shi;
        } else {
            str = "复数:" +shi+xu +"i";
        }
        return str;
    }

    public boolean compare(FuShu f) {
        boolean flag=false;
        if(f.shi == this.shi && this.xu == f.xu) {
            flag = true;
        }
        return flag;
    }
}
