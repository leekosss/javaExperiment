package three;

//经理
public class Manager implements Add,Salary {

    private double salary;

    @Override
    public void addSalary() {
        this.salary *= 1.2;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
