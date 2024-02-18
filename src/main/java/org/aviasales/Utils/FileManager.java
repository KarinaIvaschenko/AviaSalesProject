package org.aviasales.Utils;

import org.aviasales.Entity.Booking;
import org.aviasales.Entity.Customer;
import org.aviasales.Entity.Flight;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {
    private static final String FILE_PATH_FLIGHTS = "Data/flights.dat";
    private static final String FILE_PATH_BOOKINGS = "Data/bookings.dat";
    private static final String FILE_PATH_CUSTOMERS = "Data/customers.dat";

    public static void writeFlightsData(List<Flight> flights) throws IOException {
        Files.createDirectories(Paths.get("Data/"));
        try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH_FLIGHTS);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(flights);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Flight> loadFlightsData() {
        List<Flight> flights;
        try (FileInputStream fileIn = new FileInputStream(FILE_PATH_FLIGHTS);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            flights = (List<Flight>) objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flights;
    }

    public static void writeBookingsData(List<Booking> bookings) throws IOException {
        Files.createDirectories(Paths.get("Data/"));
        try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH_BOOKINGS);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(bookings);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Booking> loadBookingsData() {
        List<Booking> bookings;
        try (FileInputStream fileIn = new FileInputStream(FILE_PATH_BOOKINGS);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            bookings = (List<Booking>) objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return bookings;
    }

    public static void writeCustomersData(List<Customer> customers) throws IOException {
        Files.createDirectories(Paths.get("Data/"));
        try (FileOutputStream fileOut = new FileOutputStream(FILE_PATH_CUSTOMERS);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(customers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Customer> loadCustomersData() {
        List<Customer> customers;
        try (FileInputStream fileIn = new FileInputStream(FILE_PATH_CUSTOMERS);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            customers = (List<Customer>) objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}