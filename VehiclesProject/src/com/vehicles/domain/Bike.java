package com.vehicles.domain;

import java.util.List;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
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
