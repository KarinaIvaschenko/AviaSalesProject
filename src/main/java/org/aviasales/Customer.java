package org.aviasales;

public class Customer {
    Human human;
    String login;
    String password;

    public Customer(Human human, String login, String password) {
        this.human = human;
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
}
