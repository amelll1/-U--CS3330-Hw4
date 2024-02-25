package test;


public class SUVVehicle extends Vehicle {
	public SUVVehicle(String brand, String make, long modelYear, Double price, VehicleColor color,
            FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startType);
	}

	@Override
	public double calculateMaintenaceCost(double distance) {
		return(distance * getMass() * (2023-getModelYear()) * getCylinders() * 0.001);
	}
	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		return (getCylinders() * getGasTankCapacity() * (fuelPrice / distance) * 0.05);
	}
}
