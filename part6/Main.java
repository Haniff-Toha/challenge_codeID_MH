package day03.part6;

import day03.part6.hr.Programmer;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        IEmployee empInf = new EmployeeImpl();

        var employees = empInf.initListEmployee();


        empInf.generateTax(employees);
        empInf.generateSalary(employees);
        empInf.displayEmployees(employees);
    }
}
