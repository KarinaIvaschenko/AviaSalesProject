package org.aviasales.Controllers;

import org.aviasales.Flight;
import org.aviasales.Services.FlightsService;

import java.util.List;

public class FlightsController {
    FlightsService flightsService;

    public FlightsController() {
        this.flightsService = new FlightsService();
    }

    public List<Flight> getAllFlights() {
        return flightsService.getAllFlights();
    }
    public void setAllFlights(List<Flight> flights) {
        flightsService.setAllFlights(flights);
    }
}
