package test.test5;

public class Student {
    private double score;

    public Student() {
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        try {
            if(score<0 || score >100) {
                throw new ScoreException("成绩有误！请重新输入！");
            }
            this.score = score;
        } catch(ScoreException e) {
            System.out.println("请输入0~100之内的分数！");
        } catch(Exception e) {
            System.out.println("请输入0~100之内的分数！");
        }

    }
    public void show() {
        System.out.println("成绩为:" + score);
    }
}
