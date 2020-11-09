package com.example.flightReservation.controller;
import com.example.flightReservation.repository.FlightRepository;
import com.example.flightReservation.entity.Flight;
import com.example.flightReservation.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import java.sql.Time;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

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

    @RequestMapping("/edit/{id}")
    public String editFlights(@PathVariable("id")int id, ModelMap modelMap){
       Flight flight= flightService.getFlightById(id);
       modelMap.addAttribute("flight",flight);
        return "editFlight";
    }
    @RequestMapping("/delete/{id}")
    public String deleteFlights(@PathVariable("id")int id, ModelMap modelMap){
        flightRepository.deleteById((long) id);
        List<Flight> flights= flightRepository.findAll();
        modelMap.addAttribute("flights",flights);
        return "viewFlights";
    }

    @RequestMapping("update/{id}")
    public String updateFlight(@PathVariable("id")int id,Flight flight,ModelMap modelMap){
        flightRepository.save(flight);
        List<Flight> flights=flightRepository.findAll();
        modelMap.addAttribute("flights",flights);

        return "viewFlights";
    }


}
