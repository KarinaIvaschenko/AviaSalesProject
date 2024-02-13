package org.aviasales.DAO;

import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Aviacompanies;
import org.aviasales.Enums.Cities;
import org.aviasales.Flight;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class CollectionFlightsDAOTest {

    @Test
    void getAllFlights() {
        CollectionFlightsDAO collectionFlightsDAO1 = new CollectionFlightsDAO();
        CollectionFlightsDAO collectionFlightsDAO2 = new CollectionFlightsDAO();
        Flight flight1 = new Flight(1, "2024-02-13", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);Flight flight2 = new Flight(2, "2024-02-14", "15:45", Cities.Dnipro, Cities.Lviv, 180, Aircrafts.Boeing_747_800, 120, Aviacompanies.Alitalia);
        collectionFlightsDAO1.saveFlight(flight1);
        assertNotEquals(collectionFlightsDAO1.getAllFlights(), collectionFlightsDAO2.getAllFlights());
    }

    @Test
    void setAllFlights() {
        CollectionFlightsDAO collectionFlightsDAO1 = new CollectionFlightsDAO();
        CollectionFlightsDAO collectionFlightsDAO2 = new CollectionFlightsDAO();
        List<Flight> list = new ArrayList<>();
        Flight flight1 = new Flight(1, "2024-02-13", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);Flight flight2 = new Flight(2, "2024-02-14", "15:45", Cities.Dnipro, Cities.Lviv, 180, Aircrafts.Boeing_747_800, 120, Aviacompanies.Alitalia);
        list.add(flight1);
        collectionFlightsDAO1.setAllFlights(list);
        assertNotEquals(collectionFlightsDAO1.getAllFlights(), collectionFlightsDAO2.getAllFlights());
    }

    @Test
    void getFlightById() {
        CollectionFlightsDAO collectionFlightsDAO = new CollectionFlightsDAO();
        Flight flight = new Flight(1, "2024-02-13", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);Flight flight2 = new Flight(2, "2024-02-14", "15:45", Cities.Dnipro, Cities.Lviv, 180, Aircrafts.Boeing_747_800, 120, Aviacompanies.Alitalia);
        collectionFlightsDAO.saveFlight(flight);
        assertNotNull(collectionFlightsDAO.getFlightById(1));
    }

    @Test
    void deleteFlightById() {
        CollectionFlightsDAO collectionFlightsDAO = new CollectionFlightsDAO();
        Flight flight = new Flight(1, "2024-02-13", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);Flight flight2 = new Flight(2, "2024-02-14", "15:45", Cities.Dnipro, Cities.Lviv, 180, Aircrafts.Boeing_747_800, 120, Aviacompanies.Alitalia);
        collectionFlightsDAO.saveFlight(flight);
        assertTrue(collectionFlightsDAO.deleteFlightById(1));
        assertFalse(collectionFlightsDAO.deleteFlightById(1));
    }

    @Test
    void saveFlight() {
        CollectionFlightsDAO collectionFlightsDAO1 = new CollectionFlightsDAO();
        CollectionFlightsDAO collectionFlightsDAO2 = new CollectionFlightsDAO();
        Flight flight = new Flight(1, "2024-02-13", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);Flight flight2 = new Flight(2, "2024-02-14", "15:45", Cities.Dnipro, Cities.Lviv, 180, Aircrafts.Boeing_747_800, 120, Aviacompanies.Alitalia);
        collectionFlightsDAO1.saveFlight(flight);
        assertNotEquals(collectionFlightsDAO1,collectionFlightsDAO2);
    }
}