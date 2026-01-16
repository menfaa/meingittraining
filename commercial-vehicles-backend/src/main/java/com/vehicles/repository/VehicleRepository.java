package com.vehicles.repository;

import com.vehicles.model.Vehicle;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    Optional<Vehicle> findById(Long id);

}