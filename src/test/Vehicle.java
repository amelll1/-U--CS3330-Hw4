package test;

public class Vehicle {
    private String brand;
    private String make;
    private long modelYear;
    private Double price;
    private VehicleColor color;
    private FuelType fuelType;
    private double mileage;
    private double mass;
    private int cylinders;
    private double gasTankCapacity;
    private StartMechanism startType;

    public enum VehicleColor {
        BLACK, RED, BLUE, BROWN, WHITE, YELLOW, GRAY
    }
    public enum StartMechanism {
        KEYSTART, PUSHSTART, KICKSTART
    }
    public enum FuelType {
        GASOLINE, DIESEL, ELECTRIC, HYBRID
    }

    public Vehicle(String brand, String make, long modelYear, Double price, VehicleColor color,
            FuelType fuelType, double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
                this.brand = brand;
                this.make = make;
                this.modelYear = modelYear;
                this.price = price;
                this.color = color;
                this.fuelType = fuelType;
                this.mileage = mileage;
                this.mass = mass;
                this.cylinders = cylinders;
                this.gasTankCapacity = gasTankCapacity;
                this.startType = startType;
            }
    public Vehicle(Vehicle otherVehicle) {
    	this.brand = otherVehicle.getBrand();
        this.make = otherVehicle.getMake();
        this.modelYear = otherVehicle.getModelYear();
        this.price = otherVehicle.getPrice();
        this.color = otherVehicle.getColor();
        this.fuelType = otherVehicle.getFuelType();
        this.mileage = otherVehicle.getMileage();
        this.mass = otherVehicle.getMass();
        this.cylinders = otherVehicle.getCylinders();
        this.gasTankCapacity = otherVehicle.getGasTankCapacity();
        this.startType = otherVehicle.getStartType();
    }
    // Getters
    public String getBrand() {
        return brand;
    }

    public String getMake() {
        return make;
    }

    public long getModelYear() {
        return modelYear;
    }

    public Double getPrice() {
        return price;
    }

    public VehicleColor getColor() {
        return color;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public double getMileage() {
        return mileage;
    }

    public double getMass() {
        return mass;
    }

    public int getCylinders() {
        return cylinders;
    }

    public double getGasTankCapacity() {
        return gasTankCapacity;
    }

    public StartMechanism getStartType() {
        return startType;
    }

    // Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModelYear(long modelYear) {
        this.modelYear = modelYear;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setColor(VehicleColor color) {
        this.color = color;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public void setGasTankCapacity(double gasTankCapacity) {
        this.gasTankCapacity = gasTankCapacity;
    }

    public void setStartType(StartMechanism startType) {
        this.startType = startType;
    }
}
