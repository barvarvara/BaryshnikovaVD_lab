package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

public class PaymentAccount extends Account {
    private int balance;

    public PaymentAccount(Client client, Bank bank) {
        super(client, bank);
        balance = 0;
    }

    public PaymentAccount(Client client, Bank bank, int balance) {
        this(client, bank);
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Информация о платежном счете" + "\n" +
                "id: " + id + "\n" +
                "Пользователь, за которым закреплен этот платежный счет: " + client.getId() + " " + client.getFcs() + "\n" +
                "Название банка, в котором открыт этот счет: " + bank.getName() + "\n" +
                "Сумма, которая лежит в данный момент на счету: " + balance + "\n";
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
