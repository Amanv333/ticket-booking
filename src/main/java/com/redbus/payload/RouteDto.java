package com.redbus.payload;

import com.redbus.entity.SubRoute;
import javax.persistence.*;

import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

    private String fromDate;
    private String toDate;
    private String fromDestination;
    private String toDestination;
    private String arrivalTime;
    private String departureTime;
    private long totalDistance;

}
