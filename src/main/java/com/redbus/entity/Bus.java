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
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String busNo;
    private int totalSeats;
    private int availableSeats;
    private String busType;
    private long price;


}

