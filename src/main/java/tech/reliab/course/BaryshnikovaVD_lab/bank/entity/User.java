package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User extends Human {
    private String workplace;
    private double monthlyIncome;
    private ArrayList<Bank> banks;
    private ArrayList<CreditAccount> creditAccounts;
    private ArrayList<PaymentAccount> paymentAccounts;
    private int creditRating;

    public User() {
        super();
        monthlyIncome = 0;
        creditRating = 0;
        workplace = "";

        this.banks = new ArrayList<>();
        this.creditAccounts = new ArrayList<>();
        this.paymentAccounts = new ArrayList<>();
    }

    public User(String fcs, LocalDate birthday, String workplace) {
        super(fcs, birthday);
        this.workplace = workplace;
    }

    public User(User user) {
        this(user.fcs, user.birthday, user.workplace);
    }

    @Override
    public String toString() {
        StringBuilder logString = new StringBuilder(
                "id: " + id + "\n" +
                "ФИО: " + fcs + '\n' +
                "День рождения: " + birthday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + '\n' +
                "Место работы: " + workplace + '\n' +
                "Ежемесячный доход: " + String.format("%.2f", monthlyIncome) + '\n' +
                "Кредитный рейтинг: " + creditRating + "\n"
        );

        logString.append("Банки: ");
        if (banks == null)
            logString.append("нет\n");
        else
            for (Bank bank : this.banks)
                logString.append("|").append(bank.getName()).append("| ");

        logString.append("\nПлатёжные счета: ");
        if (paymentAccounts == null)
            logString.append("нет\n");
        else
            for (PaymentAccount paymentAccount : this.paymentAccounts)
                logString.append(" |№").append(paymentAccount.getId()).append(" ").append(paymentAccount.getBank().getName()).append("| ");

        logString.append("\nКредитные счета: ");
        if (creditAccounts == null)
            logString.append("нет\n");
        else
            for (CreditAccount creditAccount : this.creditAccounts)
                logString.append(" |№").append(creditAccount.getId()).append(" ").append(creditAccount.getBank().getName()).append("| ");

        return "\n" + logString;
    }


    public int getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(int creditRating) {
        this.creditRating = creditRating;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }

    public void setBanks(ArrayList<Bank> banks) {
        this.banks = banks;
    }

    public ArrayList<CreditAccount> getCreditAccounts() {
        return creditAccounts;
    }

    public void setCreditAccounts(ArrayList<CreditAccount> creditAccounts) {
        this.creditAccounts = creditAccounts;
    }

    public ArrayList<PaymentAccount> getPaymentAccounts() {
        return paymentAccounts;
    }

    public void setPaymentAccounts(ArrayList<PaymentAccount> paymentAccounts) {
        this.paymentAccounts = paymentAccounts;
    }
}