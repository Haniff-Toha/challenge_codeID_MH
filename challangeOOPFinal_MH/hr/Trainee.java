package challangeOOPFinal_MH.hr;

import challangeOOPFinal_MH.allowances.AllowanceService;
import challangeOOPFinal_MH.allowances.Operational;

import java.time.LocalDate;

public class Trainee extends Employee implements AllowanceService {
    private Operational operational;

    public Trainee(int empNo, String fullName, LocalDate hireDate, double salary, Operational operational) {
        super(empNo, fullName, hireDate, EmployeeType.MAGANG, salary);
        this.operational = operational;
    }

    public Operational getOperational() {
        return operational;
    }

    public void setOperational(Operational operational) {
        this.operational = operational;
    }

    @Override
    public void calcTotalOvertime() {    }

    @Override
    public void calcTotalOperational() {
        setTotalOperational((operational.getLunch() + operational.getTransport()) * operational.getDays());
    }

    @Override
    public void calcTotalInsurance() {    }

    @Override
    public void calcTotalTax() {    }

    @Override
    public void calcTotalSalary() {
        setTotalSalary((getSalary() + getTotalOvertime() + getTotalOperational()) - (getTotalInsurance() + getTotalTax()));
    }

    @Override
    public String toString() {
        return super.toString() +
                " operational=" + operational +
                '}';
    }

    @Override
    public void calcPph() {

    }

    @Override
    public void calcTapera() {

    }
}
