package challangeOOPFinal_MH.tax;

import challangeOOPFinal_MH.allowances.Allowance;

import java.time.LocalDate;

public class Tax extends Allowance {
    private double pph;
    private double tapera;
    //private double ppn;

    /*public Tax(LocalDate payDay, double pph, double tapera, double ppn) {
        super(payDay);
        this.pph = pph;
        this.tapera = tapera;
        this.ppn = ppn;
    }*/

    //======= Constructor =======//
    public Tax(LocalDate payDay, double pph, double tapera) {
        super(payDay);
        this.pph = pph;
        this.tapera = tapera;
    }



    public double getPph() {
        return pph;
    }

    public void setPph(double pph) {
        this.pph = pph;
    }

    public double getTapera() {
        return tapera;
    }

    public void setTapera(double tapera) {
        this.tapera = tapera;
    }

    /*public double getPpn() {
        return ppn;
    }

    public void setPpn(double ppn) {
        this.ppn = ppn;
    }*/

    @Override
    public String toString() {
        return " Tax{" +
                "pph=" + pph +
                ", tapera=" + tapera +
                '}';
    }
}
