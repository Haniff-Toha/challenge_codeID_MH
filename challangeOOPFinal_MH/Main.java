package challangeOOPFinal_MH;

public class Main {
    public static void main(String[] args) {
        HRService HRInf = new HRServiceImpl();
        SalaryService SalaryInf = new SalaryServiceImpl();

        var employees = HRInf.initEmployeeData();

        SalaryInf.generateInsurance(employees);
        SalaryInf.generateOperational(employees);
        SalaryInf.generateOvertime(employees);

        SalaryInf.generateTax(employees);

        SalaryInf.generateSalary(employees);

        HRInf.displayEmployee(employees);
    }
}
