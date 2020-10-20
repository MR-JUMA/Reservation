package com.example.flightReservation.repository;

import com.example.flightReservation.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
