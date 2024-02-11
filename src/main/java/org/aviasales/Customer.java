package org.aviasales;

public class Customer extends Human {
    private int customerId;
    private Human human;
    private String login;
    private String password;
    private Booking bookings;

    public Customer(int customerId, String name, String surname, String gender, String login, String password) {
        super(name, surname, gender);
        this.customerId = customerId;
        this.login = login;
        this.password = password;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Booking getBookings() {
        return bookings;
    }

    public void setBookings(Booking bookings) {
        this.bookings = bookings;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
