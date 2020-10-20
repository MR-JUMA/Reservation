package com.example.flightReservation.service;

import com.example.flightReservation.repository.FlightRepository;
import com.example.flightReservation.repository.PassengerRepository;
import com.example.flightReservation.repository.ReservationRepository;
import com.example.flightReservation.Dto.ReservationRequest;
import com.example.flightReservation.entity.Flight;
import com.example.flightReservation.entity.Passenger;
import com.example.flightReservation.entity.Reservation;
//import com.udemy.flightReservation.util.EmailUtil;
import com.example.flightReservation.util.EmailUtil;
import com.example.flightReservation.util.PdfGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PdfGenerator pdfGenerator;
    @Autowired
    EmailUtil emailUtil;

    public Reservation bookFlight(ReservationRequest reservationRequest){
       try {
           //retrieve flight from the database
           Flight flight = flightRepository.findById(reservationRequest.getFlightId()).get();

           //creates a new passenger and save to db
           Passenger passenger = new Passenger();
           passenger.setFirstName(reservationRequest.getpFirstName());
           passenger.setLastName(reservationRequest.getpLastName());
           passenger.setEmail(reservationRequest.getpEmail());
           passenger.setPhone(reservationRequest.getpPhone());
           Passenger savedPassenger = passengerRepository.save(passenger);

           //creates a reservation
           Reservation reservation = new Reservation();
           reservation.setCheckedIn(false);
           reservation.setFlight(flight);
           reservation.setPassenger(savedPassenger);
           Reservation savedReservation = reservationRepository.save(reservation);

           String filePath = "/home/chia/Desktop/reservations" + savedReservation.getId() + ".pdf";

           pdfGenerator.generateItinerary(savedReservation,filePath);

           emailUtil.sendItinerary(passenger.getEmail(),filePath);

           return savedReservation;
       }catch (Exception e){
           e.printStackTrace();
       }

        return null;

    }

    public void sendItinerary(){

    }

}
