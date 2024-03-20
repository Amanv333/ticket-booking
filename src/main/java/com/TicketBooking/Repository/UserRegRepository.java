package com.TicketBooking.Repository;

import com.TicketBooking.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegRepository extends JpaRepository<UserRegistration,Long> {
}
