package com.example.flightReservation.service;

import com.example.flightReservation.entity.Flight;
import com.example.flightReservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    FlightRepository flightRepository;
//    @Override
//    public List<Flight> recentFlights() {
//        for(int i=0;i<5;i++){
//            return flightRepository.findAll();
//        }
//        return null;
//
//    }


    @Override
    public Flight getFlightById(int id) {
        return flightRepository.findById((long) id).orElse(null);
    }
}
