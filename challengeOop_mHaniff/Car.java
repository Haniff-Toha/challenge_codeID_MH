package day03.challengeOop_mHaniff;

import java.time.LocalDate;

public class Car extends Vehicle {
    public Car(String noPolice, VehicleType vehicleType, int year, double price, double tax, int seat, LocalDate transactionDate) {
        super(noPolice, vehicleType, year, price, tax, seat, transactionDate);
        totalCar++;
    }
}
