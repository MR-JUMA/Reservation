package com.example.flightReservation.controller;
import com.example.flightReservation.repository.FlightRepository;
import com.example.flightReservation.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import java.sql.Time;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("/viewFlight")
    public String findFlights(Model model){

        List<Flight> flights = flightRepository.findAll();
        model.addAttribute("flights",flights);
        return "viewFlights";
    }

    @RequestMapping("/showAddFlight")
    public String showAddFlight(){
        return "addFlight";
    }

    @RequestMapping(value ="/addFlight",method = RequestMethod.POST)
    public String addFlight(@ModelAttribute("flight") Flight flight){
       // flight.setDateOfDeparture(dateOfDeparture.toString());
        flightRepository.save(flight);
        return "addFlight";
    }


}
