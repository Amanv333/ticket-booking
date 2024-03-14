package com.redbus.controller;

import com.redbus.entity.SubRoute;
import com.redbus.payload.SubRouteDto;
import com.redbus.service.SubRouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subroute")
public class SubRouteController {

    @Autowired
    private SubRouteServiceImpl subRouteService;

    @PostMapping("/add")
    public ResponseEntity<?> AddSubRoute(@RequestParam long routeId, @RequestBody List<SubRouteDto> dtos){
        ResponseEntity<?> responseEntity = subRouteService.addAll(routeId, dtos);
        return responseEntity;

    }

}
