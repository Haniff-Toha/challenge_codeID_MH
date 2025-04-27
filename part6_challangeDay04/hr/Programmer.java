package day03.part6_challangeDay04.hr;

import day03.part6_challangeDay04.ISalary;
import day03.part6_challangeDay04.salary.Overtime;
import day03.part6_challangeDay04.salary.Transportasi;

import java.time.LocalDate;

public class Programmer extends Employee implements ISalary {

    private Transportasi transport;
    private Overtime makan;

    public Programmer(String nationalId, String fullName, int empId, LocalDate hireDate, double salary, Transportasi transport, Overtime makan) {
        super(nationalId, fullName, empId, hireDate, Roles.PROGRAMMER, salary);
        this.transport = transport;
        this.makan = makan;
    }

    @Override
    public void calculateTotalSalary() {
        setTotalSalary((getSalary()+ transport.getBensin()+ transport.getSpj()+ transport.getTransportasi() + makan.getMakan())-getTotalTax());
    }

    @Override
    public void calcTax() {
        setTotalTax(getSalary() * 0.01);
    }
}
