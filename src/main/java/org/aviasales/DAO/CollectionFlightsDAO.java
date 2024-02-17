package org.aviasales.DAO;

import org.aviasales.Flight;

import java.util.ArrayList;
import java.util.List;

public class CollectionFlightsDAO implements FlightsDAO {
    private List<Flight> flights;

    public CollectionFlightsDAO() {
        this.flights = new ArrayList<>();
    }

    @Override
    public List<Flight> getAllFlights() {
        return flights;
    }

    @Override
    public void setAllFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public Flight getFlightById(int id) {
        return this.flights.stream()
                .filter(flight -> flight.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteFlightById(int id) {
        if (!this.flights.isEmpty()) {
            return this.flights.removeIf(flight -> flight.getId() == id);
        }
        return false;
    }

    @Override
    public void saveFlight(Flight flight) {
        if (this.flights.contains(flight)) {
            int index = flights.indexOf(flight);
            this.flights.set(index, flight);
        } else {
            flights.add(flight);
        }
    }
}