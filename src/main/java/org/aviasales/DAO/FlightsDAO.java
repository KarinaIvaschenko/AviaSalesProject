package org.aviasales.DAO;

import org.aviasales.Flight;

import java.util.List;

public interface FlightsDAO {
    List<Flight> getAllFlights();

    void setAllFlights(List<Flight> flights);

    Flight getFlightById(int id);

    boolean deleteFlightById(int id);

    void saveFlight(Flight flight);

}
