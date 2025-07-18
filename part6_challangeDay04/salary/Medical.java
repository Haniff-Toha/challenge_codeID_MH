package day03.part6_challangeDay04.salary;

import java.time.LocalDate;

public class Medical extends Salary{
    private double kacamata;

    public Medical(LocalDate payDay, double kacamata) {
        super(payDay);
        this.kacamata = kacamata;
    }

    public double getKacamata() {
        return kacamata;
    }

    public void setKacamata(double kacamata) {
        this.kacamata = kacamata;
    }
}
