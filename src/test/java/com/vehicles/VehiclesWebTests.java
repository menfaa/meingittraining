package com.vehicles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.vehicles.controller.VehiclesWebController;
import com.vehicles.model.Truck;
import com.vehicles.service.VehicleService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

@WebMvcTest(VehiclesWebController.class)
public class VehiclesWebTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VehicleService vehicleService; // <--- Mock für den Service hinzufügen

    @Test
    void indexShouldReturnVehiclesAsMessage() throws Exception {

        // Erzeuge das Truck-Objekt wie gewünscht
        Truck mockVehicle = new Truck("VW Golf", 2020, 112000, 55);

        // Gib dieses Objekt als Liste zurück
        when(vehicleService.getAllVehicles()).thenReturn(List.of(mockVehicle));

        mockMvc.perform(get("/vw/vehicles"))
                .andExpect(status().isOk())
                .andExpect(view().name("vehicles"))
                .andExpect(model().attribute("vehicles", List.of(mockVehicle)));
    }

}
