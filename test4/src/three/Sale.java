package three;

//销售
public class Sale implements Add, Salary {
    private double salary;
    private double extraSalary;
    private double baseSalary;

    public void setExtraSalary(double extraSalary) {
        this.extraSalary = extraSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setSalary() {
        this.salary = this.extraSalary + this.baseSalary;
    }

    @Override
    public void addSalary() {
        this.salary *= 1.1;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
