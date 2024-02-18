package org.aviasales.DAO;

import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Aviacompanies;
import org.aviasales.Enums.Cities;
import org.aviasales.Entity.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class CollectionFlightsDAOTest {
    private CollectionFlightsDAO collectionFlightsDAO1;
    private CollectionFlightsDAO collectionFlightsDAO2;
    private Flight flight;

    @BeforeEach
    void init() {
        this.collectionFlightsDAO1 = new CollectionFlightsDAO();
        this.collectionFlightsDAO2 = new CollectionFlightsDAO();
        this.flight = new Flight(1, "16/02/2024", "14:30", Cities.Dnipro, Cities.Kharkiv, 101, Aircrafts.Boeing_777, 10, Aviacompanies.British_Airways);
        collectionFlightsDAO1.saveFlight(flight);
    }

    @org.junit.jupiter.api.Test
    void getAllFlights() {
        assertNotEquals(collectionFlightsDAO1.getAllFlights(), collectionFlightsDAO2.getAllFlights());
    }

    @Test
    void setAllFlights() {
        List<Flight> list = new ArrayList<>();
        list.add(flight);
        collectionFlightsDAO1.setAllFlights(list);
        assertNotEquals(collectionFlightsDAO1.getAllFlights(), collectionFlightsDAO2.getAllFlights());
    }

    @Test
    void getFlightById() {
        assertNotNull(collectionFlightsDAO1.getFlightById(1));
    }

    @Test
    void deleteFlightById() {
        assertTrue(collectionFlightsDAO1.deleteFlightById(1));
        assertFalse(collectionFlightsDAO1.deleteFlightById(1));
    }

    @Test
    void saveFlight() {
        assertNotEquals(collectionFlightsDAO1,collectionFlightsDAO2);
    }
}