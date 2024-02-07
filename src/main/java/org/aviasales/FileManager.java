package org.aviasales;

import java.io.*;
import java.util.List;

public class FileManager {
    public static void writeData(List<Flight> flights) {
        try (FileOutputStream fileOut = new FileOutputStream("src/main/java/org/aviasales/Data/flights.dat");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(flights);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Flight> loadData() {
        List<Flight> flights;
        try (FileInputStream fileIn = new FileInputStream("src/main/java/org/aviasales/Data/flights.dat");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            flights = (List<Flight>) objectIn.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flights;
    }
}
