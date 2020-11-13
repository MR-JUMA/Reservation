package com.example.flightReservation.controller;

import com.example.flightReservation.entity.Flight;
import com.example.flightReservation.repository.FlightRepository;
import com.example.flightReservation.repository.ReservationRepository;
import com.example.flightReservation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
        return "blank";
    }





    @GetMapping("/ab")
    public String seeAmt(ModelMap modelMap){
         modelMap.addAttribute("count",userRepository.count());
         modelMap.addAttribute("flights",flightRepository.count());
         modelMap.addAttribute("reserves",reservationRepository.count());

        List<Flight> flightList=flightRepository.findRecentFlights();
        modelMap.addAttribute("fx",flightList);
         return "admin";
    }



//    @RequestMapping("/myFlights")
//    public String seeAllFlights(Model model){
//
//        return "index";
//    }

//    @RequestMapping(value ="/ab", method = RequestMethod.POST)
//    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("dateOfDeparture") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfDeparture,
//                              @RequestParam("dateOfReturn") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfReturn, @RequestParam("flightNumber")String flightNumber, @RequestParam("price")String price, @RequestParam("estimatedDepartureTime") Time estimatedDepartureTime, Model model){
//
//        List<Flight> flights = flightRepository.findFlights(from,to,dateOfDeparture,dateOfReturn,flightNumber,price,estimatedDepartureTime);
//        model.addAttribute("flights",flights);
//        return "index";
//    }

    @RequestMapping("/logout")
    public String exitAcc(){
        return "login";
    }

//    public String myMethod(){
//        return null;
//    }

}