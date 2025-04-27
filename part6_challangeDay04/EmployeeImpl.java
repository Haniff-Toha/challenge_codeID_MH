package day03.part6_challangeDay04;

import day03.part6_challangeDay04.hr.*;
import day03.part6_challangeDay04.salary.Commission;
import day03.part6_challangeDay04.salary.Overtime;
import day03.part6_challangeDay04.salary.Transportasi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements IEmployee{

    @Override
    public List<Employee> initListEmployee() {
        List<Employee> employees = new ArrayList<>();

        Programmer emp1 = new Programmer("300","Budi", 100,
                LocalDate.of(2025,2,24), 6_000_000,
                new Transportasi(LocalDate.now(),500_000, 150_000, 100_000), new Overtime(LocalDate.now(), 100_000));
        QA emp2 = new QA("301", "Rian", 707,LocalDate.of(2027, 2, 24),6_000_000,
                new Overtime(LocalDate.now(), 100_000));
        Sales emp3 = new Sales("302", "Rangga", 212, LocalDate.of(2025, 5, 17), 6_000_000,
                new Overtime(LocalDate.now(), 100_000), new Commission(LocalDate.now(), 500_000, 100_000));


        //return List.of(emp1);
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        return employees;
    }

    @Override
    public void displayEmployees(List<Employee> emps) {
        for (Employee emp : emps){
            System.out.println(emp.toString());
        }
    }


    @Override
    public void generateSalary(List<Employee> emps) {
        for (Employee emp : emps){
            emp.calculateTotalSalary();
        }
    }

    @Override
    public void generateTax(List<Employee> emps) {
        for (Employee emp : emps){
            emp.calcTax();
        }
    }
}
