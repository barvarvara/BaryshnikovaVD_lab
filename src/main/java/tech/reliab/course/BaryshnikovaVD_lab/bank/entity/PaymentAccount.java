package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

public class PaymentAccount extends Account {
    private double balance;

    public PaymentAccount(User user, Bank bank) {
        super(user, bank);
        this.balance = 0;
    }

    public PaymentAccount(User user, Bank bank, double balance) {
        this(user, bank);
        this.balance = balance;
    }

    public PaymentAccount(PaymentAccount paymentAccount) {
        this(paymentAccount.user, paymentAccount.bank, paymentAccount.balance);
    }

    @Override
    public String toString() {
        return "Информация о платежном счете:" + "\n" +
                "id: " + id + "\n" +
                "Клиент: " + "№" +  user.getId() + " " + user.getFcs() + "\n" +
                "Название банка: " + bank.getName() + "\n" +
                "Сумма на счету: " + String.format("%.2f", balance) + "\n";
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
