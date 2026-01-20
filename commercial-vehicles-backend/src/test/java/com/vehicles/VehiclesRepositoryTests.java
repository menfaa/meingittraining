package com.vehicles;

// 1. FIXED: JUnit 5 assertion import
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import com.vehicles.model.Vehicle;
import com.vehicles.repository.VehicleRepository;

@Testcontainers
@SpringBootTest
class VehiclesRepositoryTests { // 2. Best Practice: package-private visibility

    @Autowired
    private VehicleRepository repository;

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>(
            DockerImageName.parse("postgres:latest"));

    @Test
    void shouldSaveVehicles() {
        var vehicle = new Vehicle();
        vehicle.setModel("VW Passat");
        vehicle.setVehicleYear(2014);
        vehicle.setMileage(172000);

        var savedVehicle = this.repository.save(vehicle);
        assertNotNull(savedVehicle.getId());
    }
}