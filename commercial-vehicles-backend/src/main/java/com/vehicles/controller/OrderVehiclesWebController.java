package com.vehicles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vehicles.model.Truck;
import com.vehicles.model.Vehicle;
import com.vehicles.service.VehicleService;

@Controller
@RequestMapping("/vw")
public class OrderVehiclesWebController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping(value = "/addtruck")
    public String addTruck(@ModelAttribute Truck truck, Model model) {
        vehicleService.saveVehicle(truck);
        return "redirect:/vw/vehicles"; // Nach dem Hinzufügen zurück zur Übersicht
    }

    @GetMapping()
    public String get(Model model) {
        Iterable<Vehicle> vehicles = vehicleService.getAllVehicles();
        model.addAttribute("truck", new Truck());
        model.addAttribute("vehicles", vehicles);
        return "vehicles-form";
    }
}