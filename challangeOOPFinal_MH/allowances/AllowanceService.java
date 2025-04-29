package challangeOOPFinal_MH.allowances;

import challangeOOPFinal_MH.tax.TaxSalary;

public interface AllowanceService extends TaxSalary {

    public void calcTotalOvertime();
    public void calcTotalOperational();
    public void calcTotalInsurance();
    public void calcTotalTax();
    public void calcTotalSalary();
}
