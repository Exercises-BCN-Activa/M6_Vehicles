package com.vehicles.domain;

public class Wheel {
	
	/**
	 * assistant class in the construction of vehicles 
	 * that has as attributes a brand string and a double diameter
	 */
	private String brand;
	private double diameter;

	/**
	 * basic constructor with 2 variables
	 * @param brand string consisting of 1 or 2 words
	 * @param diameter double between 0.4 and 4.0
	 */
	public Wheel(String brand, double diameter) {
		this.brand = brand;
		this.diameter = diameter;
	}

	/**
	 * overlay of the toString method to improve visualization
	 */
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
