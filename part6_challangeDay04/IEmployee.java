package day03.part6_challangeDay04;

import day03.part6_challangeDay04.hr.Employee;

import java.util.List;

public interface IEmployee {

    List<Employee> initListEmployee();

    void displayEmployees(List<Employee> emps);

    void generateSalary(List<Employee> emps);

    void generateTax(List<Employee> emps);
}
