package com.redbus.service;

import com.redbus.Repository.RouteRepository;
import com.redbus.Repository.SubRouteRepository;
import com.redbus.entity.SubRoute;
import com.redbus.exception.ResourseNotFoundException;
import com.redbus.payload.SubRouteDto;
import lombok.val;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SubRouteServiceImpl {
    @Autowired
    private SubRouteRepository subRouteRepository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private RouteRepository routeRepository;
    public ResponseEntity<?> addAll(long routeId, List<SubRouteDto> dtos) {
    if(routeRepository.existsById(routeId)){
        List<SubRoute> subRoutes = dtos.stream().map(this::mapToEntity).collect(Collectors.toList());
        for (SubRoute s:subRoutes){
            s.setRouteId(routeId);
        }
        List<SubRoute> list = subRouteRepository.saveAll(subRoutes);
        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }
    else{
        return new ResponseEntity<>(
                new ResourseNotFoundException("Route is not present"),HttpStatus.BAD_REQUEST);
    }
    }

    SubRoute mapToEntity(SubRouteDto dto){
        return mapper.map(dto,SubRoute.class);
    }
}
