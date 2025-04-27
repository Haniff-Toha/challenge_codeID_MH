package day03.part6.hr;

import day03.part6.ISalary;
import day03.part6.salary.Commission;
import day03.part6.salary.Overtime;

import java.time.LocalDate;

public class Sales extends Employee implements ISalary {

    private Overtime makan;
    private Commission commission;

    public Sales(String nationalId, String fullName, int empId, LocalDate hireDate, double salary, Overtime makan, Commission commission) {
        super(nationalId, fullName, empId, hireDate, Roles.SALES, salary);
        this.makan = makan;
        this.commission = commission;
    }

    @Override
    public void calculateTotalSalary() {
        setTotalSalary((getSalary()+ commission.getBonus() + commission.getCommission() + makan.getMakan())- getTotalTax());
    }

    @Override
    public void calcTax() {
        setTotalTax(getSalary() * 0.01);
    }
}
