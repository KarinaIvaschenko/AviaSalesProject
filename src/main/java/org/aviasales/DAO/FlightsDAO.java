package org.aviasales.DAO;

import org.aviasales.Flight;

import java.util.List;

public interface FlightsDAO {
    List<Flight> getAllFlights();

    void setAllFlights(List<Flight> flights);

    Flight getFlightByIndex(int index);

    Flight getFlightById(int id);

    boolean deleteFlightByIndex(int index);

    boolean deleteFlightById(int id);

    void saveFlight(Flight flight);
}
