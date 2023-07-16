public class ClassManage {
    public static void main(String[] args) {
        Student s1 = new Student("like", 'M', 19, false, 100);
        Student s2 = new Student("like", 'M', 19, false, 100);
        Student s3 = new Student("like", 'M', 19, false, 100);
        BanJi b = new BanJi(10);
        b.addStudent(s1,s2,s3,s1);
        b.show();
    }
}

/**
 * 学生类
 */
class Student {
    String name;
    char gender;
    int age;
    boolean isDangYuan;
    double score;

    public Student() {
    }

    public Student(String name, char gender, int age, boolean isDangYuan, double score) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.isDangYuan = isDangYuan;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDangYuan() {
        return isDangYuan;
    }

    public void setDangYuan(boolean dangYuan) {
        isDangYuan = dangYuan;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    public String toString() {
        return "学生:\n姓名:" + name + " 性别:" + gender + " 年龄:" + age + " 党员:" + isDangYuan + " 成绩:" + score;
    }

    public void show() {
        String str = "学生:\n姓名:" + name + " 性别:" + gender + " 年龄:" + age + " 党员:" + isDangYuan + " 成绩:" + score;
        System.out.println(str);
    }
}

class BanJi {
    private int maxNum;  //班级最大容量
    Student[] students;
    int len;

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
        students = new Student[maxNum];
    }

    public int getMaxNum() {
        return maxNum;
    }


    public BanJi() {
    }

    public BanJi(int maxNum) {
        this.maxNum = maxNum;
        students = new Student[maxNum];
    }

    public void addStudent(Student... stu) {
        for (Student student : stu) {
            students[len] = student;
            len++;
        }
    }

    public void show() {
        for (int i = 0; i < len; i++) {
            System.out.println("学生:\n姓名:" + students[i].name + " 性别:" + students[i].gender + " 年龄:" + students[i].age + " 党员:" + students[i].isDangYuan + " 成绩:" + students[i].score);
        }
    }
}
