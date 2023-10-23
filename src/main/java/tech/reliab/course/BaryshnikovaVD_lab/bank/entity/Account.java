package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import java.util.UUID;

public class Account {
    protected int id;
    protected User user;
    protected Bank bank;

    public Account() {
        id = Math.abs(UUID.randomUUID().hashCode());
        user = null;
        bank = null;
    }

    public Account(User user, Bank bank) {
        this();
        this.bank = bank;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

