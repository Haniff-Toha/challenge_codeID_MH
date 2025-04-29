package challangeOOPFinal_MH.hr;

import java.time.LocalDate;

public class Employee {
    private int empNo;
    private String fullName;
    private LocalDate hireDate;
    private EmployeeType employeeType;
    private double salary;
    private double totalSalary;
    private double totalOvertime;
    private double totalOperational;
    private double totalTax;
    private double totalInsurance;

    public Employee(int empNo, String fullName, LocalDate hireDate, EmployeeType employeeType, double salary) {
        this.empNo = empNo;
        this.fullName = fullName;
        this.hireDate = hireDate;
        this.employeeType = employeeType;
        this.salary = salary;
    }

    //============== empty method untuk interface ==============//
    public void calcTotalSalary() {    }
    public void calcTotalOvertime() {    }
    public void calcTotalOperational() {    }
    public void calcTotalTax() {    }
    public void calcTotalInsurance() {    }
    //==========================================================//

    //=========== summary =======================//
    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getTotalOvertime() {
        return totalOvertime;
    }

    public void setTotalOvertime(double totalOvertime) {
        this.totalOvertime = totalOvertime;
    }

    public double getTotalOperational() {
        return totalOperational;
    }

    public void setTotalOperational(double totalOperational) {
        this.totalOperational = totalOperational;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public double getTotalInsurance() {
        return totalInsurance;
    }

    public void setTotalInsurance(double totalInsurance) {
        this.totalInsurance = totalInsurance;
    }
    //===============================================//

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public EmployeeType getStatus() {
        return employeeType;
    }

    public void setStatus(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", fullName='" + fullName + '\'' +
                ", hireDate=" + hireDate +
                ", employeeType=" + employeeType +
                ", salary=" + salary +
                ", totalSalary=" + totalSalary +
                '}';
    }
}
