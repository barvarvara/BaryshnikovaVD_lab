package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import java.util.UUID;

public class Account {
    protected int id;
    protected Client client;
    protected Bank bank;

    public Account() {
        id = Math.abs(UUID.randomUUID().hashCode());
        client = null;
        bank = null;
    }

    public Account(Client client, Bank bank) {
        this();
        this.bank = bank;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

