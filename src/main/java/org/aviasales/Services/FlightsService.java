package org.aviasales.Services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aviasales.DAO.CollectionFlightsDAO;
import org.aviasales.Flight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FlightsService {
    private final CollectionFlightsDAO collectionFlightsDAO = new CollectionFlightsDAO();
    private static final Logger logger = LogManager.getLogger(FlightsService.class);

    public List<Flight> getAllFlights() {
        logger.info("loading all flights");
        return collectionFlightsDAO.getAllFlights();
    }

    public void setAllFlights(List<Flight> flights) {
        logger.info("saving all flights");
        collectionFlightsDAO.setAllFlights(flights);
    }

    public List<Flight> getAllFlightsSorted() {
        logger.info("loading all flights");
        Collections.sort(collectionFlightsDAO.getAllFlights());
        return collectionFlightsDAO.getAllFlights();
    }

    public void displayAllFlights() {
        logger.info("display all flights");
        Flight.generalInformationPrettyFormat();
        if (!getAllFlights().isEmpty()) {
            collectionFlightsDAO.getAllFlights().forEach(flight -> System.out.println(flight.prettyFormat()));
        } else {
            System.out.println("No flights");
        }
    }

    public void displayAllFlightsFor24Hours() throws ParseException {
        logger.info("display flights for 24 hours");
        Flight.generalInformationPrettyFormat();
        if (!collectionFlightsDAO.getAllFlights().isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis();
            for (Flight flight : getAllFlightsSorted()) {
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
        logger.info("getting flight by id");
        try {
            return collectionFlightsDAO.getFlightById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean deleteFlightById(int id) {
        logger.info("deleting flight by id");
        try {
            return collectionFlightsDAO.deleteFlightById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean findReqFlights(String pointA, String pointB, String date, int passengers) {
        logger.info("finding flights for request params");
        boolean flightsFound = false;
        Flight.generalInformationPrettyFormat();
        if (!collectionFlightsDAO.getAllFlights().isEmpty()) {
            for (Flight flight : getAllFlightsSorted()) {
                if (String.valueOf(flight.getDepartureCity()).equals(pointA) &&
                        String.valueOf(flight.getDestinationCity()).equals(pointB) &&
                        flight.getDate().equals(date) &&
                        flight.getFreeSeats() >= passengers) {
                    System.out.println(flight.prettyFormat());
                    flightsFound = true;
                }
            }
        } else {
            System.out.println("No flights");
        }
        return flightsFound;
    }

    public void boughtTicket(int id, int tickets) {
        logger.info("selling ticket after flight booking");
        collectionFlightsDAO.getFlightById(id).setFreeSeats(collectionFlightsDAO.getFlightById(id)
                .getFreeSeats() - tickets);
        collectionFlightsDAO.saveFlight(collectionFlightsDAO.getFlightById(id));
    }

    public void returnTicket(int id, int tickets) {
        logger.info("adding ticket after flight cancel");
        collectionFlightsDAO.getFlightById(id).setFreeSeats(collectionFlightsDAO.getFlightById(id)
                .getFreeSeats() + tickets);
        collectionFlightsDAO.saveFlight(collectionFlightsDAO.getFlightById(id));
    }
}
