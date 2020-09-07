package com.vehicles.application;

import java.util.Iterator;
import com.vehicles.domain.Vehicle;
import com.vehicles.utilities.Inputs;
import com.vehicles.persistence.VehiclesRepository;

public final class VehiclesController {
	
	private VehiclesRepository repository = new VehiclesRepository();
	
	public VehiclesController() {}
	
	public void wantToDo() throws Exception {
		String whatWant;
		
		do {
			whatWant = Inputs.returnString("Registrar, Consultar, Sortir\nQuè vols fer? [R, C, S]").toUpperCase();
		} while (!"RCS".contains(whatWant.substring(0, 1)));
		
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
				
			default:
				Inputs.showMessage("ERROR! Opció no identificada: " + whatWant);
		}
		
		if ("RC".contains(whatWant.substring(0, 1))) {
			wantToDo();
		}
	}
	
	public void createNewVehicle() throws Exception {
		String whicheOne;
		
		do {
			whicheOne = Inputs.returnString("Quin tipus de vehicle voleu matricular, cotxe o moto?").toUpperCase();
		} while (!"CM".contains(whicheOne.substring(0, 1)));
		
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
