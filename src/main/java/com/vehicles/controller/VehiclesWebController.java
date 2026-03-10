package com.vehicles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vehicles.model.Vehicle;
import com.vehicles.service.VehicleService;

@Controller
@RequestMapping("/vw/vehicles")
public class VehiclesWebController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/back")
    public String backToAddForm() {
        // Hier kannst du ggf. Logik einfügen
        return "redirect:/vw";
    }

    @PostMapping(value = "/delete")
    public String deleteTruck(@RequestParam Long id) {
        vehicleService.deleteVehicle(id);
        return "vehicles"; // Nach dem Löschen zurück zur Übersicht
    }

    @GetMapping()
    public String index(Model model) {
        Iterable<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("vehicles", vehicles); // Liste direkt übergeben
        return "vehicles";
    }

}
