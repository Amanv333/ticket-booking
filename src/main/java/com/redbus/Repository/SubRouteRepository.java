package com.redbus.Repository;

import com.redbus.entity.Route;
import com.redbus.entity.SubRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubRouteRepository extends JpaRepository<SubRoute,Long> {
    List<SubRoute> findByFromDestinationAndToDestinationAndFromDate(String fromLocation, String toLocation, String fromDate);

    boolean existsByRouteId(long routeId);
}
