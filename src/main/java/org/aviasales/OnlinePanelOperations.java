package org.aviasales;

import org.aviasales.Controllers.FlightsController;

import java.util.Scanner;

public class OnlinePanelOperations {
    public static void chooseMenu() {
        Scanner in = new Scanner(System.in);
        FlightsController flightsController = new FlightsController();
        RandomGenerator randomGenerator = new RandomGenerator();
        flightsController.setAllFlights(randomGenerator.randomGenerator());
        FileManager.writeData(flightsController.getAllFlights());
        OnlinePanel.showOnlinePanel();
        while (true) {
            String menuItem = in.nextLine();
            switch (menuItem) {
                case "1":
                    System.out.println(flightsController.getAllFlights());
                    OnlinePanelOperations.chooseMenu();
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "exit":
                default:
            }
        }
    }


}
