package com.example.flightReservation.controller;

import com.example.flightReservation.entity.Flight;
import com.example.flightReservation.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PassengerController {
    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping("/homepage")
    public String showHomepage(){
        return "index";
    }

    @RequestMapping("/checkRoundFlights")
    public String checkRoundFlights(String dateOfDeparture,String dateOfReturn,String PlaneClass,ModelMap modelMap){
        List<Flight> roundFlights = flightRepository.findRoundFlights(dateOfDeparture,dateOfReturn);
        modelMap.addAttribute("roundFlights",roundFlights);
        return "displayRoundFlights";
    }
    @RequestMapping("/checkOneWayFlights")
    public String checkOneWayFlights(@Param("dateOfDeparture")String dateOfDeparture,ModelMap modelMap){
        List<Flight> oneWay=flightRepository.getFlightByDate(dateOfDeparture);
        modelMap.addAttribute("oneWay",oneWay);
        return "displayOneWayFlights";
    }

@RequestMapping("/checkFlights")
public String getFlightByDate(@Param("dateOfDeparture")String dateOfDeparture, ModelMap modelMap){
    List<Flight> f=flightRepository.getFlightByDate(dateOfDeparture);
    modelMap.addAttribute("juma",f);
    return "displayFlights";

}


    @RequestMapping("/selectFlight/{id}")
    public String showCompleteReservation(@PathVariable("id") Long id, @ModelAttribute("flights")Flight flight, ModelMap modelMap) {
        Flight flights = flightRepository.findById(id).get();
        modelMap.addAttribute("flights", flights);
        return "reservation";
    }

//    @RequestMapping("/select/{id}")
//    public String showCompleteReservation(@PathVariable("id") Long id, @ModelAttribute("flights") Model model) {
//        Flight flights = flightRepository.findById(id).get();
//        model.addAttribute("flights", flights);
//        return "reservation";
//    }
}
