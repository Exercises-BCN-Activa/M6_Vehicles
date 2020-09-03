package com.vehicles.view;

import com.vehicles.application.VehiclesController;

public class Main {
	
	static VehiclesController controler = new VehiclesController();

	public static void main(String[] args) throws Exception {
		
		controler.createNewCar();
		controler.showDetailsVehicles();
		

	}

}
