package com.example.flightReservation.controller;

import com.example.flightReservation.repository.FlightRepository;
import com.example.flightReservation.repository.ReservationRepository;
import com.example.flightReservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/c")
    public String showHomePage(){
        return "index";
    }
    @GetMapping("/forms")
    public String addUser(){
        return "forms";
    }



    @GetMapping("/ab")
    public String seeAmt(ModelMap modelMap){
         modelMap.addAttribute("count",userRepository.count());
         modelMap.addAttribute("flights",flightRepository.count());
         modelMap.addAttribute("reserves",reservationRepository.count());
         return "index";
    }


}