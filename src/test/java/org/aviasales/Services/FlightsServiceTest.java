package org.aviasales.Services;

import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Aviacompanies;
import org.aviasales.Enums.Cities;
import org.aviasales.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class FlightsServiceTest {
    private FlightsService flightsService1;
    private FlightsService flightsService2;

    @BeforeEach
    void init() {
        this.flightsService1 = new FlightsService();
        this.flightsService2 = new FlightsService();
        Flight flight1 = new Flight(1, "13/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        Flight flight2 = new Flight(2, "13/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        List<Flight> flightsList1 = new ArrayList<>();
        flightsList1.add(flight1);
        List<Flight> flightsList2 = new ArrayList<>();
        flightsList2.add(flight2);
        this.flightsService1.setAllFlights(flightsList1);
        this.flightsService2.setAllFlights(flightsList2);
    }

    @Test
    void getAllFlights() {
        assertNotEquals(flightsService1.getAllFlights(), flightsService2.getAllFlights());
    }

    @Test
    void setAllFlights() {
        assertNotEquals(flightsService1.getAllFlights(), flightsService2.getAllFlights());
    }

    @Test
    void getAllFlightsSorted() {
        flightsService1.getAllFlightsSorted();
        assertEquals(flightsService1.getFlightById(1).getId() - 1, 0);
    }

    @Test
    void getFlightById() {
        assertNotNull(flightsService1.getFlightById(1));
    }

    @Test
    void deleteFlightById() {
        assertTrue(flightsService1.deleteFlightById(1));
        assertFalse(flightsService2.deleteFlightById(1));
    }

    @Test
    void findReqFlights() {
        assertTrue(flightsService1.findReqFlights("Kyiv", "Kharkiv", "13/02/2024", 1));
        assertFalse(flightsService2.findReqFlights("Kyiv", "Kharkiv", "13/02/2024", 1000));
    }

    @Test
    void boughtTicket() {
        flightsService1.boughtTicket(1, 4);
        assertNotEquals(flightsService1.getFlightById(1).getFreeSeats(), 200);
        assertEquals(flightsService1.getFlightById(1).getFreeSeats(), 196);
    }

    @Test
    void returnTicket() {
        flightsService1.boughtTicket(1, 4);
        flightsService1.returnTicket(1, 1);
        assertNotEquals(flightsService1.getFlightById(1).getFreeSeats(), 196);
        assertEquals(flightsService1.getFlightById(1).getFreeSeats(), 197);
    }
}