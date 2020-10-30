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
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @RequestMapping("/xyz")
    public String findFlights(@RequestParam("departureCity") String departureCity, @RequestParam("departureCity") String arrivalCity, @RequestParam("dateOfDeparture") @DateTimeFormat(pattern="yyyy-MM-dd")Date dateOfDeparture,
                              @RequestParam("dateOfReturn") @DateTimeFormat(pattern="yyyy-MM-dd") Date dateOfReturn, @RequestParam("flightNumber")String flightNumber, @RequestParam("price")String price, @RequestParam("estimatedDepartureTime") Time estimatedDepartureTime, Model model){

        List<Flight> flights = flightRepository.findFlights(departureCity, arrivalCity, dateOfDeparture,dateOfReturn,flightNumber,price,estimatedDepartureTime);
        model.addAttribute("flights",flights);
        return "displayFlights";
    }

    @RequestMapping("/showAddFlight")
    public String showAddFlight(){
        return "flight";
    }

    @RequestMapping(value ="/addFlight",method = RequestMethod.POST)
    public String addFlight(@ModelAttribute("flight") Flight flight){
       // flight.setDateOfDeparture(dateOfDeparture.toString());
        flightRepository.save(flight);
        return "flight";
    }


}
