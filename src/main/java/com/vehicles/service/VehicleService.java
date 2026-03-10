package com.vehicles.service;

import com.vehicles.exceptions.NoVehicleFoundException;
import com.vehicles.exceptions.NoVehicleFoundWebException;
import com.vehicles.model.Vehicle;
import com.vehicles.repository.VehicleRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Iterable<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleByE1Id(Long id) {
        return vehicleRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vehicle with Id " + id + "not found"));
    }

    public Vehicle getVehicleByE2Id(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new NoVehicleFoundWebException());

    }

    public Vehicle getVehicleByE3Id(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new NoVehicleFoundException());

    }

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}