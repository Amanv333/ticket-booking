package com.redbus.controller;

import com.redbus.entity.Passenger;
import com.redbus.service.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;

    @PostMapping("/bookTicket")
    public ResponseEntity<?> bookTicket(
            @RequestParam long busId,
            @RequestParam long routeId,
            @RequestBody Passenger passenger

            ){
        try {
            String bookTicket = reservationService.bookTicket(busId, routeId, passenger);
            return new ResponseEntity<>(bookTicket, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
