package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;


public class Account {
    private static int currentId;
    protected int id;
    protected User user;
    protected Bank bank;

    public Account() {
        id = currentId++;
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

