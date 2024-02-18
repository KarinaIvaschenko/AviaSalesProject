package org.aviasales.Services;

import org.aviasales.DAO.CollectionBookingsDAO;
import org.aviasales.Entity.Booking;
import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Aviacompanies;
import org.aviasales.Enums.Cities;
import org.aviasales.Entity.Flight;
import org.aviasales.Entity.Human;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

class BookingsServiceTest {
    private BookingsService bookingsService1;
    private BookingsService bookingsService2;

    @BeforeEach
    void init() {
        this.bookingsService1 = new BookingsService(new CollectionBookingsDAO());
        this.bookingsService2 = new BookingsService(new CollectionBookingsDAO());
        Flight flight1 = new Flight(1, "13/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        Flight flight2 = new Flight(2, "13/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        Set<Human> humans = new HashSet<>();
        Human human1 = new Human("Kar", "Ivaschenko", "woman");
        humans.add(human1);
        Booking booking1 = new Booking(bookingsService1.generateID(), flight1, humans);
        List<Booking> bookings1 = new ArrayList<>();
        bookings1.add(booking1);
        Booking booking2 = new Booking(bookingsService2.generateID(), flight2, humans);
        List<Booking> bookings2 = new ArrayList<>();
        bookings2.add(booking2);
        bookingsService1.setAllBookings(bookings1);
        bookingsService2.setAllBookings(bookings2);
    }

    @Test
    void getAllBookings() {
        assertNotEquals(bookingsService1.getAllBookings(), bookingsService2.getAllBookings());
    }

    @Test
    void setAllBookings() {
        assertNotEquals(bookingsService1.getAllBookings(), bookingsService2.getAllBookings());
    }

    @Test
    void getBookingById() {
        assertNotNull(bookingsService1.getBookingById(1));
    }

    @Test
    void deleteBookingById() {
        assertTrue(bookingsService1.deleteBookingById(1));
        assertFalse(bookingsService2.deleteBookingById(2));
    }

    @Test
    void saveBooking() {
        BookingsService bookingsService3 = new BookingsService(new CollectionBookingsDAO());
        Set<Human> humans = new HashSet<>();
        Flight flight1 = new Flight(1, "13/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 200, Aircrafts.Boeing_777, 150, Aviacompanies.Airbaltic);
        Human human1 = new Human("Kar", "Ivaschenko", "woman");
        humans.add(human1);
        Booking booking1 = new Booking(bookingsService1.generateID(), flight1, humans);
        bookingsService3.saveBooking(booking1);
        assertNotEquals(bookingsService1, bookingsService3);
    }

    @Test
    void generateID() {
        assertEquals(1, bookingsService1.getBookingById(1).getBookingId());
    }

    @Test
    void getBookingsByHuman() {
        assertEquals(1, bookingsService1.getBookingsByHuman("Kar", "Ivaschenko").size());
        assertNotEquals(2, bookingsService1.getBookingsByHuman("Kar", "Ivaschenko").size());
    }
}