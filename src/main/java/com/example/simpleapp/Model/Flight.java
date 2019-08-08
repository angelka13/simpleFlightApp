package com.example.simpleapp.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "flights")
public class Flight {
    @Id
    private String id;
    private String placeFrom;
    private String placeTo;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date startDate;
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date endDate;

    private int maxPlace;
    private double ticketPrice;
    //private List<User> touristList;


    public Flight(String id, String placeFrom, String placeTo, Date startDate, Date endDate, int maxPlace, double ticketPrice) {
        this.id = id;
        this.placeFrom = placeFrom;
        this.placeTo = placeTo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxPlace = maxPlace;
        this.ticketPrice = ticketPrice;
    }

    public Flight(String from, String to, Date startDate, Date endDate, int maxPlace, double ticketPrice) {
        this.placeFrom = from;
        this.placeTo = to;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxPlace = maxPlace;
        this.ticketPrice = ticketPrice;

    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", placeFrom=" + placeFrom +
                ", placeTo=" + placeTo +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", maxPlace=" + maxPlace +
                ", ticketPrice=" + ticketPrice +
               // ", touristList=" + touristList +
                '}';
    }

    public Flight() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlaceFrom() {
        return placeFrom;
    }

    public void setPlaceFrom(String from) {
        this.placeFrom = from;
    }

    public String getplaceTo() {
        return placeTo;
    }

    public void setplaceTo(String  to) {
        this.placeTo = to;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMaxPlace() {
        return maxPlace;
    }

    public void setMaxPlace(int maxPlace) {
        this.maxPlace = maxPlace;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }


}


