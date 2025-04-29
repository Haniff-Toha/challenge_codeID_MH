package challangeOOPFinal_MH.hr;

import challangeOOPFinal_MH.allowances.AllowanceService;

import java.time.LocalDate;

public class Freelancer extends Employee implements AllowanceService, POService {
    private double po;
    private double ppn;

    public Freelancer(int empNo, String fullName, LocalDate hireDate, double salary, double po, double ppn) {
        super(empNo, fullName, hireDate, EmployeeType.FREELANCE, salary);
        this.po = po;
        this.ppn = ppn;
    }

    public double getPo() {
        return po;
    }

    public void setPo(double po) {
        this.po = po;
    }

    public double getPpn() {
        return ppn;
    }

    public void setPpn(double ppn) {
        this.ppn = ppn;
    }

    @Override
    public void calcTotalOvertime() {    }

    @Override
    public void calcTotalOperational() {    }

    @Override
    public void calcTotalInsurance() {    }

    @Override
    public void calcTotalTax() {
        setTotalTax(ppn * po);
    }

    @Override
    public void calcTotalSalary() {
        setTotalSalary(po - getTotalTax());
    }

    @Override
    public void totalPO() {

    }

    @Override
    public String toString() {
        return super.toString() +
                " po=" + po +
                ", ppn=" + ppn +
                " totalTax=" + getTotalTax() +
                '}';
    }
}
