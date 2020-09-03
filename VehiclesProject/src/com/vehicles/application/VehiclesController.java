package com.vehicles.application;

import java.util.Iterator;
import com.vehicles.utilities.Inputs;
import com.vehicles.persistence.VehiclesRepository;
import com.vehicles.domain.Car;
import com.vehicles.domain.Vehicle;

public class VehiclesController {
	
	private VehiclesRepository repository = new VehiclesRepository();
	
	public VehiclesController() {}
	
	public void createNewCar() throws Exception {
		String plate = Inputs.returnString("Quina és la matrícula del teu cotxe?");
		String brand = Inputs.returnString("Quina és la marca del teu cotxe?");
		String color = Inputs.returnString("Quin és el color del teu cotxe?");
		Car car = new Car(plate, brand, color);
		car.addWheels(Inputs.WheelsFactory("davantera"), Inputs.WheelsFactory("darrere"));
		repository.addVehicle(car);
	}
	
	public void showDetailsVehicles() {
		Iterator<Vehicle> it = repository.getAllVehicles().iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

}
