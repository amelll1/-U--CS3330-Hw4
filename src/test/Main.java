package test;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Instantiate vehicleManager, perform operations based on the requirements.
		VehicleManager vehicleManager = new VehicleManager("files/vehicleList.csv");
		// Read vehicle data from the vehcileList.csv file and initialize objects.
		vehicleManager.intializeStock();
		// Display all vehicle information.
		//vehicleManager.displayAllVehicleInformation();
		// Display all car information.
		System.out.println("All car information: ");
		vehicleManager.displayAllCarInformation();
		// Display all motorbike information.
		System.out.println("All motor bike information: ");
		vehicleManager.displayAllMotorBikeInformation();
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		vehicleList = vehicleManager.getVehicleWithHighestFuelEfficiency(100, 1);
		System.out.println("highest mpg: " + vehicleList.toString());
		double avgSUV = vehicleManager.getAverageFuelEfficiencyOfSUVs(100, 1);
		System.out.println("Average mpg of SUVs: "+avgSUV);
		
	}

}