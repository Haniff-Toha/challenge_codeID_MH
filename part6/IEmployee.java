package day03.part6;

import day03.part6.hr.Employee;
import day03.part6.hr.Programmer;

import java.util.List;

public interface IEmployee {

    List<Employee> initListEmployee();

    void displayEmployees(List<Employee> emps);

    void generateSalary(List<Employee> emps);

    void generateTax(List<Employee> emps);
}
