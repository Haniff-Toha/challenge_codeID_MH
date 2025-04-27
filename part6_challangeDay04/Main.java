package day03.part6_challangeDay04;

public class Main {
    public static void main(String[] args) {
        IEmployee empInf = new EmployeeImpl();

        var employees = empInf.initListEmployee();


        empInf.generateTax(employees);
        empInf.generateSalary(employees);
        empInf.displayEmployees(employees);
    }
}
