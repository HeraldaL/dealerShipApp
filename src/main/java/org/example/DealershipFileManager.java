package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DealershipFileManager {
    private static final String FILENAME = "vehicleList.csv";

    public DealerShip getDealership() {
        try {
            FileReader fileReader = new FileReader(FILENAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String input;

            input = bufferedReader.readLine();
            String[] details = input.split("\\|");
            String name = details[0];
            String address = details[1];
            String phone = details[2];
            DealerShip dealerShip = new DealerShip(name, address, phone);

            while ((input = bufferedReader.readLine()) != null) {
                String[] vehicleDetails = input.split("\\|");
                int vin = Integer.parseInt(vehicleDetails[0]);
                int year = Integer.parseInt(vehicleDetails[1]);
                String make = vehicleDetails[2];
                String model = vehicleDetails[3];
                String vehicleType = vehicleDetails[4];
                String color = vehicleDetails[5];
                int odometer = Integer.parseInt(vehicleDetails[6]);
                double price = Double.parseDouble(vehicleDetails[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealerShip.addVehicle(vehicle);
            }

            bufferedReader.close();
            return dealerShip;
        } catch (IOException e) {
            return null;
        }
    }

    public void saveDealership(DealerShip dealership) {
        try (FileWriter fileWriter = new FileWriter(FILENAME)) {
            fileWriter.write(String.format(dealership.getName(), dealership.getAddress(), dealership.getPhone()));


            for (Vehicle vehicle : dealership.getAllVehicles()) {
                String e =
                String.format("\n%d|%d|%s|%s|%s|%s|%d|%.2f",

                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        vehicle.getPrice());
                fileWriter.write(e);
            }
            System.out.println("Dealership data saved.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}