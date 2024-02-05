package org.aviasales;

import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Cities;

public class Flight {
    private int id;
    private String date;
    private String time;
    private Cities arrival;
    private Cities departure;
    private int freeSeats;
    private Aircrafts aircraft;
    private int passengers;

    public Flight(int id, String date, String time, Cities arrival, Cities departure, int freeSeats, Aircrafts aircraft, int passengers) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.arrival = arrival;
        this.departure = departure;
        this.freeSeats = freeSeats;
        this.aircraft = aircraft;
        this.passengers = passengers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Cities getArrival() {
        return arrival;
    }

    public void setArrival(Cities arrival) {
        this.arrival = arrival;
    }

    public Cities getDeparture() {
        return departure;
    }

    public void setDeparture(Cities departure) {
        this.departure = departure;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public Aircrafts getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircrafts aircraft) {
        this.aircraft = aircraft;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
