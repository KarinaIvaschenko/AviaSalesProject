package org.aviasales.Services;

import org.aviasales.Booking;
import org.aviasales.DAO.CollectionBookingsDAO;

import java.util.List;

public class BookingsService {
    private final CollectionBookingsDAO collectionBookingsDAO = new CollectionBookingsDAO();

    public List<Booking> getAllBookings() {
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
}