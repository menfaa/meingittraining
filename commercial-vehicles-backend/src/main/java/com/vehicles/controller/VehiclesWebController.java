package com.vehicles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/www/vehicles")
public class VehiclesWebController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("message", "Vehicle flown says welcome.");
        return "vehicles";
    }

}