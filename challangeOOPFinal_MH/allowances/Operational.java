package challangeOOPFinal_MH.allowances;

import java.time.LocalDate;

public class Operational extends Allowance{
    private int days;
    private double lunch;
    private double transport;
    private double totalOperational;

    public Operational(/*double totalAllowance,*/ int days, double lunch, double transport/*, double totalOperational*/) {
        super(LocalDate.now());
        this.days = days;
        this.lunch = lunch;
        this.transport = transport;
        //this.totalOperational = totalOperational;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getLunch() {
        return lunch;
    }

    public void setLunch(double lunch) {
        this.lunch = lunch;
    }

    public double getTransport() {
        return transport;
    }

    public void setTransport(double transport) {
        this.transport = transport;
    }

    /*public double getTotalOperational() {
        return totalOperational;
    }

    public void setTotalOperational(double totalOperational) {
        this.totalOperational = totalOperational;
    }*/

    @Override
    public String toString() {
        return " Operational{" +
                "days=" + days +
                ", lunch=" + lunch +
                ", transport=" + transport +
                '}';
    }
}
