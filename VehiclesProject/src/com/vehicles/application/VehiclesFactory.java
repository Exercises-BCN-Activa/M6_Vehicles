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
	static protected Car createNewCar() throws Exception {
		String plate = Inputs.returnPlate("Quina és la matrícula del teu cotxe?");
		String brand = Inputs.returnString("Quina és la marca del teu cotxe?");
		String color = Inputs.returnString("Quin és el color del teu cotxe?");
		Car car = new Car(plate, brand, color);
		car.addWheels(wheelsFactory("davantera"), wheelsFactory("darrere"));
		return car;
	}
	
	/**
	 * Constructor method of a bike object
	 * @return Bike Class Object
	 * @throws Exception: this method requires a plate, brand, 
	 * color and one lists of two wheels (object of the wheel class)
	 */
	static protected Bike createNewBike() throws Exception {
		String plate = Inputs.returnPlate("Quina és la matrícula de la teva moto?");
		String brand = Inputs.returnString("Quina és la marca la teva moto?");
		String color = Inputs.returnString("Quin és el color la teva moto?");
		Bike bike = new Bike(plate, brand, color);
		bike.addWheels(wheelsFactory("davantera i darrere"));
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
		
		String brand = Inputs.returnString("Quina marca de rodes "+ FrontOrBack + "?");
		double diameter = Inputs.returnDiameter("Quin és el diàmetre de la roda "+ FrontOrBack + "?");
		
		Wheel wheel = new Wheel(brand, diameter);
		
		List<Wheel> listOfTwoSameWheels = new ArrayList<Wheel>();
		
		listOfTwoSameWheels.add(wheel);
		listOfTwoSameWheels.add(wheel);
		
		return listOfTwoSameWheels;
	}

}
