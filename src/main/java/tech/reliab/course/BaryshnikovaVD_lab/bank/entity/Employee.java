package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import java.time.LocalDate;

public class Employee extends Human {
    private String jobName;
    private Bank bank;
    private boolean isWorkingAtHome;
    private BankOffice bankOffice;
    private boolean canTakeCredit;
    private double salaryAmount;

    public Employee(String fcs, LocalDate birthday, String jobName, Bank bank, boolean isWorkingAtHome, boolean canTakeCredit, double salaryAmount) {
        super(fcs, birthday);
        this.jobName = jobName;
        this.bank = bank;
        this.isWorkingAtHome = isWorkingAtHome;
        this.canTakeCredit = canTakeCredit;
        this.salaryAmount = salaryAmount;
        this.bankOffice = null;
    }

    public Employee(String fcs, LocalDate birthday, String jobName, Bank bank, boolean isWorkingAtHome, BankOffice bankOffice, boolean canTakeCredit, double salaryAmount) {
        this(fcs, birthday, jobName, bank, isWorkingAtHome, canTakeCredit, salaryAmount);
        this.bankOffice = bankOffice;
    }

    @Override
    public String toString() {
        return "Информация о сотруднике банка" + "\n" +
                "id: " + id + "\n" +
                "ФИО: " + fcs + "\n" +
                "Дата рождения: " + birthday + "\n" +
                "Должность: " + jobName + "\n" +
                "В каком банке работает: " + bank.getName() + "\n" +
                "Работает: " + (isWorkingAtHome ? "удаленно" : "в банковском офисе") + "\n" +
                "Банковский офис, в котором работает: " + bankOffice.getId() + " " + bankOffice.getName() + "\n" +
                "Может ли выдавать кредиты? " + (canTakeCredit ? "да" : "нет") + "\n" +
                "Размер зарплаты: " + salaryAmount + "\n";
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public boolean isCanTakeCredit() {
        return canTakeCredit;
    }

    public void setCanTakeCredit(boolean canTakeCredit) {
        this.canTakeCredit = canTakeCredit;
    }

    public boolean isWorkingAtHome() {
        return isWorkingAtHome;
    }

    public void setWorkingAtHome(boolean workingAtHome) {
        isWorkingAtHome = workingAtHome;
    }
}
