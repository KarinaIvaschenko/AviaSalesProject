package org.aviasales;

import org.aviasales.Controllers.BookingsController;
import org.aviasales.Controllers.CustomersController;
import org.aviasales.Controllers.FlightsController;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class OnlinePanelOperations {
    FlightsController flightsController = new FlightsController();
    BookingsController bookingsController = new BookingsController();
    CustomersController customersController = new CustomersController();
    String incorrectInput = "Incorrect input. Make right choice";

    public void preload() {
        flightsController.setAllFlights(FileManager.loadFlightsData());
        bookingsController.setAllBookings(FileManager.loadBookingsData());
        customersController.setAllCustomers(FileManager.loadCustomersData());
        //        RandomGenerator randomGenerator = new RandomGenerator();
        //        FileManager.writeData(randomGenerator.randomGenerator());
    }

    public void authorization() throws IOException {
        Scanner in = new Scanner(System.in);
        preload();
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
            break;
        }
    }

    private void chooseMenuItem1() throws ParseException {
        flightsController.displayAllFlightsFor24Hours();
        OnlinePanel.showOnlinePanel();
    }

    private void chooseMenuItem2(Scanner in) {
        System.out.println("Enter please flight ID");
        while (!in.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer ID.");
            in.next();
        }
        int menuItem2 = in.nextInt();
        in.nextLine();
        System.out.println(flightsController.getFlightById(menuItem2));
    }

    private void chooseMenuItem3(Scanner in) {
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
            while (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer ID.");
                in.next();
            }
            int choice = in.nextInt();
            in.nextLine();
            if (choice == 0) {
                return;
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
                    return;

                } else {
                    return;
                }
            }
        } else {
            System.out.println("No flights for request params");
            return;
        }
    }

    private void chooseMenuItem4(Scanner in) {
        System.out.println("Enter please booking ID you would like to cancel");
        while (!in.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer ID.");
            in.next();
        }
        int idBooking = in.nextInt();
        in.nextLine();

        int flightID = bookingsController.getBookingById(idBooking).getFlight().getId();
        int tickets = bookingsController.getBookingById(idBooking).getHumans().size();
        System.out.println("УДАЛТЬ!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(bookingsController.getBookingById(idBooking).getFlight().getFreeSeats());
        flightsController.returnTicket(flightID, tickets);
        System.out.println(bookingsController.getBookingById(idBooking).getFlight().getFreeSeats());
        System.out.println("УДАЛТЬ!!!!!!!!!!!!!!!!!!!!!!!!");
        if (bookingsController.getBookingById(idBooking) != null) {
            bookingsController.deleteBookingById(idBooking);
            flightsController.returnTicket(flightID, tickets);
            System.out.println("Your reservation №" + idBooking + " was successfully cancelled");
        } else {
            System.out.println("There is no reservation with id " + idBooking);
        }
    }

    private void chooseMenuItem5(Scanner in) {
        System.out.println("Write please information about passenger");
        System.out.println("Write please Name");
        String name = in.nextLine().toLowerCase();
        System.out.println("Write please Surname");
        String surname = in.nextLine().toLowerCase();
        List<Booking> bookings = bookingsController.getBookingsByHuman(name, surname);
        if (bookings.isEmpty()) {
            System.out.println("This passenger has no bookings");
        }
    }

    private void chooseMenuItem6() throws IOException {
        FileManager.writeFlightsData(flightsController.getAllFlights());
        FileManager.writeBookingsData(bookingsController.getAllBookings());
        System.out.println("Thanks for choosing us!");
    }

    public void chooseMenu() throws IOException, ParseException {
        authorization();
        Scanner in = new Scanner(System.in);
        while (true) {
            OnlinePanel.showOnlinePanel();
            String menuItem = in.nextLine();
            switch (menuItem) {
                case "1":
                    chooseMenuItem1();
                    break;
                case "2":
                    chooseMenuItem2(in);
                    break;
                case "3":
                    chooseMenuItem3(in);
                    break;
                case "4":
                    chooseMenuItem4(in);
                    break;
                case "5":
                    chooseMenuItem5(in);
                    break;
                case "6":
                case "exit":
                    chooseMenuItem6();
                    return;

                default:
                    System.out.println(incorrectInput);
            }
        }
    }
}
