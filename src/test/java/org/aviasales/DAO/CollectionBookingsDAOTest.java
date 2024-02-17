package org.aviasales.DAO;

import org.aviasales.Booking;
import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Aviacompanies;
import org.aviasales.Enums.Cities;
import org.aviasales.Flight;
import org.aviasales.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class CollectionBookingsDAOTest {
    private CollectionBookingsDAO collectionBookingsDAO1;
    private CollectionBookingsDAO collectionBookingsDAO2;
    private Booking booking;

    @BeforeEach
    void init() {
        this.collectionBookingsDAO1 = new CollectionBookingsDAO();
        this.collectionBookingsDAO2 = new CollectionBookingsDAO();
        Flight flight = new Flight(1, "16/02/2024", "14:30", Cities.Dnipro, Cities.Kharkiv, 101, Aircrafts.Boeing_777, 10, Aviacompanies.British_Airways);
        Set<Human> humans = new HashSet<>();
        this.booking = new Booking(collectionBookingsDAO1.generateID(), flight, humans);
        collectionBookingsDAO1.saveBooking(booking);
    }


    @Test
    void getAllBookings() {
        assertNotEquals(collectionBookingsDAO1.getAllBookings(), collectionBookingsDAO2.getAllBookings());
    }

    @Test
    void setAllBookings() {
        List<Booking> list = new ArrayList<>();
        list.add(booking);
        collectionBookingsDAO1.setAllBookings(list);
        assertNotEquals(collectionBookingsDAO1, collectionBookingsDAO2);
    }

    @Test
    void getBookingById() {
        assertNotNull(collectionBookingsDAO1.getBookingById(1));
    }

    @Test
    void deleteBookingById() {
        assertTrue(collectionBookingsDAO1.deleteBookingById(1));
        assertFalse(collectionBookingsDAO1.deleteBookingById(1));
    }

    @Test
    void saveBooking() {
        assertNotEquals(collectionBookingsDAO1, collectionBookingsDAO2);
    }

    @Test
    void generateID() {
        assertEquals(1, collectionBookingsDAO1.getBookingById(1).getBookingId());
    }
}