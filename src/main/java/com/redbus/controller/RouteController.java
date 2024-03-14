package com.redbus.controller;

import com.redbus.entity.Route;
import com.redbus.payload.RouteDto;
import com.redbus.payload.searchBusDto;
import com.redbus.service.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/route")
public class RouteController {

    @Autowired
    private RouteServiceImpl routeService ;
    @PostMapping("/{BusId}/add")
    public ResponseEntity<?> addRoute(@PathVariable long BusId, @RequestBody RouteDto routeDto){

        return routeService.addRoute(BusId,routeDto);
    }

    @GetMapping("/searchBusFromToLocationDate")
    public ResponseEntity<?> searchBus(@RequestParam String fromLocation,
                                       @RequestParam String toLocation,
                                       @RequestParam String fromDate){
        return routeService.findBus(fromLocation, toLocation, fromDate);

    }
}
