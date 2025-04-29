package challangeOOPFinal_MH;

import challangeOOPFinal_MH.tax.Tax;
import challangeOOPFinal_MH.allowances.Insurance;
import challangeOOPFinal_MH.allowances.Operational;
import challangeOOPFinal_MH.allowances.Overtime;
import challangeOOPFinal_MH.hr.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HRServiceImpl implements HRService{

    @Override
    public List<Employee> initEmployeeData() {
        List<Employee> employees = new ArrayList<>();

        Permanent emp1 = new Permanent(100,"Anton", LocalDate.of(2020,4,2),
                20_000_000,
                new Insurance(1, 2, 0.02),
                new Overtime(50_000, 10),
                new Operational(2, 30_000, 20_000),
                new Tax(LocalDate.now(),0.005, 0.005));

        Permanent emp2 = new Permanent(101,"Budi", LocalDate.of(2021,4,2),
                15_000_000,
                new Insurance(1, 3, 0.02),
                new Overtime(50_000, 0),
                new Operational(0, 0, 0),
                new Tax(LocalDate.now(),0.005, 0.005));

        Contract emp3 = new Contract(102, "Charlie", LocalDate.of(2022,2,4),
                15_000_000,
                new Insurance(1,0,0.02),
                new Overtime(45_000,5),
                new Operational(0,0,0),
                new Tax(LocalDate.now(),0.005,0.005));

        Contract emp4 = new Contract(103, "Dian", LocalDate.of(2023,2,4),
                10_000_000,
                new Insurance(1,0,0.02),
                new Overtime(45_000,6),
                new Operational(0,0,0),
                new Tax(LocalDate.now(),0.005,0.005));

        Trainee emp5 = new Trainee(104,"Gita", LocalDate.of(2024,2,4),
                0,
                new Operational(25, 30_000,20_000));

        Freelancer emp6 = new Freelancer(105, "Rima", LocalDate.of(2025,2,4),
                0,25_000_000,0.025);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);


        return employees;
    }

    @Override
    public void displayEmployee(List<Employee> emps) {
        int totalEmployee=0;
        int totalSalary = 0;
        int totalInsurance = 0;
        int totalOvertime = 0;
        int totalOperational = 0;
        int totalTax = 0;

        for (Employee emp : emps){
            System.out.println(emp.toString());

            totalEmployee++;
            totalSalary += emp.getTotalSalary();
            totalInsurance += emp.getTotalInsurance();
            totalOvertime += emp.getTotalOvertime();
            totalOperational += emp.getTotalOperational();
            totalTax += emp.getTotalTax();
        }

        System.out.println("\n===== SUMMARY =======");
        System.out.println("Total Employee     : " + totalEmployee);
        System.out.println("Total Salary       : Rp " + totalSalary);
        System.out.println("Total Insurance    : Rp " + totalInsurance);
        System.out.println("Total Overtime     : Rp " + totalOvertime);
        System.out.println("Total Operational  : Rp " + totalOperational);
        System.out.println("Total Tax          : Rp " + totalTax);
        System.out.println("=====================");
    }

    @Override
    public void getTotalEmployee(List<Employee> emps) {
        int totalEmployee = 0;
        for (Employee emp : emps){
            totalEmployee++;
        }
        System.out.println(totalEmployee);
    }

    @Override
    public void getTotalEmployeeByType(List<Employee> emps, EmployeeType empType) {
        int totalEmployee=0;
        for (Employee emp : emps){
            if (emp.getStatus() == empType) {
                totalEmployee++;
            }
        }
        System.out.println("Total" + empType + "= " + totalEmployee);
    }
}
