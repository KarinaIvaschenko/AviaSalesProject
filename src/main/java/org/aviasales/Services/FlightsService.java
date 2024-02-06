package org.aviasales.Services;

import org.aviasales.DAO.CollectionFlightsDAO;
import org.aviasales.Flight;

import java.util.List;

public class FlightsService {
    private final CollectionFlightsDAO collectionFlightsDAO = new CollectionFlightsDAO();

    public List<Flight> getAllFlights() {
        return collectionFlightsDAO.getAllFlights();
    }

    public void setAllFlights(List<Flight> flights) {
        collectionFlightsDAO.setAllFlights(flights);
    }

}
