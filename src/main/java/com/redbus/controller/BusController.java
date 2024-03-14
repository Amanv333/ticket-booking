package com.redbus.controller;

import com.redbus.entity.Bus;
import com.redbus.payload.BusDto;
import com.redbus.payload.BusnewDto;
import com.redbus.service.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    @Autowired
    private BusServiceImpl busService;

    @PostMapping("/add")
    public ResponseEntity<?> addBus(@RequestBody BusDto busDto){
        return busService.addBus(busDto);
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteBus(@PathVariable Long id){
        busService.deleteBus(id);
        return new ResponseEntity<>("Bus Deleted by : "+ id,HttpStatus.OK);
    }

    @GetMapping("/allBus")
    public ResponseEntity<?> ShowBuses(){
        List<BusDto> busdtos = busService.allBus();
        return new ResponseEntity<>(busdtos,HttpStatus.OK);
    }
    @GetMapping("/{busId}/getBus")
    public ResponseEntity<?> getABus(@PathVariable long busId){
        BusDto dto = busService.getBusById(busId);
        return new ResponseEntity<>(dto,HttpStatus.OK);

    }
    @PutMapping("/update")
    public ResponseEntity<?> updateBus(@RequestParam long busId,@RequestBody BusnewDto busDto){
        BusnewDto dto = busService.updateBus(busId,busDto);
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }
}
