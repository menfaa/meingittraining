package com.vehicles.controller;

import com.vehicles.exceptions.NoVehicleFoundException;
import com.vehicles.model.Truck;
import com.vehicles.model.Vehicle;
import com.vehicles.service.VehicleService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public Iterable<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("e1/{id}")
    public Vehicle getVehicleByE1Id(@PathVariable("id") Long id) {
        return vehicleService.getVehicleByE1Id(id);
    }

    @GetMapping("e2/{id}")
    public Vehicle getVehicleByE2Id(@PathVariable("id") Long id) {
        return vehicleService.getVehicleByE2Id(id);
    }

    @GetMapping("e3/{id}")
    public Vehicle getVehicleByE3Id(@PathVariable("id") Long id) {
        return vehicleService.getVehicleByE3Id(id);
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable("id") Long id) {
        vehicleService.deleteVehicle(id);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(EntityNotFoundException ex) {
        return ex.getMessage(); // Gibt die Fehlermeldung der Exception zurück
    }

    @ExceptionHandler(NoVehicleFoundException.class)
    public ResponseEntity<String> handleNoVehicleFoundException() {

        return ResponseEntity.internalServerError().body("No Vehicle found.");
    }
}