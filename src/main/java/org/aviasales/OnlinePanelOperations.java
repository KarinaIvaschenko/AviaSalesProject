package org.aviasales;

import org.aviasales.Controllers.FlightsController;
import org.aviasales.Services.FlightsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OnlinePanelOperations {
    public static void chooseMenu() throws ParseException {
        Scanner in = new Scanner(System.in);
        FlightsController flightsController = new FlightsController();
        flightsController.setAllFlights(FileManager.loadData());
//        RandomGenerator randomGenerator = new RandomGenerator();
//        FileManager.writeData(randomGenerator.randomGenerator());
        OnlinePanel.showOnlinePanel();
        System.out.println("Make your choice");
        while (true) {
            String menuItem = in.nextLine();
            switch (menuItem) {
                case "1":
                    flightsController.displayAllFlightsFor24Hours();
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
                    System.out.println("Write please departure city");
                    String pointA = in.nextLine();
                    System.out.println("Write please destination city");
                    String pointB = in.nextLine();
                    System.out.println("Write please date");
                    System.out.println("Year");
                    int year = in.nextInt();
                    in.nextLine();
                    System.out.println("Month");
                    int month = in.nextInt();
                    in.nextLine();
                    System.out.println("Day");
                    int day = in.nextInt();
                    in.nextLine();
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String formattedDate = dateFormat.format(date);
                    System.out.println(date);
                    System.out.println("Write please passengers quantity");
                    int passengers = in.nextInt();
                    in.nextLine();
                    flightsController.findReqFlights(pointA, pointB, formattedDate, passengers);
                    System.out.println("Would you like to make a reservation?");
                    OnlinePanelOperations.chooseMenu();
                    break;
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
