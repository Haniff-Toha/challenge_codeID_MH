package day03.part6_challangeDay04.salary;

import java.time.LocalDate;

public class Salary {
    private LocalDate payDay;
    //private double totalSalary;

    public Salary(LocalDate payDay/*, double totalSalary*/) {
        this.payDay = payDay;
        //this.totalSalary = totalSalary;
    }

    public LocalDate getPayDay() {
        return payDay;
    }

    public void setPayDay(LocalDate payDay) {
        this.payDay = payDay;
    }

    /*public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }*/
}
