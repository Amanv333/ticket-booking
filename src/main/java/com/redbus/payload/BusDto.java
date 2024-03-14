package com.redbus.payload;

import com.redbus.entity.BusDriver;
import com.redbus.entity.Route;
import com.redbus.entity.SubRoute;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {
    private long id;
    private String busNo;
    private int totalSeats;
    private int availableSeats;
    private String busType;
    private long price;
}
