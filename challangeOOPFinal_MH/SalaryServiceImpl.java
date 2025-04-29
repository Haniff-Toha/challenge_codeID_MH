package challangeOOPFinal_MH;

import challangeOOPFinal_MH.hr.Employee;
import challangeOOPFinal_MH.hr.EmployeeType;

import java.util.List;

public class SalaryServiceImpl implements SalaryService{
    @Override
    public void generateOvertime(List<Employee> emps) {
        for(Employee emp : emps){
            emp.calcTotalOvertime();
        }
    }

    @Override
    public void generateInsurance(List<Employee> emps) {
        for(Employee emp : emps){
            emp.calcTotalInsurance();
        }
    }

    @Override
    public void generateOperational(List<Employee> emps) {
        for(Employee emp : emps){
            emp.calcTotalOperational();
        }
    }

    @Override
    public void generateTax(List<Employee> emps) {
        for(Employee emp : emps){
            emp.calcTotalTax();
        }
    }

    @Override
    public void generateSalary(List<Employee> emps) {
        for(Employee emp : emps){
            emp.calcTotalSalary();
        }
    }

    @Override
    public void getTotalAllowances(List<Employee> emps) {
        double totalAlowance = 0;
        for (Employee emp : emps){
            totalAlowance += emp.getTotalSalary();
        }
        System.out.println(totalAlowance);
    }

    @Override
    public void getTotalSalaryByType(List<Employee> emps, EmployeeType empType) {
        double salaryOfType = 0;
        for (Employee emp : emps){
            if (emp.getStatus() == empType) {
                salaryOfType += emp.getTotalSalary();
            }
        }
        System.out.println("Total Salary of " + empType + " = " + salaryOfType);
    }
}
