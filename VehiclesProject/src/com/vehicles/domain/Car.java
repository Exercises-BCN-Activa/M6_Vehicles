package com.vehicles.domain;

import java.util.List;

public class Car extends Vehicle {

	/**
	 * basic constructor with 3 strings that invokes the constructor of the vehicle superclass
	 * @param plate consisting of 4 numbers, 2 or 3 letters
	 * @param brand brand consisting of 1 or 2 words
	 * @param color consisting of 1 or 2 words 
	 */
	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}

	/**
	 * Method that requires two lists to be able to add wheels to the car object, 
	 * then invokes an auxiliary method to validate the data and later 
	 * add the wheels objects to the wheel list attribute
	 * @param frontWheels list composed of two identical wheel objects
	 * @param backWheels list composed of two identical wheel objects
	 * @throws Exception in each list of wheels the objects must be identical if no exception is thrown.
	 */
	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws Exception {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	/**
	 * Private method and assist in adding wheels to the car. 
	 * first check if the list has two objects, then add these objects 
	 * to the left and right wheel variables, then evaluate whether 
	 * both are identical, then aggregate them as attribute values
	 * @param wheels list composed of two identical wheel objects
	 * @throws Exception list of wheels the objects must be identical if no exception is thrown.
	 */
	private void addTwoWheels(List<Wheel> wheels) throws Exception {
		if (wheels.size() != 2)
			throw new Exception();

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (!rightWheel.equals(leftWheel))
			throw new Exception();

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
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
				builder.append("COTXE:\n");
				builder.append("Matrícula: ");
				builder.append(plate);
				builder.append(",\nMarca: ");
				builder.append(brand);
				builder.append(",\nColor: ");
				builder.append(color);
				if (!this.wheels.isEmpty()) {
					builder.append(",\nRodes Davanteres ");
					builder.append(wheels.get(1).toString("CAT"));
					builder.append(",\nRodes Posteriors ");
					builder.append(wheels.get(3).toString("CAT"));
				}
				break;
				
			default:
				builder.append("CAR:\n");
				builder.append("Plate: ");
				builder.append(plate);
				builder.append(",\nBrand: ");
				builder.append(brand);
				builder.append(",\nColor: ");
				builder.append(color);
				if (!this.wheels.isEmpty()) {
					builder.append(",\nFront Wheels ");
					builder.append(wheels.get(1).toString("DEFAULT"));
					builder.append(",\nBack Wheels ");
					builder.append(wheels.get(3).toString("DEFAULT"));
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
		return "Car [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels + "]";
	}
	

}
