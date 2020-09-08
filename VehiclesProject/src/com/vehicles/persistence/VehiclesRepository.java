package com.vehicles.persistence;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.domain.Vehicle;

public class VehiclesRepository {
	
	/**
	 * the basis of this repository class is this array list attribute
	 */
	private static List<Vehicle> vehiclesRepository = new ArrayList<>();
	
	/**
	 * Basic and empty constructor only to assign an instance
	 */
	public VehiclesRepository() {
		
	}
	
	/**
	 * Get basic attribute
	 * @return returns an array list from the repository
	 */
	public List<Vehicle> getAllVehicles() {
		return vehiclesRepository;
	}
	
	/**
	 * Method of adding a vehicle to the repository.
	 * First checks if the vehicle is not null or empty, then adds
	 * @param vehicle car or bike classes
	 * @throws Exception if the object is NULL throws an exception
	 */
	public void addVehicle(Vehicle vehicle) throws Exception{
		if (vehicle==null) throw new Exception();
		vehiclesRepository.add(vehicle);
	}

}
