package com.example.flightReservation.service;

import com.example.flightReservation.entity.Flight;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public interface FlightService {
    //List<Flight> recentFlights();
    Flight getFlightById(int id);
    //Flight getFlightByDate(Date date);

}
