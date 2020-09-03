package com.vehicles.utilities;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.vehicles.domain.Wheel;

public class Inputs {
	
	public static String returnString(String msg) {
		String userInput = JOptionPane.showInputDialog(msg);
		return userInput; 
	}
	
	public static List<Wheel> WheelsFactory(String FrontOrBack) {
		
		String brand = returnString("Quina marca de rodes "+ FrontOrBack + "?");
		double diameter = Double.parseDouble(returnString("Quin és el diàmetre de la roda "+ FrontOrBack + "?"));
		
		Wheel frontWheel = new Wheel(brand, diameter);
		
		List<Wheel> listOfTwoSameWheels = new ArrayList<Wheel>();
		
		listOfTwoSameWheels.add(frontWheel);
		listOfTwoSameWheels.add(frontWheel);
		
		return listOfTwoSameWheels;
	}

}
