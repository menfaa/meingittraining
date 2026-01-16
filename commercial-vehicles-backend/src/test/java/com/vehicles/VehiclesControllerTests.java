package com.vehicles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.vehicles.controller.VehicleController;
import com.vehicles.model.Truck;
import com.vehicles.model.Vehicle;
import com.vehicles.service.VehicleService;

import static org.mockito.Mockito.*;

@WebMvcTest(VehicleController.class)
public class VehiclesControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehicleService vehicleService; // Mock für die Abhängigkeit des Controllers

    @Test
    public void shouldSaveVehicles() throws Exception {
        // Mock-Daten für das Fahrzeug
        var mockVehicle = new Truck("VW Golf", 2020, 112000, 55);
        mockVehicle.setId(1L); // ID wird vom Service generiert
        mockVehicle.setLoadCapacity(55); // Beispielwert für loadCapacity

        // Mock-Verhalten für den Service
        when(vehicleService.saveVehicle(any(Vehicle.class))).thenReturn(mockVehicle);

        // JSON-Daten für die Anfrage
        String vehicleJson = "{ \"model\": \"VW Golf\", \"vehicleYear\": 2020, \"mileage\": 112000, \"loadCapacity\": 55 }";

        // Test der POST-Methode
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/api/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(vehicleJson))
                .andExpect(MockMvcResultMatchers.status().isOk()) // Erwartet HTTP 200
                .andExpect(MockMvcResultMatchers.jsonPath("$.model").value("VW Golf")) // Überprüft das Modell
                .andExpect(MockMvcResultMatchers.jsonPath("$.vehicleYear").value(2020)) // Überprüft das Baujahr
                .andExpect(MockMvcResultMatchers.jsonPath("$.mileage").value(112000)) // Überprüft die Kilometerleistung
                .andExpect(MockMvcResultMatchers.jsonPath("$.loadCapacity").value(55)) // Überprüft die Ladekapazität
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L)); // Überprüft die ID
    }
}