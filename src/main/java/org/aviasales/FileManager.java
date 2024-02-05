package org.aviasales;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
}
