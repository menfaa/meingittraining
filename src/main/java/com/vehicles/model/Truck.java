package com.vehicles.model;

import jakarta.persistence.*;

@Entity
public class Truck extends Vehicle {
    private int loadCapacity; // Load capacity in tons

    // Standard constructor
    public Truck() {
    }

    // Constructor with parameters
    public Truck(String model, int vehicleYear, int mileage, int loadCapacity) {
        super(model, vehicleYear, mileage); // Updated to use vehicleYear
        this.loadCapacity = loadCapacity;
    }

    // Getters and Setters
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    // Override toString method for debugging and display
    @Override
    public String toString() {
        return "Truck{" +
                "id=" + getId() +
                ", model='" + getModel() + '\'' +
                ", vehicleYear=" + getVehicleYear() + // Updated to use vehicleYear
                ", mileage=" + getMileage() +
                ", loadCapacity=" + loadCapacity +
                '}';
    }
}