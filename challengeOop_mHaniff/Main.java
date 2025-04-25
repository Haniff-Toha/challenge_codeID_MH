package day03.challengeOop_mHaniff;


import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehicle vhc1 = new Suv("D 1001 UM",2010,350_000_000, 3_500_000,
                4, LocalDate.of(2023,1,10),500_000,150_000);
        Vehicle vhc2 = new Suv("D 1002 UM",2010,350_000_000, 3_500_000,
                4, LocalDate.of(2023,1,10),500_000,150_000);
        Vehicle vhc3 = new Suv("D 1003 UM",2015,350_000_000, 3_500_000,
                5, LocalDate.of(2023,1,12),500_000,150_000);
        Vehicle vhc4 = new Suv("D 1004 UM",2015,350_000_000, 3_500_000,
                5, LocalDate.of(2023,1,13),500_000,150_000);
        Vehicle vhc5 = new Taxi("D 11 UK",2002,175_000_000, 1_750_000,
                4, LocalDate.of(2023,1,12),45,4_500);
        Vehicle vhc6 = new Taxi("D 12 UK",2015,275_000_000, 2_250_000,
                4, LocalDate.of(2023,1,12),75,4_500);
        Vehicle vhc7 = new Taxi("D 13 UK",2020,275_000_000, 2_750_000,
                4, LocalDate.of(2023,1,12),90,4_500);
        Vehicle vhc8 = new Plane("ID8089", 2015,150E9,15E8,12,
                LocalDate.of(2022,12,23),55_000_000);
        Vehicle vhc9 = new Plane("ID8099", 2018,175E9,175E7,15,
                LocalDate.of(2022,12,25),75_000_000);
        Vehicle vhc10 = new Boat("Boat18", 2020,2E9,20_000_000,12,
                LocalDate.of(2022,12,25),10_000_000);


        List<Vehicle> listVehicle = List.of(vhc1,vhc2,vhc3, vhc4, vhc5, vhc6, vhc7,vhc8,vhc9,vhc10);
        int totalIncomePlane = 0;
        int totalIncomeBoat = 0;
        int totalIncomeCar = 0;
        long totalTax = 0;
        for (Vehicle vhc : listVehicle){
            totalTax += vhc.getTax();
            if (vhc.getvehicleType() == VehicleType.PrivateJet){
                totalIncomePlane += vhc.getTotal();
            } else if (vhc.getvehicleType() == VehicleType.Boat) {
                totalIncomeBoat += vhc.getTotal();
            } else {
                totalIncomeCar += vhc.getTotal();
            }
            System.out.println(vhc.toString());
        }

        // totalVehiclePurchase dimiliki oleh class, bukan object instance
        System.out.println("TotalIncomeCar: "+ totalIncomeCar);
        System.out.println("TotalIncomePlane: "+ totalIncomePlane);
        System.out.println("TotalIncomeBoat: "+ totalIncomeBoat);
        System.out.println("TotalIncomeTax: "+ totalTax);
        System.out.println("Total Car : "+ Vehicle.totalCar);
        System.out.println("Total Plane : "+ Vehicle.totalPlane);
        System.out.println("Total Boat : "+ Vehicle.totalBoat);


    }
    
}
