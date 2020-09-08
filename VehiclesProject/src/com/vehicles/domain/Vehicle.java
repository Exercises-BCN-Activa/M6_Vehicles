package com.vehicles.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {

	/**
	 * The vehicle abstract class is the basis for the construction 
	 * of objects in this program, consisting of the string variables 
	 * (plate, brand color) and a list variable of wheels objects.
	 */
	protected String plate;
	protected String brand;
	protected String color;
	protected List<Wheel> wheels = new ArrayList<Wheel>();

	/**
	 * basic constructor with 3 strings
	 * @param plate consisting of 4 numbers, 2 or 3 letters
	 * @param brand consisting of 1 or 2 words
	 * @param color consisting of 1 or 2 words
	 */
	public Vehicle(String plate, String brand, String color) {
		this.plate = plate;
		this.brand = brand;
		this.color = color;
	}

	/**
	 * Get basic attribute
	 * @return string with 6 or 7 characters composed of 4 numbers and 2 or 3 letters
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * Get basic attribute
	 * @return string with 1 or 2 words 
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Get basic attribute
	 * @return string with 1 or 2 words 
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Get basic attribute
	 * @return 4 positions list made up of wheel objects.
	 * {0: front left wheel. 1: right front wheel. 
	 * 2: left rear wheel. 3: right rear wheel} 
	 */
	public List<Wheel> getWheels() {
		return wheels;
	}
}
