package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.JobName;

import java.time.LocalDate;

public class Employee extends Human {
    private JobName jobName;
    private Bank bank;
    private boolean isWorkingAtHome;
    private BankOffice bankOffice;
    private boolean canWithdrawCredit;
    private double salaryAmount;

    public Employee(String fcs, LocalDate birthday, JobName jobName, Bank bank, boolean isWorkingAtHome, boolean canWithdrawCredit, double salaryAmount) {
        super(fcs, birthday);
        this.jobName = jobName;
        this.bank = bank;
        this.isWorkingAtHome = isWorkingAtHome;
        this.canWithdrawCredit = canWithdrawCredit;
        this.salaryAmount = salaryAmount;
        this.bankOffice = null;
    }

    public Employee(String fcs, LocalDate birthday, JobName jobName, Bank bank, boolean isWorkingAtHome, BankOffice bankOffice, boolean canTakeCredit, double salaryAmount) {
        this(fcs, birthday, jobName, bank, isWorkingAtHome, canTakeCredit, salaryAmount);
        this.bankOffice = bankOffice;
    }

    public Employee(Employee employee) {
        this(employee.fcs, employee.birthday, employee.jobName, employee.bank, employee.isWorkingAtHome, employee.bankOffice, employee.canWithdrawCredit, employee.salaryAmount);
    }

    @Override
    public String toString() {
        return "Информация о сотруднике банка" + "\n" +
                "id: " + id + "\n" +
                "ФИО: " + fcs + "\n" +
                "Дата рождения: " + birthday + "\n" +
                "Должность: " + ((jobName == JobName.MANAGER) ? "менеджер" : "консультант") + "\n" +
                "В каком банке работает: " + bank.getName() + "\n" +
                "Работает: " + (isWorkingAtHome ? "удаленно" : "в банковском офисе") + "\n" +
                "Банковский офис: " + (bankOffice != null ? (bankOffice.getId() + " " + bankOffice.getName()): "сотрудник не прикреплен к офису банка") + "\n" +
                "Может выдавать кредиты? " + (canWithdrawCredit ? "да" : "нет") + "\n" +
                "Размер зарплаты: " + String.format("%.2f", salaryAmount) + "\n\n";
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

    public JobName getJobName() {
        return jobName;
    }

    public void setJobName(JobName jobName) {
        this.jobName = jobName;
    }

    public boolean isCanWithdrawCredit() {
        return canWithdrawCredit;
    }

    public void setCanWithdrawCredit(boolean canTakeCredit) {
        this.canWithdrawCredit = canTakeCredit;
    }

    public boolean isWorkingAtHome() {
        return isWorkingAtHome;
    }

    public void setWorkingAtHome(boolean workingAtHome) {
        isWorkingAtHome = workingAtHome;
    }
}
