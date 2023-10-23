package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User extends Human {
    private String workplace;
    private double monthlyIncome;
    private Bank bank;
    private int bankCreditRating;

    public User() {
        super();
        monthlyIncome = 0;
        bankCreditRating = 0;
        workplace = "";
        bank = null;
    }

    public User(String fcs, LocalDate birthday, String workplace, Bank bank, double monthlyIncome, int bankCreditRating) {
        super(fcs, birthday);
        this.workplace = workplace;
        this.bank = bank;
        this.monthlyIncome = monthlyIncome;
        this.bankCreditRating = bankCreditRating;
    }

    public User(User user) {
        this(user.fcs, user.birthday, user.workplace, user.bank, user.monthlyIncome, user.bankCreditRating);
    }

    @Override
    public String toString() {
        return "Информация о клиенте банка " + "\n" +
                "id: " + id + "\n" +
                "ФИО: " + fcs + '\n' +
                "День рождения: " + birthday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + '\n' +
                "Место работы: " + workplace + '\n' +
                "Ежемесячный доход: " + String.format("%.2f", monthlyIncome) + '\n' +
                "Банк, которым он пользуется: " + bank.getName() + '\n' +
                "Кредитный рейтинг для банка: " + bankCreditRating + "\n\n";
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int getBankCreditRating() {
        return bankCreditRating;
    }

    public void setBankCreditRating(int bankCreditRating) {
        this.bankCreditRating = bankCreditRating;
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
}