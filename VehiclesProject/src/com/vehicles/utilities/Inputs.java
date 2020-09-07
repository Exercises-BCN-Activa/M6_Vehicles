package com.vehicles.utilities;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.vehicles.domain.Wheel;

public class Inputs {
	
	public static String returnString(String msg) {
		String userInput;
		
		do {
			userInput = JOptionPane.showInputDialog(msg);
		} while (!userInput.matches("\\w+"));
		
		userInput = toTitleCase(userInput);
		
		return userInput; 
	}
	
	public static String returnPlate(String msg) {
		String userPlate = JOptionPane.showInputDialog(msg);
		
		while (!userPlate.matches("^\\d{4}\\s?\\w{2,3}|\\w{2,3}\\s?\\d{4}$")) {
			JOptionPane.showMessageDialog(null, "ERROR! La matrícula ha de contenir 4 números i 2 o 3 lletres.");
			userPlate = JOptionPane.showInputDialog(msg);
		}
		
		userPlate = userPlate.toUpperCase().replaceAll("\\s", "");
		
		return userPlate; 
	}
	
	public static Double returnDiameter(String msg) {
		String userDiameter = JOptionPane.showInputDialog(msg).replace(',', '.');
		
		while (!userDiameter.matches("^[0]*\\.+[4-9]+|[1-3]\\.*\\d*|[4]\\.*[0]*$")) {
			JOptionPane.showMessageDialog(null, "ERROR! El diàmetre ha d'estar entre 0,4 i 4,0.");
			userDiameter = JOptionPane.showInputDialog(msg).replace(',', '.');
		}
		
		Double convertedDiameter = Double.parseDouble(userDiameter);
		
		return convertedDiameter; 
	}
	
	public static List<Wheel> WheelsFactory(String FrontOrBack) {
		
		String brand = returnString("Quina marca de rodes "+ FrontOrBack + "?");
		double diameter = returnDiameter("Quin és el diàmetre de la roda "+ FrontOrBack + "?");
		
		Wheel frontWheel = new Wheel(brand, diameter);
		
		List<Wheel> listOfTwoSameWheels = new ArrayList<Wheel>();
		
		listOfTwoSameWheels.add(frontWheel);
		listOfTwoSameWheels.add(frontWheel);
		
		return listOfTwoSameWheels;
	}
	
	public static String toTitleCase(String input) {
	    StringBuilder titleCase = new StringBuilder(input.length());
	    boolean nextTitleCase = true;

	    for (char c : input.toCharArray()) {
	        if (Character.isSpaceChar(c)) {
	            nextTitleCase = true;
	        } else if (nextTitleCase) {
	            c = Character.toTitleCase(c);
	            nextTitleCase = false;
	        } else {
	        	c = Character.toLowerCase(c);
	        }

	        titleCase.append(c);
	    }

	    return titleCase.toString();
	}

}
