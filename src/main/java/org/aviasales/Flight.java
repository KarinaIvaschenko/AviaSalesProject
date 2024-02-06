package org.aviasales;

import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Cities;

import java.io.Serializable;

public class Flight implements Serializable {
    private int id;
    private String date;
    private String time;
    private Cities departureCity;
    private Cities destinationCity;
    private int freeSeats;
    private Aircrafts aircraft;
    private int passengers;

    public Flight(int id, String date, String time, Cities departureCity, Cities destinationCity, int freeSeats, Aircrafts aircraft, int passengers) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
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

    public Cities getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(Cities departureCity) {
        this.departureCity = departureCity;
    }

    public Cities getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(Cities destinationCity) {
        this.destinationCity = destinationCity;
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

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", departureCity=" + departureCity +
                ", destinationCity=" + destinationCity +
                ", freeSeats=" + freeSeats +
                ", aircraft=" + aircraft +
                ", passengers=" + passengers +
                '}';
    }
}
