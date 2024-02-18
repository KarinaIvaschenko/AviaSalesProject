package org.aviasales.Controllers;

import org.aviasales.Entity.Flight;
import org.aviasales.Services.FlightsService;

import java.text.ParseException;
import java.util.List;

public class FlightsController {
    FlightsService flightsService;

    public FlightsController(FlightsService flightsService) {
        this.flightsService = flightsService;
    }

    public List<Flight> getAllFlights() {
        return flightsService.getAllFlights();
    }

    public void setAllFlights(List<Flight> flights) {
        flightsService.setAllFlights(flights);
    }

    public void displayAllFlights() {
        flightsService.displayAllFlights();
    }

    public Flight getFlightById(int id) {
        return flightsService.getFlightById(id);
    }

    public boolean deleteFlightById(int id){
        return flightsService.deleteFlightById(id);
    }

    public void displayAllFlightsFor24Hours() throws ParseException {
        flightsService.displayAllFlightsFor24Hours();
    }

    public boolean findReqFlights(String pointA, String pointB, String date, int passengers) {
        return flightsService.findReqFlights(pointA, pointB, date, passengers);
    }

    public void boughtTicket(int id, int tickets) {
       flightsService.boughtTicket(id, tickets);
    }

    public void returnTicket(int id, int tickets) {
       flightsService.returnTicket(id, tickets);
    }
}
