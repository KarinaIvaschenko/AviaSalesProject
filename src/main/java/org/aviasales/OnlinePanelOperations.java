package org.aviasales;

import org.aviasales.Controllers.FlightsController;
import org.aviasales.Services.FlightsService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OnlinePanelOperations {
    public void flightReqForCase3() {

    }

    public static void chooseMenu() throws ParseException {
        Scanner in = new Scanner(System.in);
        FlightsController flightsController = new FlightsController();
        flightsController.setAllFlights(FileManager.loadData());
//        RandomGenerator randomGenerator = new RandomGenerator();
//        FileManager.writeData(randomGenerator.randomGenerator());

        while (true) {
            OnlinePanel.showOnlinePanel();
            String menuItem = in.nextLine();
            switch (menuItem) {
                case "1":
                    flightsController.displayAllFlightsFor24Hours();
                    OnlinePanelOperations.chooseMenu();
                    break;
                case "2":
                    System.out.println("Enter please flight ID");
                    int menuItem2 = in.nextInt();
                    in.nextLine();
                    System.out.println(flightsController.getFlightById(menuItem2));
                    break;
                case "3":
                    System.out.println("Write please departure city");
                    String pointA = in.nextLine();
                    System.out.println("Write please destination city");
                    String pointB = in.nextLine();
                    System.out.println("Write please date");
                    System.out.println("Write please day");
                    String day = in.nextLine();
                    System.out.println("Write please month");
                    String month = in.nextLine();
                    System.out.println("Write please year");
                    String year = in.nextLine();
                    String date = day + "/" + month + "/" + year;
                    System.out.println("Write please passengers quantity");
                    int passengers = in.nextInt();
                    in.nextLine();
                    boolean flightsFound = flightsController.findReqFlights(pointA, pointB, date, passengers);
                    if (flightsFound) {
                        System.out.println("Please enter the flight ID or enter '0' to return to the previous menu");
                        int choice = in.nextInt();
                        in.nextLine();
                        if (choice == 0) {
                            break;
                        } else {
                            System.out.println("Loading information for flight ID " + choice);

                            System.out.println(flightsController.getFlightById(choice));
                            System.out.println("Would you like to make a reservation? Yes/No");
                            String reservation = in.nextLine().toLowerCase();
                            if (reservation.equals("yes")) {
                                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            } else {
                                break;
                            }
                        }
                    } else {
                        System.out.println("No flights for request params");
                        break;
                    }
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
