package org.aviasales;

import java.io.Serializable;
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

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", flight=" + flight +
                ", humans=" + humans +
                '}';
    }
}
