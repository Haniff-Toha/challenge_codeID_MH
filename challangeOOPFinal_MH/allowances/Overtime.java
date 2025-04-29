package challangeOOPFinal_MH.allowances;

import java.time.LocalDate;

public class Overtime extends Allowance{
    private double overtime;
    private double hours;

    public Overtime(/*double totalAllowance,*/ double overtime, double hour) {
        super(LocalDate.now());
        this.overtime = overtime;
        this.hours = hour;
        //this.totalOvertime = totalOvertime;
    }

    public double getOvertime() {
        return overtime;
    }

    public void setOvertime(double overtime) {
        this.overtime = overtime;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    /*public double getTotalOvertime() {
        return totalOvertime;
    }

    public void setTotalOvertime(double totalOvertime) {
        this.totalOvertime = totalOvertime;
    }*/

    @Override
    public String toString() {
        return " Overtime{" +
                "overtime=" + overtime +
                ", hours=" + hours +
                '}';
    }
}
