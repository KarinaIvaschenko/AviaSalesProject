package org.aviasales.Controllers;

import org.aviasales.Booking;
import org.aviasales.Services.BookingsService;

import java.util.List;

public class BookingsController {
    BookingsService bookingsService;
    public BookingsController() {
        this.bookingsService = new BookingsService();
    }

    public List<Booking> getAllBookings() {
        return bookingsService.getAllBookings();
    }

    public void setAllBookings(List<Booking> bookings) {
        bookingsService.setAllBookings(bookings);
    }

//    public void displayAllBookings() {
//        bookingsService.displayAllBookings();
//    }

    public Booking getBookingById(int id) {
        return bookingsService.getBookingById(id);
    }


}
