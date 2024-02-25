package test;

public class MotorBikeVehicle extends Vehicle{
	
	public MotorBikeVehicle(String brand, String make, long modelYear, Double price, VehicleColor color,
            FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super(brand,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startType);
	}

	@Override
	public double calculateMaintenaceCost(double distance) {
		return (distance * getMass() * (2023 - getModelYear()) * getCylinders() * 0.0002); }

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'calculateFuelEfficiency'");
	}
}
