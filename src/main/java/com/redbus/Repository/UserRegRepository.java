package com.redbus.Repository;

import com.redbus.entity.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegRepository extends JpaRepository<UserRegistration,Long> {
}
