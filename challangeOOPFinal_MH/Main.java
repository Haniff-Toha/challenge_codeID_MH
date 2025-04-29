package challangeOOPFinal_MH;

import challangeOOPFinal_MH.hr.EmployeeType;

public class Main {
    public static void main(String[] args) {
        HRService HRInf = new HRServiceImpl();
        SalaryService SalaryInf = new SalaryServiceImpl();

        var employees = HRInf.initEmployeeData();

        //=========== Generate semua calculation ==========//
        SalaryInf.generateInsurance(employees);
        SalaryInf.generateOperational(employees);
        SalaryInf.generateOvertime(employees);

        SalaryInf.generateTax(employees);

        SalaryInf.generateSalary(employees);
        //=================================================//

        //=========== Coba interface dari puml ===========//
        //SalaryInf.getTotalAllowances(employees);
        //SalaryInf.getTotalSalaryByType(employees, EmployeeType.PERMANENT);

        //HRInf.getTotalEmployee(employees);
        //HRInf.getTotalEmployeeByType(employees, EmployeeType.PERMANENT);
        //=============================================//

        HRInf.displayEmployee(employees);
    }
}
