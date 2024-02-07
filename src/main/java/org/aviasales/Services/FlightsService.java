package org.aviasales.Services;

import org.aviasales.DAO.CollectionFlightsDAO;
import org.aviasales.Flight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightsService {
    private final CollectionFlightsDAO collectionFlightsDAO = new CollectionFlightsDAO();

    public List<Flight> getAllFlights() {
        return collectionFlightsDAO.getAllFlights();
    }

    public void setAllFlights(List<Flight> flights) {
        collectionFlightsDAO.setAllFlights(flights);
    }

    public void displayAllFlights() {
        Flight.generalInformationPrettyFormat();
        if (!getAllFlights().isEmpty()) {
            collectionFlightsDAO.getAllFlights().forEach(flight -> System.out.println(flight.prettyFormat()));
        } else {
            System.out.println("No flights");
        }
    }

    public void displayAllFlightsFor24Hours() throws ParseException {
        Flight.generalInformationPrettyFormat();
        if (!getAllFlights().isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
               for (Flight flight : collectionFlightsDAO.getAllFlights()) {
                Date flightDate = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(flight.getDate() + " " + flight.getTime());
                long unixTimestamp = flightDate.getTime();
                long hours24InMillis = 24 * 60 * 60 * 1000;
                if (unixTimestamp >= currentTimeMillis && unixTimestamp - currentTimeMillis < hours24InMillis) {
                    System.out.println(flight.prettyFormat());
                }
            }
        } else {
            System.out.println("No flights");
        }
    }

    public Flight getFlightById(int id) {
        return collectionFlightsDAO.getFlightById(id);
    }
}
