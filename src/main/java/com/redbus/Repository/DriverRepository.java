package com.redbus.Repository;

import com.redbus.entity.BusDriver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<BusDriver,Long> {
}
