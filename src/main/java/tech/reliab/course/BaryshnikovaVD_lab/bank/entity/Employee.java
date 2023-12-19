package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.JobName;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee extends Human {
    @Expose(serialize = true)
    private JobName jobName;

    @Expose(serialize = true)
    private Bank bank;

    @Expose(serialize = true)
    private boolean isWorkingAtHome;

    @Expose(serialize = true)
    private BankOffice bankOffice;

    @Expose(serialize = true)
    private boolean canWithdrawCredit;

    @Expose(serialize = true)
    private double salaryAmount;

    public Employee(String fcs, LocalDate birthday, JobName jobName, Bank bank, boolean isWorkingAtHome, BankOffice bankOffice, double salaryAmount) {
        super(fcs, birthday);
        this.jobName = jobName;
        this.bank = bank;
        this.isWorkingAtHome = isWorkingAtHome;
        this.canWithdrawCredit = (jobName == JobName.CREDIT_EXPERT);
        this.salaryAmount = salaryAmount;
        this.bankOffice = bankOffice;
    }

    public Employee(Employee employee) {
        this(employee.fcs, employee.birthday, employee.jobName, employee.bank, employee.isWorkingAtHome, employee.bankOffice, employee.salaryAmount);
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "ФИО: " + fcs + "\n" +
                "День рождения: " + birthday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + '\n' +
                "Должность: " + ((jobName == JobName.MANAGER) ? "менеджер" :
                                ((jobName == JobName.PROGRAMMER) ? "программист" :
                                ((jobName == JobName.CREDIT_EXPERT) ? "кредитный специалист" : "консультант"))) + "\n" +
                "В каком банке работает: " + bank.getName() + "\n" +
                "Работает: " + (isWorkingAtHome ? "удаленно" : "в банковском офисе") + "\n" +
                (bankOffice != null ? ("Банковский офис: " + "№" + bankOffice.getId() + " " + bankOffice.getName()) : "Сотрудник не прикреплен к офису банка") + "\n" +
                (canWithdrawCredit ? "М" : "Не м") + "ожет выдавать кредиты\n" +
                "Размер зарплаты: " + String.format("%.2f", salaryAmount) + "\n";
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", id);
        jsonObject.addProperty("fcs", fcs);
        jsonObject.addProperty("jobName", jobName.toString());
        jsonObject.add("bank", bank.toJson());
        jsonObject.addProperty("isWorkingAtHome", isWorkingAtHome);
        jsonObject.addProperty("canWithdrawCredit", canWithdrawCredit);
        jsonObject.addProperty("salaryAmount", salaryAmount);
        jsonObject.add("bankOffice", bankOffice.toJson());

        return jsonObject;
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

    public boolean canWithdrawCredit() {
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
