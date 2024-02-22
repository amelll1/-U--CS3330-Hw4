package test;

import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
	List<Vehicle> vehicles = new ArrayList<Vehicle>();
	private String vehicleFilePath;
	public VehicleManager(String filePath) {
		vehicleFilePath = filePath;
	}
}
