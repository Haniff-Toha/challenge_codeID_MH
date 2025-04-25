package day03.challengeOop_mHaniff;

import java.time.LocalDate;

public class Vehicle {
       private String noPolice;
       private VehicleType vehicleType;
       private int year;
       private double price;
       private double tax;
       private int seat;
       private LocalDate transactionDate;
       private double total;
       public static int totalCar;
       public static int totalBoat;
       public static int totalPlane;

    public Vehicle(String noPolice, VehicleType vehicleType, int year, double price, double tax, int seat, LocalDate transactionDate) {
        this.noPolice = noPolice;
        this.vehicleType = vehicleType;
        this.year = year;
        this.price = price;
        this.tax = tax;
        this.seat = seat;
        this.transactionDate = transactionDate;
    }

    public String getNoPolice() {
        return noPolice;
    }

    public void setNoPolice(String noPolice) {
        this.noPolice = noPolice;
    }

    public VehicleType getvehicleType() {
        return vehicleType;
    }

    public void setvehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
//        if (price > 10E9){
//            throw new IllegalArgumentException("Salary > 10jt");
//        }
        this.price = price;

    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public static int getTotalCar() {
        return totalCar;
    }

    public static void setTotalCar(int totalCar) {
        Vehicle.totalCar = totalCar;
    }

    public static int getTotalBoat() {
        return totalBoat;
    }

    public static void setTotalBoat(int totalBoat) {
        Vehicle.totalBoat = totalBoat;
    }

    public static int getTotalPlane() {
        return totalPlane;
    }

    public static void setTotalPlane(int totalPlane) {
        Vehicle.totalPlane = totalPlane;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "VehiclePurchase{" +
                "noPolice='" + noPolice + '\'' +
                ", vehicleType=" + vehicleType +
                ", year=" + year +
                ", price=" + price +
                ", tax=" + tax +
                ", seat=" + seat +
                ", transactionDate=" + transactionDate +
                ", total=" + total +
                '}';
    }
}

