package org.aviasales.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Booking implements Serializable {
    private int bookingId;
    private Flight flight;
    private Set<Human> humans;

    public Booking(int bookingId, Flight flight, Set<Human> humans) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.humans = humans;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Set<Human> getHumans() {
        return humans;
    }

    public void setHumans(Set<Human> humans) {
        this.humans = humans;
    }

    public static String prettyFormat(List<Booking> bookings) {
        StringBuilder formattedBookings = new StringBuilder();
        formattedBookings.append("Your bookings:\n");
        for (Booking booking : bookings) {
            formattedBookings.append("\tBookingId=").append(booking.getBookingId()).append("\n");
            formattedBookings.append("\tflight=").append(booking.getFlight()).append("\n");
            formattedBookings.append("\thumans=").append(booking.getHumans()).append("\n");
        }
        return formattedBookings.toString();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", flight=" + flight +
                ", humans=" + humans +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId &&
                Objects.equals(flight, booking.flight) &&
                Objects.equals(humans, booking.humans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, flight, humans);
    }
}