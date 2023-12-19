package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreditAccount extends Account {
    @Expose(serialize = false)
    private LocalDate startDate;

    @Expose(serialize = false)
    private LocalDate endDate;

    @Expose(serialize = true)
    private int monthsCount;

    @Expose(serialize = true)
    private double creditAmount;

    @Expose(serialize = true)
    private double monthlyPayment;

    @Expose(serialize = true)
    private double interestRate;

    @Expose(serialize = true)
    private Employee bankEmployee;

    @Expose(serialize = true)
    private PaymentAccount paymentAccount;

    public CreditAccount(User user, Bank bank, LocalDate startDate, LocalDate endDate, int monthsCount, double creditAmount, double monthlyPayment, double interestRate, Employee bankEmployee, PaymentAccount paymentAccount) {
        super(user, bank);
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthsCount = monthsCount;
        this.creditAmount = creditAmount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.bankEmployee = bankEmployee;
        this.paymentAccount = paymentAccount;
    }

    public CreditAccount(User user, Bank bank, LocalDate startDate, int monthsCount, double creditAmount, double monthlyPayment, double interestRate, Employee bankEmployee, PaymentAccount paymentAccount) {
        super(user, bank);
        this.startDate = startDate;
        this.endDate = startDate.plusMonths(monthsCount);
        this.monthsCount = monthsCount;
        this.creditAmount = creditAmount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.bankEmployee = bankEmployee;
        this.paymentAccount = paymentAccount;
    }

    public CreditAccount(CreditAccount account) {
        this(account.user, account.bank, account.startDate, account.endDate, account.monthsCount, account.creditAmount, account.monthlyPayment, account.interestRate, account.bankEmployee, account.paymentAccount);
    }

    @Override
    public String toString() {
        return "Информация о кредитном счете" + "\n" +
                "id: " + id + "\n" +
                "Клиент: " + user.getFcs() + "\n" +
                "Банк: " + bank.getName() + "\n" +
                "Дата начала кредита: " + startDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n" +
                "Дата окончания кредита: " + endDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "\n" +
                "Кол-во месяцев кредита: " + monthsCount + "\n" +
                "Сумма кредита: " + String.format("%.2f", creditAmount) + "\n" +
                "Ежемесячный платеж " + String.format("%.2f", monthlyPayment) + "\n" +
                "Процентная ставка: " + String.format("%.2f", interestRate) + "\n" +
                "Сотрудник, который выдал кредит: " + bankEmployee.getFcs() + "\n" +
                "Платежный счет: " + "№" + paymentAccount.getId() + " " + paymentAccount.getBank().getName() + "\n";
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", id);
        jsonObject.add("user", user.toJson());
        jsonObject.add("bank", bank.toJson());
        jsonObject.addProperty("monthsCount", monthsCount);
        jsonObject.addProperty("creditAmount", creditAmount);
        jsonObject.addProperty("monthlyPayment", monthlyPayment);
        jsonObject.addProperty("interestRate", interestRate);
        jsonObject.add("bankEmployee", bankEmployee.toJson());
        jsonObject.add("paymentAccount", paymentAccount.toJson());

        return jsonObject;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public PaymentAccount getPaymentAccount() {
        return paymentAccount;
    }

    public void setPaymentAccount(PaymentAccount paymentAccount) {
        this.paymentAccount = paymentAccount;
    }

    public Employee getBankEmployee() {
        return bankEmployee;
    }

    public void setBankEmployee(Employee bankEmployee) {
        this.bankEmployee = bankEmployee;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getMonthsCount() {
        return monthsCount;
    }

    public void setMonthsCount(int monthsCount) {
        this.monthsCount = monthsCount;
    }
}
