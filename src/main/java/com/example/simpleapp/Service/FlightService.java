package com.example.simpleapp.Service;

import com.example.simpleapp.Model.Flight;
import com.example.simpleapp.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public void saveFlight(Flight flight){

            flightRepository.save(flight);

        System.out.println("błąd dodawania");
    }
    public List<Flight> getAll(){
        return flightRepository.findAll();
    }
    public Optional<Flight> getOne(String id){
        return flightRepository.findById(id);
    }
    public void addNew(Flight flight){
        flightRepository.save(flight);
    }
    public void update(Flight flight){        System.out.println(flight.toString());

        String id=flight.getId();
        flightRepository.delete(flight);
        flight.setId(id);
        flightRepository.save(flight);
    }
}
