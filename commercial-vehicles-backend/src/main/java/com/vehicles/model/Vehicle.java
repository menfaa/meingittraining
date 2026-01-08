package com.vehicles.model;

import jakarta.persistence.*;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private int vehicleYear; // Renamed from 'year' to 'vehicleYear'

    private int mileage;

    // Standard constructor
    public Vehicle() {
    }

    // Constructor with parameters
    public Vehicle(String model, int vehicleYear, int mileage) {
        this.model = model;
        this.vehicleYear = vehicleYear;
        this.mileage = mileage;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    // Override toString method for debugging and display
    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", vehicleYear=" + vehicleYear +
                ", mileage=" + mileage +
                '}';
    }
}