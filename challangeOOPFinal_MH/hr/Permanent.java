package challangeOOPFinal_MH.hr;

import challangeOOPFinal_MH.tax.Tax;
import challangeOOPFinal_MH.allowances.AllowanceService;
import challangeOOPFinal_MH.allowances.Insurance;
import challangeOOPFinal_MH.allowances.Operational;
import challangeOOPFinal_MH.allowances.Overtime;

import java.time.LocalDate;

public class Permanent extends Employee implements AllowanceService {
    private Insurance insurance;
    private Overtime overtime;
    private Operational operational;
    private Tax tax;

    public Permanent(int empNo, String fullName, LocalDate hireDate, double salary, Insurance insurance, Overtime overtime, Operational operational, Tax tax) {
        super(empNo, fullName, hireDate, EmployeeType.PERMANENT, salary);
        this.insurance = insurance;
        this.overtime = overtime;
        this.operational = operational;
        this.tax = tax;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Overtime getOvertime() {
        return overtime;
    }

    public void setOvertime(Overtime overtime) {
        this.overtime = overtime;
    }

    public Operational getOperational() {
        return operational;
    }

    public void setOperational(Operational operational) {
        this.operational = operational;
    }

    @Override
    public void calcTotalOvertime() {
        setTotalOvertime(overtime.getHours() * overtime.getOvertime());
    }

    @Override
    public void calcTotalOperational() {
        setTotalOperational((operational.getLunch() + operational.getTransport()) * operational.getDays());
    }

    @Override
    public void calcTotalInsurance() {
        setTotalInsurance((getSalary() * insurance.getMedical()) * (insurance.getSelf() + insurance.getDependent()));
    }

    @Override
    public void calcTotalTax() {
        setTotalTax((getSalary() * tax.getPph()) + (getSalary() * tax.getTapera()));
    }

    @Override
    public void calcTotalSalary() {
        setTotalSalary((getSalary() + getTotalOvertime() + getTotalOperational()) - (getTotalInsurance() + getTotalTax()));
    }

    @Override
    public void calcPph() {
        int pphDibayarkan=0;
        System.out.println(pphDibayarkan = (int) (getSalary() * tax.getPph()));
    }

    @Override
    public void calcTapera() {

    }

    @Override
    public String toString() {
        return super.toString() +
                 insurance +
                " totalIns= " + getTotalInsurance() +
                overtime +
                " totalOvr= " + getTotalOvertime() +
                operational +
                " totalOpr= " + getTotalOperational() +
                tax +
                " totalTax= " + getTotalTax() +
                '}';
    }
}
