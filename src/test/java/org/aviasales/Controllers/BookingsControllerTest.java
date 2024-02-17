package org.aviasales.Controllers;

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

class BookingsControllerTest {
    private BookingsController bookingsController1;
    private BookingsController bookingsController2;

    @BeforeEach
    void init() {
        this.bookingsController1 = new BookingsController();
        this.bookingsController2 = new BookingsController();
        Flight flight1 = new Flight(1, "13/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        Flight flight2 = new Flight(2, "13/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        Set<Human> humans = new HashSet<>();
        Human human1 = new Human("Kar", "Ivaschenko", "woman");
        humans.add(human1);
        Booking booking1 = new Booking(bookingsController1.generateID(), flight1, humans);
        List<Booking> bookings1 = new ArrayList<>();
        bookings1.add(booking1);
        Booking booking2 = new Booking(bookingsController2.generateID(), flight2, humans);
        List<Booking> bookings2 = new ArrayList<>();
        bookings2.add(booking2);
        bookingsController1.setAllBookings(bookings1);
        bookingsController2.setAllBookings(bookings2);
    }

    @Test
    void getAllBookings() {
        assertNotEquals(bookingsController1.getAllBookings(), bookingsController2.getAllBookings());
    }

    @Test
    void setAllBookings() {
        assertNotEquals(bookingsController1.getAllBookings(), bookingsController2.getAllBookings());
    }

    @Test
    void getBookingById() {
        assertNotNull(bookingsController1.getBookingById(1));
    }

    @Test
    void saveBooking() {
        assertNotEquals(bookingsController1, bookingsController2);
    }

    @Test
    void generateID() {
        assertEquals(1, bookingsController1.getBookingById(1).getBookingId());
    }

    @Test
    void deleteBookingById() {
        assertTrue(bookingsController1.deleteBookingById(1));
        assertFalse(bookingsController2.deleteBookingById(2));
    }

    @Test
    void getBookingsByHuman() {
        assertEquals(1, bookingsController1.getBookingsByHuman("Kar", "Ivaschenko").size());
        assertNotEquals(2, bookingsController1.getBookingsByHuman("Kar", "Ivaschenko").size());
    }
}