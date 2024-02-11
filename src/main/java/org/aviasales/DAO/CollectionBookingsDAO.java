package org.aviasales.DAO;

import org.aviasales.Booking;

import java.util.ArrayList;
import java.util.List;

public class CollectionBookingsDAO implements BookingsDAO {
    private List<Booking> bookings;

    public CollectionBookingsDAO() {
        this.bookings = new ArrayList<>();
    }

    @Override
    public List<Booking> getAllBookings() {
        return this.bookings;
    }

    @Override
    public void setAllBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public Booking getBookingById(int id) {
        return this.bookings.stream()
                .filter(booking -> booking.getBookingId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean deleteBookingById(int id) {
        if (!this.bookings.isEmpty()) {
            return this.bookings.removeIf(booking -> booking.getBookingId() == id);
        }
        return false;
    }

    @Override
    public void saveBooking(Booking booking) {
        if (this.bookings.contains(booking)) {
            int index = bookings.indexOf(booking);
            this.bookings.set(index, booking);
        } else {
            this.bookings.add(booking);
        }
    }

    @Override
    public int generateID() {
        if (this.bookings.isEmpty()) {
            return 1;
        } else {
            return this.bookings.size() + 1;
        }
    }

//    @Override
//    public void saveBooking(Booking booking) {
//        try {
//            if (this.bookings.contains(booking)) {
//                int index = bookings.indexOf(booking);
//                this.bookings.set(index, booking);
//            } else {
//                bookings.add(booking);
//            }
//        } catch (Exception e) {
//            throw e;
//        }
//    }
}
