package com.vehicles.domain;

import java.util.List;

public class Bike extends Vehicle {

	/**
	 * * basic constructor with 3 strings that invokes the constructor of the vehicle superclass
	 * @param plate consisting of 4 numbers, 2 or 3 letters
	 * @param brand brand consisting of 1 or 2 words
	 * @param color consisting of 1 or 2 words
	 */
	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	/**
	 * Public Method of adding wheels to a motorcycle.  
	 * First check if the list has two objects, then add these objects 
	 * to the left and right wheel variables, then evaluate whether 
	 * both are identical, then aggregate them as attribute values
	 * @param wheels list composed of two identical wheel objects
	 * @throws Exception list of wheels the objects must be identical if no exception is thrown.
	 */
	public void addWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel frontWheel = wheels.get(0);
		Wheel backWheel = wheels.get(1);

		if (!frontWheel.equals(backWheel))
			throw new Exception();

		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}
	
	/**
	 * overlay of the toString method to improve visualization
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BIKE [");
		builder.append("Plate: ");
		builder.append(plate);
		builder.append(", Brand: ");
		builder.append(brand);
		builder.append(", Color: ");
		builder.append(color);
		if (!this.wheels.isEmpty()) {
			builder.append(",\n      Front ");
			builder.append(wheels.get(0));
			builder.append(",\n      Back ");
			builder.append(wheels.get(1));
		}
		builder.append("]");
		return builder.toString();
	}

}
