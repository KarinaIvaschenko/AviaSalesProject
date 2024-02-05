package org.aviasales.Services;

import org.aviasales.DAO.CollectionFlightsDAO;
import org.aviasales.Flight;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlightsService {
    private final CollectionFlightsDAO collectionFlightsDAO = new CollectionFlightsDAO();

    public List<Flight> getAllFlights() {
        return collectionFlightsDAO.getAllFlights();
    }

//    public void displayAllFlights() {
//        if (!getAllFlights().isEmpty()) {
//            System.out.println("All families:");
//            List<Flight> allFlights = getAllFlights();
//            List<String> flightString = allFlights.stream()
//                    .map(family -> family.prettyFormat()).collect(Collectors.toList());
//            IntStream.range(0, allFlights.size())
//                    .forEach(index -> System.out.println(index + 1 + ". " + flightString.get(index)));
//        } else {
//            System.out.println("No families");
//        }
//    }
}
