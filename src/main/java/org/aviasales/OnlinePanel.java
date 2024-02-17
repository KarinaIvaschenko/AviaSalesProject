package org.aviasales;

public class OnlinePanel {

    public static void showOnlinePanel() {
        System.out.println();
        System.out.println("-----Enter command-----");
        System.out.println();
        System.out.println("""
                - 1. Online Panel
                - 2. View Flight Information
                - 3. Search and Book a Flight
                - 4. Cancel Booking
                - 5. My Flights
                - 6. Exit
                """);
    }

    public static void showOnlinePanelForRegisteredUser() {
        System.out.println();
        System.out.println("-----Enter command-----");
        System.out.println();
        System.out.println("""
                - 1. Online Panel
                - 2. View Flight Information
                - 3. Search and Book a Flight
                - 4. Cancel Booking
                - 5. My Flights
                - 6. Exit
                - 7. Log out
                """);
    }
}
