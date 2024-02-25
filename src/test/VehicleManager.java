package test;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import test.Vehicle.FuelType;
import test.Vehicle.StartMechanism;
import test.Vehicle.VehicleColor;
import java.util.Optional;

public class VehicleManager {
	List<Vehicle> vehicleList = new ArrayList<Vehicle>();
	private String vehicleFilePath;
	private final static double distance = 300;
	private final static double fuelPrice = 3.25;
	public int fcost = -1;
	public int hcost = 1000000000;
	public int fMPG = -1;
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
	int numVehicles = 0;
	for(int i = 0; i < vehicleList.size(); i++) {
		if(vehicleList.get(i) instanceof CarVehicle) {
			numVehicles+=1;
			System.out.print(vehicleList.get(i).calculateMaintenaceCost(distance) + ", ");
			System.out.print(vehicleList.get(i).calculateFuelEfficiency(distance, fuelPrice) + ", ");
			System.out.println(vehicleList.get(i).getStartType());
		}
	}
	if (numVehicles == 0) {
		System.out.print("No cars found");
	}
}

public void displayAllTruckInformation() {
	int numVehicles = 0;
	for(int i =0; i < vehicleList.size(); i++) {
		if(vehicleList.get(i) instanceof TruckVehicle) {
			numVehicles+=1;
			System.out.print(vehicleList.get(i).calculateMaintenaceCost(distance)+ ",");
			System.out.print(vehicleList.get(i).calculateFuelEfficiency(distance, fuelPrice) + ", ");
			System.out.println(vehicleList.get(i).getStartType());
		}
	}
	if (numVehicles == 0) {
		System.out.print("No trucks found");
	}
	
}

public void displayAllSUVInformation() {
	int numVehicles = 0;
	for(int i =0; i < vehicleList.size(); i++) {
		if(vehicleList.get(i) instanceof SUVVehicle) {
			numVehicles+=1;
			System.out.print(vehicleList.get(i).calculateMaintenaceCost(distance)+ ",");
			System.out.print(vehicleList.get(i).calculateFuelEfficiency(distance, fuelPrice) + ", ");
			System.out.println(vehicleList.get(i).getStartType());
		}
	}
	if (numVehicles == 0) {
		System.out.print("No SUVs found");
	}
}
public void displayAllMotorBikeInformation() {
	int numVehicles = 0;
	for(int i =0; i < vehicleList.size(); i++) {
		if(vehicleList.get(i) instanceof MotorBikeVehicle) {
			numVehicles+=1;
			System.out.print(vehicleList.get(i).calculateMaintenaceCost(distance)+ ",");
			System.out.print(vehicleList.get(i).calculateFuelEfficiency(distance, fuelPrice) + ", ");
			System.out.println(vehicleList.get(i).getStartType());
		}
	}
	if (numVehicles == 0) {
		System.out.println("No motor bikes found");
	}
	
}

public void displayVehicleInformation(Vehicle v) {
	 System.out.print(v.calculateMaintenaceCost(distance) + ",");
	 System.out.print(v.calculateFuelEfficiency(distance, fuelPrice) + ", ");
	 System.out.println(v.getStartType());
}
public void displayAllVehicleInformation() {
    if(vehicleList.isEmpty()) {
        System.out.println("No vehicles found");
        return;
    }
    for (int i = 0; i < vehicleList.size(); i++) {
        Vehicle vehicle = vehicleList.get(i);
        System.out.print(vehicle.calculateMaintenaceCost(distance) + ",");
        System.out.print(vehicle.calculateFuelEfficiency(distance, fuelPrice) + ", ");
        System.out.println(vehicle.getStartType());
    }
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

public boolean saveVehicleList() {
	try (FileWriter writer = new FileWriter(vehicleFilePath)){
		String headerLine = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", "Type","Model","Make","ModelYear","Price","Color","FuelType","Mileage","Mass","Cylinders","GasTankCapacity","StartType");
		writer.write(headerLine);
		for (Vehicle vehicle : vehicleList) {
			String vehicleType ="Error";
			if (isVehicleType(vehicle,SUVVehicle.class)) {
				vehicleType = "SUV";
			} else if (isVehicleType(vehicle,CarVehicle.class)) {
				vehicleType = "Car";
			} else if (isVehicleType(vehicle,TruckVehicle.class)) {
				vehicleType = "Truck";
			} else if (isVehicleType(vehicle,MotorBikeVehicle.class)) {
				vehicleType = "MotorBike";
			}
			String csvLine = String.format("%s,%s,%s,%d,%.2f,%s,%s,%.2f,%.2f,%d,%.2f,%s\n",
			vehicleType,
			vehicle.getBrand(),
			vehicle.getMake(),
			vehicle.getModelYear(),
			vehicle.getPrice(),
			vehicle.getColor(),
			vehicle.getFuelType(),
			vehicle.getMileage(),
			vehicle.getMass(),
			vehicle.getCylinders(),
			vehicle.getGasTankCapacity(),
			vehicle.getStartType());
	writer.write(csvLine);
}
return true;
} catch (IOException e) {
return false; 
}
}

private boolean isVehicleType(Vehicle v, Class<?> clazz) {
	return v.getClass().equals(clazz);
}
public int getNumberOfVehiclesByType(Class<?> clazz) {
	int total = 0;
	for (Vehicle v : vehicleList) {
		if(isVehicleType(v, clazz)) {
			total++;
		}
	} return total;
}

public Optional<Vehicle> getVehicleWithHighestMaintenanceCost(double distance, double fuelPrice) {
	for (Vehicle v : vehicleList) {
        double findhicost = v.calculateMaintenaceCost(distance);
		if (fcost > findhicost) {
			findhicost = fcost;
		}  
        
		}
		for (Vehicle v : vehicleList) {
            double findhicost = v.calculateMaintenaceCost(distance);
            if (fcost == findhicost) {
                System.out.println("This Vehicle has high cost of: " + v);
				return Optional.of(v);
	}
}
		return Optional.empty();
		
		
}

public Optional<Vehicle> getVehicleWithLowestMaintenanceCost(double distance, double fuelPrice) {
	for (Vehicle v : vehicleList) {
        double findlowcost = v.calculateMaintenaceCost(distance);
		if (hcost < findlowcost) {
			findlowcost = hcost;
		}  
        
		}
		for (Vehicle v : vehicleList) {
            double findlowcost = v.calculateMaintenaceCost(distance);
            if (fcost == findlowcost) {
                System.out.println("This Vehicle has a low cost of: " + v);
				return Optional.of(v);
	}
}
		return Optional.empty();
}

public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice) {
	ArrayList<Vehicle> highestMPGList = new ArrayList<Vehicle>();
	for (Vehicle v : vehicleList) {
		double hMPG = 0.0;
		double currentMPG = v.calculateFuelEfficiency(distance, fuelPrice);
		if (currentMPG > hMPG) {
			hMPG = currentMPG;
			if (highestMPGList.isEmpty() || highestMPGList.get(0).calculateFuelEfficiency(distance, fuelPrice) == currentMPG){
				highestMPGList.add(v);
			} else {
				highestMPGList.remove(0);
				highestMPGList.add(v);
			}
		}
	}
	return highestMPGList;
}

public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice) {
	ArrayList<Vehicle> lowestMPGList = new ArrayList<Vehicle>();
	for (Vehicle v : vehicleList) {
		double lMPG = 1000000;
		double currentMPG = v.calculateFuelEfficiency(distance, fuelPrice);
		if (currentMPG < lMPG) {
			lMPG = currentMPG;
			if (lowestMPGList.isEmpty()){
				lowestMPGList.add(v);
			} else if (lowestMPGList.get(0).calculateFuelEfficiency(distance, fuelPrice) == currentMPG) {
				lowestMPGList.add(v);
			} else {
				lowestMPGList.remove(0);
				lowestMPGList.add(v);
			}
		}
	}
	return lowestMPGList;
}

public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
	int numSUV = 0;
	double totalFuel = 0;
	for (Vehicle v : vehicleList) {
		if (isVehicleType(v,SUVVehicle.class)) {
			double mpg = v.calculateFuelEfficiency(distance, fuelPrice);
			numSUV+=1;
			totalFuel+=mpg;
		}
	}
	if (numSUV == 0) {
		return(-1.0);
	} else {
		return(totalFuel/numSUV);
	}
}

}

