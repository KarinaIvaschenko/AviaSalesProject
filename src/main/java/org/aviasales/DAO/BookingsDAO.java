package org.aviasales.DAO;

import org.aviasales.Booking;

import java.util.List;

public interface BookingsDAO {
    List<Booking> getAllBookings();

    void setAllBookings(List<Booking> bookings);

    Booking getBookingById(int id);

    boolean deleteBookingById(int id);

    void saveBooking(Booking booking);
}
