package com.vehicles.persistence;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.domain.Vehicle;

public class VehiclesRepository {
	
	private static List<Vehicle> vehiclesRepository = new ArrayList<>();
	
	public VehiclesRepository() {
		
	}
	
	public List<Vehicle> getAllVehicles() {
		return vehiclesRepository;
	}
	
	public void addVehicle(Vehicle vehicle) throws Exception{
		if (vehicle==null) throw new Exception();
		vehiclesRepository.add(vehicle);
	}

}
