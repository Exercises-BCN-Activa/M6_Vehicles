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
	 * toString method to improve visualization
	 * @param language: CAT=Catalan, DEFAULT=English
	 * @return object car in string.
	 */
	public String toString(String language) {
		StringBuilder builder = new StringBuilder();
		
		switch (language.toUpperCase()) {
			case "CAT":
				builder.append("MOTO:\n");
				builder.append("Matrícula: ");
				builder.append(plate);
				builder.append(",\nMarca: ");
				builder.append(brand);
				builder.append(",\nColor: ");
				builder.append(color);
				if (!this.wheels.isEmpty()) {
					builder.append(",\nRoda Davantera ");
					builder.append(wheels.get(0).toString("CAT"));
					builder.append(",\nRoda del Darrere ");
					builder.append(wheels.get(1).toString("CAT"));
				}
				break;
				
			default:
				builder.append("MOTO:\n");
				builder.append("Plate: ");
				builder.append(plate);
				builder.append(",\nBrand: ");
				builder.append(brand);
				builder.append(",\nColor: ");
				builder.append(color);
				if (!this.wheels.isEmpty()) {
					builder.append(",\nFront Wheel ");
					builder.append(wheels.get(0).toString("DEFAULT"));
					builder.append(",\nBack Wheel ");
					builder.append(wheels.get(1).toString("DEFAULT"));
				}
				break;
		}
		
		return builder.toString();
	}

	/**
	 * Overlay of the toString method to improve visualization
	 */
	@Override
	public String toString() {
		return "Bike [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels + "]";
	}
	
	

}
