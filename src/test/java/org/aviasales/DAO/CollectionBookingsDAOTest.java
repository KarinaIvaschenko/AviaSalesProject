package org.aviasales.DAO;

import org.aviasales.Booking;
import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Aviacompanies;
import org.aviasales.Enums.Cities;
import org.aviasales.Flight;
import org.aviasales.Human;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class CollectionBookingsDAOTest {

    @Test
    void getAllBookings() {
        CollectionBookingsDAO collectionBookingsDAO1 = new CollectionBookingsDAO();
        CollectionBookingsDAO collectionBookingsDAO2 = new CollectionBookingsDAO();
        Set<Human> humans = new HashSet<>();
        Flight flight = new Flight(1, "16/02/2024", "14:30", Cities.Dnipro, Cities.Kharkiv, 101, Aircrafts.Boeing_777, 10, Aviacompanies.British_Airways);
        Booking booking = new Booking(1, flight, humans);
        collectionBookingsDAO1.saveBooking(booking);
        assertNotEquals(collectionBookingsDAO1.getAllBookings(), collectionBookingsDAO2.getAllBookings());
    }

    @Test
    void setAllBookings() {
        CollectionBookingsDAO collectionBookingsDAO1 = new CollectionBookingsDAO();
        CollectionBookingsDAO collectionBookingsDAO2 = new CollectionBookingsDAO();
        List<Booking> list = new ArrayList<>();
        Set<Human> humans = new HashSet<>();
        Flight flight = new Flight(1, "16/02/2024", "14:30", Cities.Dnipro, Cities.Kharkiv, 101, Aircrafts.Boeing_777, 10, Aviacompanies.British_Airways);
        Booking booking = new Booking(1, flight, humans);
        list.add(booking);
        collectionBookingsDAO1.setAllBookings(list);
        assertNotEquals(collectionBookingsDAO1, collectionBookingsDAO2);
    }

    @Test
    void getBookingById() {
        CollectionBookingsDAO collectionBookingsDAO = new CollectionBookingsDAO();
        Flight flight = new Flight(1, "16/02/2024", "14:30", Cities.Dnipro, Cities.Kharkiv, 101, Aircrafts.Boeing_777, 10, Aviacompanies.British_Airways);
        Set<Human> humans = new HashSet<>();
        Booking booking = new Booking(1, flight, humans);
        collectionBookingsDAO.saveBooking(booking);
        assertNotNull(collectionBookingsDAO.getBookingById(1));
    }

    @Test
    void deleteBookingById() {
        CollectionBookingsDAO collectionBookingsDAO = new CollectionBookingsDAO();
        Flight flight = new Flight(1, "16/02/2024", "14:30", Cities.Dnipro, Cities.Kharkiv, 101, Aircrafts.Boeing_777, 10, Aviacompanies.British_Airways);
        Set<Human> humans = new HashSet<>();
        Booking booking = new Booking(1, flight, humans);
        collectionBookingsDAO.saveBooking(booking);
        assertTrue(collectionBookingsDAO.deleteBookingById(1));
        assertFalse(collectionBookingsDAO.deleteBookingById(1));
    }

    @Test
    void saveBooking() {
        CollectionBookingsDAO collectionBookingsDAO1 = new CollectionBookingsDAO();
        CollectionBookingsDAO collectionBookingsDAO2 = new CollectionBookingsDAO();
        Flight flight = new Flight(1, "16/02/2024", "14:30", Cities.Dnipro, Cities.Kharkiv, 101, Aircrafts.Boeing_777, 10, Aviacompanies.British_Airways);
        Set<Human> humans = new HashSet<>();
        Booking booking = new Booking(1, flight, humans);
        collectionBookingsDAO1.saveBooking(booking);
        assertNotEquals(collectionBookingsDAO1, collectionBookingsDAO2);
    }

    @Test
    void generateID() {
        CollectionBookingsDAO collectionBookingsDAO = new CollectionBookingsDAO();
        Flight flight = new Flight(1, "16/02/2024", "14:30", Cities.Dnipro, Cities.Kharkiv, 101, Aircrafts.Boeing_777, 10, Aviacompanies.British_Airways);
        Set<Human> humans = new HashSet<>();
        Booking booking = new Booking(collectionBookingsDAO.generateID(), flight, humans);
        collectionBookingsDAO.saveBooking(booking);
        assertEquals(1, collectionBookingsDAO.getBookingById(1).getBookingId());
    }
}