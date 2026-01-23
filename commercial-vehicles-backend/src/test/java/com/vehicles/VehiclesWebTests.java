package com.vehicles;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.vehicles.controller.VehiclesWebController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(VehiclesWebController.class)
public class VehiclesWebTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void greetingShouldReturnMessage() throws Exception {

        mockMvc.perform(get("/www/vehicles"))
                .andExpect(status().isOk()) // Verify HTTP status is 200 OK
                .andExpect(view().name("vehicles")) // Verify the returned view name
                .andExpect(model().attribute("message", "Vehicle flown says welcome.")); // Verify the model attribute
    }

}
