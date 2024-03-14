package com.redbus.payload;

import lombok.Data;

@Data
public class SubRouteDto {

    private String subRouteName;
    private String fromDate;
    private String toDate;
    private String fromDestination;
    private String toDestination;
    private String arrivalTime;
    private String departureTime;
    private long totalDistance;

}
