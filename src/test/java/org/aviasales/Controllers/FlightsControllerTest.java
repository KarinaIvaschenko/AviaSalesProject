package org.aviasales.Controllers;

import org.aviasales.DAO.CollectionFlightsDAO;
import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Aviacompanies;
import org.aviasales.Enums.Cities;
import org.aviasales.Entity.Flight;
import org.aviasales.Services.FlightsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class FlightsControllerTest {
    private FlightsController flightsController1;
    private FlightsController flightsController2;

    @BeforeEach
    void init() {
        this.flightsController1 = new FlightsController(new FlightsService(new CollectionFlightsDAO()));
        this.flightsController2 = new FlightsController(new FlightsService(new CollectionFlightsDAO()));
        Flight flight1 = new Flight(1, "13/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        Flight flight2 = new Flight(2, "13/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        List<Flight> flightsList1 = new ArrayList<>();
        flightsList1.add(flight1);
        List<Flight> flightsList2 = new ArrayList<>();
        flightsList2.add(flight2);
        this.flightsController1.setAllFlights(flightsList1);
        this.flightsController2.setAllFlights(flightsList2);
    }

    @Test
    void getAllFlights() {
        assertNotEquals(flightsController1.getAllFlights(), flightsController2.getAllFlights());
    }

    @Test
    void setAllFlights() {
        assertNotEquals(flightsController1.getAllFlights(), flightsController2.getAllFlights());
    }

    @Test
    void getFlightById() {
        assertNotNull(flightsController1.getFlightById(1));
    }

    @Test
    void deleteFlightById(){
        assertTrue(flightsController1.deleteFlightById(1));
        assertFalse(flightsController2.deleteFlightById(1));
    }

    @Test
    void findReqFlights() {
        assertTrue(flightsController1.findReqFlights("Kyiv", "Kharkiv", "13/02/2024", 1));
        assertFalse(flightsController2.findReqFlights("Kyiv", "Kharkiv", "13/02/2024", 1000));

    }

    @Test
    void boughtTicket() {
        flightsController1.boughtTicket(1, 4);
        assertNotEquals(flightsController1.getFlightById(1).getFreeSeats(), 200);
        assertEquals(flightsController1.getFlightById(1).getFreeSeats(), 196);
    }

    @Test
    void returnTicket() {
        flightsController1.boughtTicket(1, 4);
        flightsController1.returnTicket(1, 1);
        assertNotEquals(flightsController1.getFlightById(1).getFreeSeats(), 196);
        assertEquals(flightsController1.getFlightById(1).getFreeSeats(), 197);
    }
}