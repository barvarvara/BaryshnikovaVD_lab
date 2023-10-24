package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import java.time.LocalDate;

public class CreditAccount extends Account {
    private LocalDate startDate;
    private LocalDate endDate;
    private int monthsCount;
    private double creditAmount;
    private double monthlyPayment;
    private double interestRate;
    private Employee bankEmployee;
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

    public CreditAccount(CreditAccount account) {
        this(account.user, account.bank, account.startDate, account.endDate, account.monthsCount, account.creditAmount, account.monthlyPayment, account.interestRate, account.bankEmployee, account.paymentAccount);
    }

    @Override
    public String toString() {
        return "Информация о кредитном счете" + "\n" +
                "id: " + id + "\n" +
                "Пользователь,: " + user.getFcs() + "\n" +
                "Банк: " + bank.getName() + "\n" +
                "Дата начала кредита: " + startDate + "\n" +
                "Дата окончания кредита: " + endDate + "\n" +
                "Кол-во месяцев кредита: " + monthsCount + "\n" +
                "Сумма кредита: " + String.format("%.2f",creditAmount) + "\n" +
                "Ежемесячный платеж " + String.format("%.2f", monthlyPayment) + "\n" +
                "Процентная ставка: " + String.format("%.2f", interestRate) + "\n" +
                "Сотрудник, который выдал кредит: " + bankEmployee.getFcs() + "\n" +
                "Платежный счет в банке: " + paymentAccount.getId() + " " + paymentAccount.getBank().getName() + "\n\n";
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

    public void setInterestRate(int interestRate) {
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

    public void setMonthlyPayment(int monthlyPayment) {
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
