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

    //    public void displayAllFlightsFor24Hours() throws ParseException {
//        Flight.generalInformationPrettyFormat();
//        if (!getAllFlights().isEmpty()){
//            LocalDateTime nowTime = LocalDateTime.now();
//            for (Flight flight : collectionFlightsDAO.getAllFlights()) {
//                Date date = new SimpleDateFormat("d/M/y H:m").parse(flight.getDate()+ " "+ flight.getTime());
//                System.out.println(date);
//            }
//        }
//    }
    public void displayAllFlightsFor24Hours() throws ParseException {
        Flight.generalInformationPrettyFormat();
        if (!getAllFlights().isEmpty()) {
            Date currentDate = new Date(); // Получаем текущую дату и время

            for (Flight flight : collectionFlightsDAO.getAllFlights()) {
                Date flightDate = new SimpleDateFormat("d/M/y H:m").parse(flight.getDate() + " " + flight.getTime());
                long diffInMillies = Math.abs(flightDate.getTime() - currentDate.getTime());
                long diffInMinutes = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
                System.out.println("_______________");
                System.out.println(diffInMinutes);
                int last24hours = 24 * 60;
                System.out.println(last24hours);
                System.out.println("----------");
                if (diffInMinutes >= last24hours) {
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
