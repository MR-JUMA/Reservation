package com.example.flightReservation.service;

import com.example.flightReservation.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> getAllUsers();
}
