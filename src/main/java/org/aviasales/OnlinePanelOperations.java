package org.aviasales;

import org.aviasales.Controllers.FlightsController;

import java.util.Scanner;

public class OnlinePanelOperations {
    public static void chooseMenu() {
        Scanner in = new Scanner(System.in);
        FlightsController flightsController = new FlightsController();
        flightsController.setAllFlights(FileManager.loadData());
        OnlinePanel.showOnlinePanel();
        System.out.println("Make your choice");
        while (true) {
            String menuItem = in.nextLine();
            switch (menuItem) {
                case "1":
                    flightsController.displayAllFlights();
                    OnlinePanelOperations.chooseMenu();
                    break;
                case "2":
                    System.out.println("Enter please flight ID");
                    int menuItem2 = in.nextInt();
                    System.out.println(flightsController.getFlightById(menuItem2));
                    in.nextLine();
                    OnlinePanelOperations.chooseMenu();
                    break;
                case "3":
                case "4":
                case "5":
                case "6":
                case "exit":
                    FileManager.writeData(flightsController.getAllFlights());
                    return;

                default:
            }
        }
    }
}
