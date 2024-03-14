package com.redbus.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bus_route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromDate;
    private String toDate;
    private String fromDestination;
    private String toDestination;
    private String arrivalTime;
    private String departureTime;
    private long totalDistance;
    private long busId;



}
