package com.example.flightReservation.controller;
import com.example.flightReservation.repository.FlightRepository;
import com.example.flightReservation.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//import java.sql.Time;
import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping(value ="/flights", method = RequestMethod.POST)
    public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to, @RequestParam("dateOfDeparture") @DateTimeFormat(pattern="yyyy-MM-dd")Date dateOfDeparture, @RequestParam("dateOfReturn") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfReturn,Model model){

        List<Flight> flights = flightRepository.findFlights(from, to, dateOfDeparture,dateOfReturn);
        model.addAttribute("flights",flights);
        return "displayFlights";
    }

    @RequestMapping("/showAddFlight")
    public String showAddFlight(){
        return "addFlight";
    }

    @RequestMapping(value ="/addFlight",method = RequestMethod.POST)
    public String addFlight(@ModelAttribute("flight") Flight flight){
        flightRepository.save(flight);
        return "displayFlights";
    }


}
