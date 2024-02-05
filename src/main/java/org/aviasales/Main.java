package org.aviasales;

import org.aviasales.DAO.CollectionFlightsDAO;
import org.aviasales.Enums.Aircrafts;
import org.aviasales.Enums.Cities;

public class Main {
    public static void main(String[] args) {
        OnlinePanel.showOnlinePanel();
        CollectionFlightsDAO flightsDAO = new CollectionFlightsDAO();
        Flight flight1 = new Flight(1, "01/02/2024", "10:30", Cities.Kyiv, Cities.Berdychiv, 305, Aircrafts.Boeing_777, 100);
        Flight flight2 = new Flight(2, "01/02/2024", "12:30", Cities.Kyiv, Cities.Dnipro, 189, Aircrafts.Boeing_737_800, 100);
        Flight flight3 = new Flight(3, "01/02/2024", "14:30", Cities.Kyiv, Cities.Kharkiv, 280, Aircrafts.Airbus_310, 100);
        Flight flight4 = new Flight(3, "01/02/2024", "14:30", Cities.Kyiv, Cities.Lviv, 268, Aircrafts.Airbus_330, 100);


        flightsDAO.saveFlight(flight1);
    }
}