package com.example.flightReservation.controller;

import com.example.flightReservation.repository.ReservationRepository;
import com.example.flightReservation.Dto.ReservationUpdateRequest;
import com.example.flightReservation.entity.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReservationRestController {
    @Autowired
    ReservationRepository reservationRepository;

    //retrieving reservation by ID
    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id){
        return reservationRepository.findById(id).get();
    }

    //update reservation
    @PostMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        Reservation currReservation = reservationRepository.findById(request.getId()).get();
        currReservation.setCheckedIn(request.getCheckedIn());
        currReservation.setNumberOfBags(request.getNumberOfBags());
        return reservationRepository.save(currReservation);
    }
}
