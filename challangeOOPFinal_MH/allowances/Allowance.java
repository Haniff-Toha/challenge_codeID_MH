package challangeOOPFinal_MH.allowances;

import java.time.LocalDate;

public class Allowance {
    private double totalAllowance;
    private double po;
    private LocalDate payDay;

    public Allowance(LocalDate payDay/*, double po, double totalAllowance*/) {
        this.payDay = payDay;
        //this.po = po;
        //this.totalAllowance = totalAllowance;
    }

    public Allowance(/*double totalAllowance*/ /*, double po*/) {
        //this.totalAllowance = totalAllowance;
        //this.po = po;
    }

    public double getTotalAllowance() {
        return totalAllowance;
    }

    public void setTotalAllowance(double totalAllowance) {
        this.totalAllowance = totalAllowance;
    }

    /*public double getPo() {
        return po;
    }

    public void setPo(double po) {
        this.po = po;
    }*/
}
