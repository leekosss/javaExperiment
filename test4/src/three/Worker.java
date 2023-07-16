package three;


//工人
public class Worker implements Add, Salary {
    private double salary;
    private double daySalary;
    private int workDays;

    public void setSalary() {
        this.salary = this.daySalary * this.workDays;
    }

    public void setDaySalary(double daySalary) {
        this.daySalary = daySalary;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    @Override
    public void addSalary() {
        this.salary *= 1.1;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
