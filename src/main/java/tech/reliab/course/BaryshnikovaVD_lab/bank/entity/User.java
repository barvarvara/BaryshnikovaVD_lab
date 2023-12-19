package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class User extends Human {
    @Expose(serialize = true)
    private String workplace;

    @Expose(serialize = true)
    private double monthlyIncome;

    @Expose(serialize = false)
    private Bank bank;

    @Expose(serialize = false)
    private ArrayList<CreditAccount> creditAccounts;

    @Expose(serialize = false)
    private ArrayList<PaymentAccount> paymentAccounts;

    @Expose(serialize = true)
    private int creditRating;

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

        logString.append("Банк: ");
        if (bank == null)
            logString.append("нет\n");
        else
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

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", id);
        jsonObject.addProperty("fcs", fcs);
        jsonObject.addProperty("creditRating", creditRating);
        jsonObject.addProperty("workplace", workplace);
        jsonObject.addProperty("monthlyIncome", monthlyIncome);

        return jsonObject;
    }

    public int getCreditAccountIdxById(int id) {
        int index = 0;

        for (CreditAccount creditAccount : creditAccounts) {
            if (creditAccount.getId() == id)
                return index;
            index++;
        }

        return -1;
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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