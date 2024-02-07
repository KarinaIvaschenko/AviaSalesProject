package org.aviasales;

import org.aviasales.Controllers.FlightsController;
import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Aviacompanies;
import org.aviasales.Enums.Cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    protected Random random = new Random();

    private String getRandomDate() {
        int day = random.nextInt(1, 32);
        int month = random.nextInt(1, 13);
        String dayString = (day >= 10) ? String.valueOf(day): "0" + day;
        String monthString = (month >= 10) ? String.valueOf(month): "0" + month;
        String year = "2024";
        return dayString + "/" + monthString + "/" + year;
    }

    private String getRandomTime() {
        int hours = random.nextInt(0, 24);
        int minutes = random.nextInt(0, 60);
        String hoursString = (hours >= 10) ? String.valueOf(hours): "0" + hours;
        String minutesString = (minutes >= 10) ? String.valueOf(minutes): "0" + minutes;
        return hoursString + ":" + minutesString;
    }

    private Cities getRandomCity() {
        Cities[] cities = Cities.values();
        int index = random.nextInt(cities.length);
        return cities[index];
    }

    private Aircrafts getRandomAircraft() {
        Aircrafts[] aircrafts = Aircrafts.values();
        int index = random.nextInt(aircrafts.length);
        return aircrafts[index];
    }

    private int getRandomFreeSeats() {
        return random.nextInt(0, 350);
    }

    private int getRandomPassengers() {
        return random.nextInt(0, getRandomFreeSeats() + 1);
    }
    private Aviacompanies getRandomAviacompanies() {
        Aviacompanies[] aviacompanies = Aviacompanies.values();
        int index = random.nextInt(aviacompanies.length);
        return aviacompanies[index];
    }

    public List<Flight> randomGenerator() {
        List<Flight> flights = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            Flight flight = new Flight(i, getRandomDate(), getRandomTime(), getRandomCity(), getRandomCity(),
                    getRandomFreeSeats(), getRandomAircraft(), getRandomPassengers(), getRandomAviacompanies());
            flights.add(flight);
        }
        return flights;
    }
}
