package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client extends Human {
    private String workplace;
    private int monthlyIncome;
    private Bank bank;
    private int bankCreditRating;

    public Client() {
        super();
        monthlyIncome = 0;
        bankCreditRating = 0;
        workplace = "";
        bank = null;
    }

    public Client(String fcs, LocalDate birthday, String workplace, Bank bank, int monthlyIncome, int bankCreditRating) {
        super(fcs, birthday);
        this.workplace = workplace;
        this.bank = bank;
        this.monthlyIncome = monthlyIncome;
        this.bankCreditRating = bankCreditRating;
    }

    @Override
    public String toString() {
        return "Информация о клиенте банка " +
                "id: " + id + "\n" +
                "ФИО: " + fcs + '\n' +
                "День рождения: " + birthday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + '\n' +
                "Место работы: " + workplace + '\n' +
                "Ежемесячный доход: " + monthlyIncome + '\n' +
                "Банк, которым он пользуется: " + bank + '\n' +
                "Кредитный рейтинг для банка: " + bankCreditRating + '\n';
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

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
}