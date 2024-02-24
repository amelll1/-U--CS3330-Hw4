package test;

public class Main {

	public static void main(String[] args) {
		// Instantiate vehicleManager, perform operations based on the requirements.
		VehicleManager vehicleManager = new VehicleManager("files/vehicleList.csv");
		// Read vehicle data from the vehcileList.csv file and initialize objects.
		vehicleManager.intializeStock();
		// Display all vehicle information.
		//vehicleManager.displayAllVehicleInformation();
		// Display all car information.
		vehicleManager.displayAllCarInformation();
		// Display all motorbike information.
		vehicleManager.displayAllMotorBikeInformation();
	}

}
