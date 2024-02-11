package org.aviasales;

import org.aviasales.Controllers.BookingsController;
import org.aviasales.Controllers.CustomersController;
import org.aviasales.Controllers.FlightsController;
import org.aviasales.Services.FlightsService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OnlinePanelOperations {
    public static void chooseMenu() throws ParseException, IOException {
        Scanner in = new Scanner(System.in);
        FlightsController flightsController = new FlightsController();
        BookingsController bookingsController = new BookingsController();
        CustomersController customersController = new CustomersController();
        flightsController.setAllFlights(FileManager.loadFlightsData());
        bookingsController.setAllBookings(FileManager.loadBookingsData());
        customersController.setAllCustomers(FileManager.loadCustomersData());
//        RandomGenerator randomGenerator = new RandomGenerator();
//        FileManager.writeData(randomGenerator.randomGenerator());
        String incorrectInput = "Incorrect input. Make right choice";

        while (true) {
            System.out.println("1. Sign in\n2. Sign up\n3. Continue without authorization");
            String menuCustomer = in.nextLine();
            switch (menuCustomer) {
                case "1":
                    System.out.println("Write please Login");
                    String loginCustomer = in.nextLine();
                    System.out.println("Write please password");
                    String passwordCustomer = in.nextLine();
                    customersController.signIn(loginCustomer, passwordCustomer);
                    if (customersController.signIn(loginCustomer, passwordCustomer) != null) {
                        System.out.println("Welcome back, " + loginCustomer);
                        break;
                    } else {
                        System.out.println("Incorrect login or password");
                        continue;
                    }
                case "2":
                    System.out.println("Write please Name");
                    String name = in.nextLine().toLowerCase();
                    System.out.println("Write please Surname");
                    String surname = in.nextLine().toLowerCase();
                    System.out.println("Write please Gender. Man/Woman");
                    String gender = in.nextLine().toLowerCase();
                    while (!(gender.equals("man") || gender.equals("woman"))) {
                        System.out.println("Write please Gender. Man/Woman");
                        gender = in.nextLine().toLowerCase();
                    }
                    System.out.println("Write please Login");
                    String login = in.nextLine();
                    System.out.println("Write please password");
                    String password = in.nextLine();
                    Customer customer = new Customer(customersController.generateID(), name, surname, gender, login, password);
                    customersController.signUp(customer);
                    FileManager.writeCustomersData(customersController.getAllCustomers());
                    System.out.println("Thank you for registration");
                    continue;
                case "3":
                    break;
                default:
                    System.out.println(incorrectInput);
            }
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
                                Set<Human> humans = new LinkedHashSet<>();
                                int counter = 0;
                                while (!(passengers == 0)) {
                                    counter++;
                                    System.out.println("Write please information about passenger №" + counter);
                                    System.out.println("Write please Name");
                                    String name = in.nextLine().toLowerCase();
                                    System.out.println("Write please Surname");
                                    String surname = in.nextLine().toLowerCase();
                                    System.out.println("Write please Gender. Man/Woman");
                                    String gender = in.nextLine().toLowerCase();
                                    while (!(gender.equals("man") || gender.equals("woman"))) {
                                        System.out.println("Write please Gender. Man/Woman");
                                        gender = in.nextLine().toLowerCase();
                                    }

                                    Human human = new Human(name, surname, gender);
                                    humans.add(human);

                                    passengers--;
                                }
                                Booking booking = new Booking(bookingsController.generateID(), flightsController.getFlightById(choice), humans);
                                bookingsController.saveBooking(booking);
                                System.out.println("You have successfully booked tickets");
                                break;

                            } else {
                                break;
                            }
                        }
                    } else {
                        System.out.println("No flights for request params");
                        break;
                    }
                case "4":
                    System.out.println("Enter please booking ID you would like to cancel");
                    int idBooking = in.nextInt();
                    in.nextLine();
                    if (bookingsController.getBookingById(idBooking) != null) {
                        bookingsController.deleteBookingById(idBooking);
                        System.out.println("Your reservation №" + idBooking + " was successfully cancelled");
                    } else {
                        System.out.println("There is no reservation with id" + idBooking);
                    }
                    break;
                case "5":
                    System.out.println("Write please information about passenger");
                    System.out.println("Write please Name");
                    String name = in.nextLine().toLowerCase();
                    System.out.println("Write please Surname");
                    String surname = in.nextLine().toLowerCase();
                    if (!bookingsController.getBookingsByHuman(name, surname).isEmpty()) {
                        System.out.println(bookingsController.getBookingsByHuman(name, surname));
                    } else {
                        System.out.println("This passenger has no bookings");
                    }
                    break;
                case "6":
                case "exit":
                    FileManager.writeFlightsData(flightsController.getAllFlights());
                    FileManager.writeBookingsData(bookingsController.getAllBookings());
                    System.out.println("Thanks for choosing us!");
                    return;

                default:
                    System.out.println(incorrectInput);
            }
        }
    }
}
