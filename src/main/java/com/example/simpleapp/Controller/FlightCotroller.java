package com.example.simpleapp.Controller;

import com.example.simpleapp.Model.Flight;
import com.example.simpleapp.Repository.FlightRepository;
import com.example.simpleapp.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class FlightCotroller {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightService flightService;
    @RequestMapping(value = "/allFlights", method = RequestMethod.GET)
    public ModelAndView allFlights() {
        ModelAndView modelAndView = new ModelAndView();
        List<Flight> flightList=flightService.getAll();
        if(flightList!=null){
            modelAndView.addObject("flights",flightList);
        }
        modelAndView.setViewName("default");
        return modelAndView;
    }

    @RequestMapping(value = "/addFlight", method = RequestMethod.GET)
    public ModelAndView addFlight() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addFlight");
        return modelAndView;
    }
    @RequestMapping(value = "/addFlight", method = RequestMethod.POST)
    public ModelAndView addFlight(Flight flight) {
        ModelAndView modelAndView = new ModelAndView();

        Flight flightExist= flightRepository.findByPlaceFromAndPlaceToAndStartDateAndEndDate(flight.getPlaceFrom(),flight.getplaceTo(),
                flight.getStartDate(),flight.getEndDate());

        flightRepository.save(flight);
        List<Flight> flightList=flightRepository.findAll();
        if(flightList!=null){
            modelAndView.addObject("flights",flightList);
        }
        modelAndView.setViewName("default");
        return modelAndView;
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public Optional<Flight> getOne(String id){
        return flightService.getOne(id);
    }

    @RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Flight flight){
        System.out.println("update "+flight.toString());

        flightService.update(flight);
        return "redirect:/allFlights";
    }

    @PostMapping("/addNew")
    public String addNew(Flight flight){
        System.out.println("add new "+flight.toString());
            flightService.addNew(flight);
            return "redirect:/allFlights";
        }


}
