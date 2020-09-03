package com.vehicles.domain;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Wheel (");
		builder.append("brand: ");
		builder.append(brand);
		builder.append(", diameter: ");
		builder.append(diameter);
		builder.append(")");
		return builder.toString();
	}
}
