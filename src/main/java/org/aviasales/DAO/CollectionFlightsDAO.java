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
        try {
            return this.flights.stream()
                    .filter(flight -> flight.getId() == id)
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean deleteFlightByIndex(int index) {
        try {
            if (!this.flights.isEmpty()) {
                this.flights.remove(index);
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    @Override
    public boolean deleteFlightById(int id) {
        try {
            if (!this.flights.isEmpty()) {
                this.flights.remove(id);
                return true;
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }

    @Override
    public void saveFlight(Flight flight) {
        try {
            if (this.flights.contains(flight)) {
                int index = flights.indexOf(flight);
                this.flights.set(index, flight);
            } else {
                flights.add(flight);
            }
        } catch (Exception e) {
            throw e;
        }
    }
}