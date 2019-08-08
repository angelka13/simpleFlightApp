package com.example.simpleapp.Repository;

import com.example.simpleapp.Model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface FlightRepository extends MongoRepository<Flight, String> {
    Flight findByPlaceFromAndPlaceToAndStartDateAndEndDate(String  ps, String  pe, Date s, Date e);
    
}
