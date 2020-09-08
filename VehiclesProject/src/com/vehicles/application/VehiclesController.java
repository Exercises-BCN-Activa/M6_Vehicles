package com.vehicles.application;

import java.util.Iterator;
import com.vehicles.domain.Vehicle;
import com.vehicles.utilities.Inputs;
import com.vehicles.persistence.VehiclesRepository;

public final class VehiclesController {
	
	private VehiclesRepository repository = new VehiclesRepository();
	
	/**
	 * basic constructor without variables
	 */
	public VehiclesController() {}
	
	/**
	 * System navigation method, which pops up a JOptionPane window 
	 * asking what the user wants to do: Register new vehicle, 
	 * Consult registered vehicles or Exit this loop.
	 * collects the first letter of the input, 
	 * if R invokes the method to create a vehicle (createNewVehicle) 
	 * if C invokes the method to consult all vehicles in data base (showDetailsVehicles) 
	 * if S simply send a thank you message and end the loop
	 * @throws Exception in the method createNewVehicle
	 */
	public void wantToDo() throws Exception {
		String whatWant;
		
		do {
			whatWant = Inputs.returnString("Registrar, Consultar, Sortir\nQuè vols fer? [R, C, S]").toUpperCase();
		} while (!"RCSN".contains(whatWant.substring(0, 1)));
		
		switch (whatWant.charAt(0)) {
			case 'R':
				createNewVehicle();
				break;
				
			case 'C':
				showDetailsVehicles();
				break;
				
			case 'S':
				Inputs.showMessage("Gràcies per utilitzar el nostre sistema.");
				break;
				
			case 'N':
				Inputs.showMessage("Gràcies per utilitzar el nostre sistema.");
				break;
				
			default:
				Inputs.showMessage("ERROR! Opció no identificada: " + whatWant);
		}
		
		if ("RC".contains(whatWant.substring(0, 1))) {
			wantToDo();
		}
	}
	
	/**
	 * Method for creating a new vehicle, asks the user via JOptionPane Class 
	 * if he wants to create a motorcycle or car, collects the first letter 
	 * of the input, if C invokes the method to create a car 
	 * and if M invokes the method to create a motorcycle.
	 * @throws Exception: in the construction methods of the car and bike objects, 
	 * performed by the VehiclesFactory class
	 */
	public void createNewVehicle() throws Exception {
		String whicheOne;
		
		do {
			whicheOne = Inputs.returnString("Quin tipus de vehicle voleu matricular,\nCotxe o Moto? [C, M]").toUpperCase();
		} while (!"CMN".contains(whicheOne.substring(0, 1)));
		
		switch (whicheOne.charAt(0)) {
			case 'C':
				repository.addVehicle(VehiclesFactory.createNewCar());
				break;
			case 'M':
				repository.addVehicle(VehiclesFactory.createNewBike());
				break;
			default:
				Inputs.showMessage("ERROR! Opció no identificada: " + whicheOne);
		}
	}
	
	/**
	 * method that captures the repository and prints on console 
	 * each of the stored vehicles, in case it is empty it informs its status.
	 */
	public void showDetailsVehicles() {
		
		if (!repository.getAllVehicles().isEmpty()) {
			
			Iterator<Vehicle> it = repository.getAllVehicles().iterator();
			while (it.hasNext()) {
				System.out.println(it.next().toString());
			}
			
		} else {
			Inputs.showMessage("No hi ha cap vehicle registrat a la base de dades.");			
		}
	}

}
