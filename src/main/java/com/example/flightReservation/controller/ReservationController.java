package com.example.flightReservation.controller;
import com.example.flightReservation.repository.FlightRepository;
import com.example.flightReservation.Dto.ReservationRequest;
import com.example.flightReservation.entity.Flight;
import com.example.flightReservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    ReservationService reservationService;
//
//    @RequestMapping("/selectFlight/{id}")
//    public String showCompleteReservation(@PathVariable("id") Long id, @ModelAttribute("flights")Flight flight, ModelMap modelMap) {
//        Flight flights = flightRepository.findById(id).get();
//        modelMap.addAttribute("flights", flights);
//        return "reservation";
//    }

    @PostMapping("/complete-reservation")
    public String completeReservation(@ModelAttribute ReservationRequest reservationRequest, Model model) {
        reservationService.bookFlight(reservationRequest);
        model.addAttribute("msg","Reservation created successfully");
        return "reservationConfirmation";
    }


}
