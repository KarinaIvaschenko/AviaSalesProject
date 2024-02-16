package org.aviasales.Services;

import org.aviasales.DAO.CollectionCustomersDAO;
import org.aviasales.DAO.CollectionFlightsDAO;
import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Aviacompanies;
import org.aviasales.Enums.Cities;
import org.aviasales.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlightsServiceTest {
    private FlightsService flightsService;
    private CollectionFlightsDAO collectionFlightsDAO;

    @BeforeEach
    void init() {
        this.flightsService = new FlightsService();
    }

    @Test
    void getAllFlights() {
        FlightsService flightsService1 = new FlightsService();
        FlightsService flightsService2 = new FlightsService();
        Flight flight1 = new Flight(1, "2024-02-13", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        Flight flight2 = new Flight(2, "2024-02-13", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        List<Flight> flights1 = new ArrayList<>();
        flights1.add(flight1);
        List<Flight> flights2 = new ArrayList<>();
        flights2.add(flight2);
        flightsService1.setAllFlights(flights1);
        flightsService2.setAllFlights(flights2);
        assertNotEquals(flightsService1.getAllFlights(), flightsService2.getAllFlights());
    }

    @Test
    void setAllFlights() {
        FlightsService flightsService1 = new FlightsService();
        FlightsService flightsService2 = new FlightsService();
        Flight flight1 = new Flight(1, "2024-02-13", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        Flight flight2 = new Flight(2, "2024-02-13", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        List<Flight> flights1 = new ArrayList<>();
        flights1.add(flight1);
        List<Flight> flights2 = new ArrayList<>();
        flights2.add(flight2);
        flightsService1.setAllFlights(flights1);
        flightsService2.setAllFlights(flights2);
        assertNotEquals(flightsService1.getAllFlights(), flightsService2.getAllFlights());
    }

    @Test
    void getAllFlightsSorted() {
        FlightsService flightsService1 = new FlightsService();
        List<Flight> flightsList = new ArrayList<>();
        Flight flight1 = new Flight(1, "13/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        Flight flight2 = new Flight(2, "13/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        flightsList.add(flight2);
        flightsList.add(flight1);
        flightsService1.setAllFlights(flightsList);
        flightsService1.getAllFlightsSorted();
        assertEquals(flightsService1.getFlightById(1).getId() - 1, 0);
    }

    @Test
    void displayAllFlights() {
    }

    @Test
    void displayAllFlightsFor24Hours() {
    }

    @Test
    void getFlightById() {
    }

    @Test
    void deleteFlightById() {
    }

    @Test
    void findReqFlights() {
    }

    @Test
    void boughtTicket() {
    }

    @Test
    void returnTicket() {
    }
}