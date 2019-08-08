package com.example.simpleapp;

import com.example.simpleapp.Model.Flight;
import com.example.simpleapp.Model.Role;
import com.example.simpleapp.Model.User;
import com.example.simpleapp.Repository.FlightRepository;
import com.example.simpleapp.Repository.RoleRepository;
import com.example.simpleapp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
public class SimpleAppApplication {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository,
                             FlightRepository flightRepository) {

        return args -> {

            String date_s = " 2011-01-18 00:00:00.0";
            SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
            Date parseDateS= dt.parse(date_s);
            String date_e = " 2011-04-18 00:00:00.0";
            Date parseDateE= dt.parse(date_e);

            Flight newFlight = flightRepository.findByPlaceFromAndPlaceToAndStartDateAndEndDate("krakow","warsaw",parseDateS,parseDateE);
            if(newFlight==null)
            {
                Flight flight=new Flight("krakow","warsaw",parseDateS,parseDateE,40,150.25);
                flightRepository.save(flight);

            }

            Role adminRole = roleRepository.findByRole("ADMIN");
            if (adminRole == null) {
                Role newAdminRole = new Role();
                newAdminRole.setRole("ADMIN");
                roleRepository.save(newAdminRole);
            }

            Role userRole = roleRepository.findByRole("USER");
            if (userRole == null) {
                Role newUserRole = new Role();
                newUserRole.setRole("USER");
                roleRepository.save(newUserRole);
            }
            if(userRepository.findByEmail("admin@test.pl")==null) {
                adminRole = roleRepository.findByRole("ADMIN");
                User admin = new User();
                admin.setEmail("admin@test.pl");
                admin.setFullname("Administrator");

                admin.setPassword(bCryptPasswordEncoder.encode("admin"));
                admin.setEnabled(true);
                admin.setRoles(new HashSet<>(Arrays.asList(adminRole)));
                userRepository.save(admin);
            }
        };

    }
    public static void main(String[] args) {
        SpringApplication.run(SimpleAppApplication.class, args);
    }

}
