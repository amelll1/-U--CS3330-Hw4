# U-Homework4


Contributions:
 - Van Grabner:
 - Mel Nezirovic:initial commit, set up the files, completed the display methods(displayAllTruckInformation,displayAllSUVInformation, displayAllMotorBikeInformation, displayVehicleInformation,displayAllVehicleInformation)
 - Temitope Alabi:
 - Micheal Whaley: Initial setup subclasses for Vehicle, intializeStock method, addVehicle method, removeVehicle method

Instructions: 
Using the different methods we have you will first need to create a Vehicle manager inputting the vehicleList.csv file path as a parameter. This creates the vehicleManager and saves the file path to a string variable. Next you will want to call the method initalizeStock() on that vehicle manager. This will take the data from the file and sort the vehicles into a list with their individual data creating Vehicle subclasses for each line in the csv file based on the vehicle's type. This also assigns each data point (i.e. mileage) of the vehicle to it's coinciding variable in the Vehicle class. It will not add a vehicle if there is no vehicle type or if the vehicle does not exist. You can also print out vehicle information in the list by subclass like displayAllCarInformation() and for all of the vehicles as well using displayAllVehicleInformation(). If there are no vehicles of that type found it will print a message saying there were no vehicles found. You can also print out information for a specific vehicle using displayVehicleInformation() which needs a Vehicle object to be passed through. It will check if the vehicle is in the list first and then print out the information. You can use the addVehicle() and removeVehicle() methods as well. addVehicle() wil add a vehicle passed in as a parameter to the list. After adding the vehicle it checks if the vehicle exists in the list. If it does exist in the vehicle list it returns true if not then false. The removeVehicle() method first checks if the vehicle is in the list and then removes it if it exists. It checks after if the vehicle is still in the list. If the vehicle was successfully removed it returns true and if not it returns false. 
