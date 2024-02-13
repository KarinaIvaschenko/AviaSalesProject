package org.aviasales.Services;

import org.apache.logging.log4j.LogManager;
import org.aviasales.Booking;
import org.aviasales.DAO.CollectionBookingsDAO;
import org.aviasales.Human;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;

public class BookingsService {
    private final CollectionBookingsDAO collectionBookingsDAO = new CollectionBookingsDAO();
    private static final Logger logger = LogManager.getLogger(BookingsService.class);

    public List<Booking> getAllBookings() {
        logger.info("loading all bookings");
        return collectionBookingsDAO.getAllBookings();
    }

    public void setAllBookings(List<Booking> bookings) {
        collectionBookingsDAO.setAllBookings(bookings);
    }


    //    public void displayAllFlights() {
//        Flight.generalInformationPrettyFormat();
//        if (!getAllFlights().isEmpty()) {
//            collectionFlightsDAO.getAllFlights().forEach(flight -> System.out.println(flight.prettyFormat()));
//        } else {
//            System.out.println("No flights");
//        }
//    }
    public Booking getBookingById(int id) {
        try {
            return collectionBookingsDAO.getBookingById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean deleteBookingById(int id) {
        try {
            return collectionBookingsDAO.deleteBookingById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public void saveBooking(Booking booking) {
        try {
            collectionBookingsDAO.saveBooking(booking);
        } catch (Exception e) {
            throw e;
        }
    }

    public int generateID() {
        return collectionBookingsDAO.generateID();
    }

    public List<Booking> getBookingsByHuman(String name, String surname) {
        List<Booking> bookingsHuman = new ArrayList<>();
        for (Booking booking : collectionBookingsDAO.getAllBookings()) {
            for (Human human : booking.getHumans()) {
                if (human.getName().equals(name) && human.getSurname().equals(surname)) {
                    bookingsHuman.add(booking);
                }
            }
        }
        return bookingsHuman;
    }
}