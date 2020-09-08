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
	 * toString method to improve visualization
	 * @param language: CAT=Catalan, DEFAULT=English
	 * @return object car in string.
	 */
	public String toString(String language) {
		StringBuilder builder = new StringBuilder();
		
		switch (language.toUpperCase()) {
			case "CAT":
				builder.append("(Marca: ");
				builder.append(brand);
				builder.append(", Diàmetre: ");
				builder.append(diameter);
				builder.append(")");
				break;
				
			default:
				builder.append("(Brand: ");
				builder.append(brand);
				builder.append(", Diameter: ");
				builder.append(diameter);
				builder.append(")");
				break;
		}
		
		return builder.toString();
	}

	/**
	 * Overlay of the toString method to improve visualization
	 */
	@Override
	public String toString() {
		return "Wheel [brand=" + brand + ", diameter=" + diameter + "]";
	}

	
}
