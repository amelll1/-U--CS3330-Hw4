package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import test.Vehicle.FuelType;
import test.Vehicle.StartMechanism;
import test.Vehicle.VehicleColor;

public class VehicleManager {
	List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private String vehicleFilePath;
	public VehicleManager(String filePath) {
		vehicleFilePath = filePath;
	}
	
	public boolean intializeStock() {
		FileInputStream vehicleManagerData;
		try {
			vehicleManagerData = new FileInputStream(vehicleFilePath);
			Scanner sc = new Scanner(vehicleManagerData);
			sc.nextLine();
			while (sc.hasNext()) {
				String csvLine = sc.nextLine();
				String[] arrData = csvLine.split(",");
//				for (String a : arrData) {
//					System.out.println(" - "+ a);
//				}
//				System.out.println("SPACE");
				String type = arrData[0];
				String model = arrData[1];
				String make = arrData[2];
				long modelyear = Long.valueOf(arrData[3]);
				double price = Double.valueOf(arrData[4]);
				VehicleColor color = VehicleColor.valueOf(arrData[5]);
				FuelType fueltype = FuelType.valueOf(arrData[6]);
				double mileage = Double.valueOf(arrData[7]);
				double mass = Double.valueOf(arrData[8]);
				int cylinders = Integer.valueOf(arrData[9]);
				double gastankcap = Double.valueOf(arrData[10]);
				StartMechanism starttype = StartMechanism.valueOf(arrData[11]);
				if (type.equals("Truck")) {
					TruckVehicle typeVehicle = new TruckVehicle(model,make,modelyear,price,color,fueltype,mileage,mass,cylinders,gastankcap,starttype);
					vehicles.add(typeVehicle);
				} else if (type.equals("Car")) {
					CarVehicle typeVehicle = new CarVehicle(model,make,modelyear,price,color,fueltype,mileage,mass,cylinders,gastankcap,starttype);
					vehicles.add(typeVehicle);
				} else if (type.equals("SUV")) {
					SUVVehicle typeVehicle = new SUVVehicle(model,make,modelyear,price,color,fueltype,mileage,mass,cylinders,gastankcap,starttype);
					vehicles.add(typeVehicle);
				} else if (type.equals("MotorBike")) {
					MotorBikeVehicle typeVehicle = new MotorBikeVehicle(model,make,modelyear,price,color,fueltype,mileage,mass,cylinders,gastankcap,starttype);
					vehicles.add(typeVehicle);
				} else {
					Vehicle vehicle = new Vehicle(model,make,modelyear,price,color,fueltype,mileage,mass,cylinders,gastankcap,starttype);
					vehicles.add(vehicle);
				}
			}
			vehicleManagerData.close();
			sc.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}

//public void displayAllCarInformation() {
//	
//}
//
//public void displayAllTruckInformation() {
//	
//}
//
//public void displayAllSUVInformation() {
//	
//}
//
//public void displayAllMotorBikeInformation() {
//	
//}
//
//public void displayVehicleInformation(Vehicle v) {
//	
//}
//
//public boolean removeVehicle(Vehicle vehicle) {
//	
//}
//
//public boolean addVehicle(Vehicle vehicle) {
//	
//}
//
//public boolean saveVehicleList() {
//	
//}
//
//private boolean isVehicleType(Vehicle v, Class clazz) {
//	
//}
//
//public int getNumberOfVehiclesByType(Class clazz) {
//	
//}
//
//public Vehicle getVehicleWithHighestMaintenanceCost(double distance, double fuelPrice) {
//	
//}
//
//public Vehicle getVehicleWithLowestMaintenanceCost(double distance, double fuelPrice) {
//	
//}




