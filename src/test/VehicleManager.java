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
	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
	private String vehicleFilePath;
	private final static double distance = 300;
	private final static double fuelPrice = 3.25;
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
				StartMechanism startType = StartMechanism.valueOf(arrData[11]);
				if (type.equals("Truck")) {
					TruckVehicle typeVehicle = new TruckVehicle(model,make,modelyear,price,color,fueltype,mileage,mass,cylinders,gastankcap,startType);
					vehicleList.add(typeVehicle);
				} else if (type.equals("Car")) {
					CarVehicle typeVehicle = new CarVehicle(model,make,modelyear,price,color,fueltype,mileage,mass,cylinders,gastankcap,startType);
					vehicleList.add(typeVehicle);
				} else if (type.equals("SUV")) {
					SUVVehicle typeVehicle = new SUVVehicle(model,make,modelyear,price,color,fueltype,mileage,mass,cylinders,gastankcap,startType);
					vehicleList.add(typeVehicle);
				} else if (type.equals("MotorBike")) {
					MotorBikeVehicle typeVehicle = new MotorBikeVehicle(model,make,modelyear,price,color,fueltype,mileage,mass,cylinders,gastankcap,startType);
					vehicleList.add(typeVehicle);
				}
				// } else {
				// 	Vehicle vehicle = new Vehicle(model,make,modelyear,price,color,fueltype,mileage,mass,cylinders,gastankcap,startType);
				// 	vehicleList.add(vehicle);
				// }
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


public void displayAllCarInformation() {
	for(int i = 0; i < vehicleList.size(); i++) {
		if(vehicleList.get(i) instanceof CarVehicle) {
			System.out.print(vehicleList.get(i).calculateMaintenaceCost(distance) + ", ");
			System.out.print(vehicleList.get(i).calculateFuelEfficiency(distance, fuelPrice) + ", ");
			System.out.println(vehicleList.get(i).getStartType());
			break;
		}
	}
	System.out.print("No cars found");
}

public void displayAllTruckInformation() {
	for(int i =0; i < vehicleList.size(); i++) {
		if(vehicleList.get(i) instanceof TruckVehicle) {
			System.out.print(vehicleList.get(i).calculateMaintenaceCost(distance)+ ",");
			System.out.print(vehicleList.get(i).calculateFuelEfficiency(distance, fuelPrice) + ", ");
			System.out.println(vehicleList.get(i).getStartType());
			break;
		}
	}
	System.out.print("No trucks found");
	
}

public void displayAllSUVInformation() {
	for(int i =0; i < vehicleList.size(); i++) {
		if(vehicleList.get(i) instanceof SUVVehicle) {
			System.out.print(vehicleList.get(i).calculateMaintenaceCost(distance)+ ",");
			System.out.print(vehicleList.get(i).calculateFuelEfficiency(distance, fuelPrice) + ", ");
			System.out.println(vehicleList.get(i).getStartType());
			break;
		}
	}
	System.out.print("No SUVs found");
}
public void displayAllMotorBikeInformation() {
	for(int i =0; i < vehicleList.size(); i++) {
		if(vehicleList.get(i) instanceof MotorBikeVehicle) {
			System.out.print(vehicleList.get(i).calculateMaintenaceCost(distance)+ ",");
			System.out.print(vehicleList.get(i).calculateFuelEfficiency(distance, fuelPrice) + ", ");
			System.out.println(vehicleList.get(i).getStartType());
			break;
		}
	}
	System.out.print("No motor bikes found");
	
}

public void displayVehicleInformation(Vehicle v) {
	 System.out.print(v.calculateMaintenaceCost(distance) + ",");
	 System.out.print(v.calculateFuelEfficiency(distance, fuelPrice) + ", ");
	 System.out.println(v.getStartType());
}

public boolean removeVehicle(Vehicle vehicle) {
	if(vehicleList.contains(vehicle)) {
		vehicleList.remove(vehicle);
		if(vehicleList.contains(vehicle)) {
			return false;
		} else {
			return true;
		}
	}
	return false;
}

public boolean addVehicle(Vehicle vehicle) {
	vehicleList.add(vehicle);
	if (vehicleList.contains(vehicle)) {
		return true;
	} else {
		return false;
	}
}
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


}

