package com.vehicles.application;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.domain.Bike;
import com.vehicles.domain.Car;
import com.vehicles.domain.Wheel;
import com.vehicles.utilities.Inputs;


public final class VehiclesFactory {
	
	/**
	 * Constructor method of a car object
	 * @return Car Class Object
	 * @throws Exception: this method requires a plate, brand, 
	 * color and two lists of two wheels (object of the wheel class) each
	 */
	static protected Car createNewCar(String plate, String brand, String color) throws Exception {
		Car car = new Car(plate, brand, color);
		List<Wheel> davantera = wheelsFactory("davantera");
		if (!davantera.isEmpty()) {
			List<Wheel> darrere = wheelsFactory("darrere");
			if (!darrere.isEmpty()) {
				car.addWheels(davantera, darrere);
			}
		}
		return car;
	}
	
	/**
	 * Constructor method of a bike object
	 * @return Bike Class Object
	 * @throws Exception: this method requires a plate, brand, 
	 * color and one lists of two wheels (object of the wheel class)
	 */
	static protected Bike createNewBike(String plate, String brand, String color) throws Exception {
		Bike bike = new Bike(plate, brand, color);
		List<Wheel> davanteraIdarrere = wheelsFactory("davantera i darrere");
		if (!davanteraIdarrere.isEmpty()) {
			bike.addWheels(davanteraIdarrere);			
		}
		return bike;
	}
	
	/**
	 * Constructor method of a wheel object
	 * @param FrontOrBack: inform whether the rear or 
	 * front wheels are built in the case of cars or 
	 * whether they are both in the case of a motorcycle
	 * @return Wheel object
	 */
	private static List<Wheel> wheelsFactory(String FrontOrBack) {
		
		List<Wheel> listOfTwoSameWheels = new ArrayList<Wheel>();
		
		String brand = Inputs.returnString("Quina marca de rodes "+ FrontOrBack + "?");
		if (brand!="NulL") {
			double diameter = Inputs.returnDiameter("Quin és el diàmetre de la roda "+ FrontOrBack + "?");
			if (diameter!=-1.0) {
				Wheel wheel = new Wheel(brand, diameter);
				listOfTwoSameWheels.add(wheel);
				listOfTwoSameWheels.add(wheel);
			}
		}

		return listOfTwoSameWheels;
	}

}
