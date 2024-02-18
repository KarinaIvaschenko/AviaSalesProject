package org.aviasales.Services;

import org.apache.logging.log4j.LogManager;
import org.aviasales.Entity.Booking;
import org.aviasales.DAO.CollectionBookingsDAO;
import org.aviasales.Entity.Human;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;

import static org.aviasales.Entity.Booking.prettyFormat;

public class BookingsService {
    private final CollectionBookingsDAO collectionBookingsDAO;
    private static final Logger logger = LogManager.getLogger(BookingsService.class);
    public BookingsService(CollectionBookingsDAO collectionBookingsDAO) {
        this.collectionBookingsDAO = collectionBookingsDAO;
    }

    public List<Booking> getAllBookings() {
        logger.info("loading all bookings");
        return collectionBookingsDAO.getAllBookings();
    }

    public void setAllBookings(List<Booking> bookings) {
        logger.info("saving all bookings");
        collectionBookingsDAO.setAllBookings(bookings);
    }

    public Booking getBookingById(int id) {
        logger.info("getting booking by id");
        try {
            return collectionBookingsDAO.getBookingById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean deleteBookingById(int id) {
        logger.info("deleting booking by id");
        return collectionBookingsDAO.deleteBookingById(id);
    }

    public void saveBooking(Booking booking) {
        logger.info("saving booking");
        collectionBookingsDAO.saveBooking(booking);
    }

    public int generateID() {
        logger.info("generating booking's id");
        return collectionBookingsDAO.generateID();
    }

    public List<Booking> getBookingsByHuman(String name, String surname) {
        logger.info("searching booking by human's name and surname");
        List<Booking> bookingsHuman = new ArrayList<>();
        for (Booking booking : collectionBookingsDAO.getAllBookings()) {
            for (Human human : booking.getHumans()) {
                if (human.getName().equals(name) && human.getSurname().equals(surname)) {
                    bookingsHuman.add(booking);
                }
            }
        }
        System.out.println(prettyFormat(bookingsHuman));
        return bookingsHuman;
    }
}