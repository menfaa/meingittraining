package com.vehicles.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CustomExceptionHandler {

    @ExceptionHandler(NoVehicleFoundException.class)
    public ResponseEntity<String> handleNoVehicleFoundException() {

        return ResponseEntity.internalServerError().body("No Vehicle found.");
    }

}
