package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import java.time.LocalDate;

public class CreditAccount extends Account {
    private LocalDate startDate;
    private LocalDate endDate;
    private int numMonths;
    private int creditAmount;
    private int monthlyPayment;
    private int interestRate;
    private Employee bankEmployee;
    private PaymentAccount paymentAccount;

    public CreditAccount(Client client, Bank bank, LocalDate startDate, LocalDate endDate, int numMonth, int creditAmount, int monthlyPayment, int interestRate, Employee bankEmployee, PaymentAccount paymentAccount) {
        super(client, bank);
        this.startDate = startDate;
        this.endDate = endDate;
        this.numMonths = numMonth;
        this.creditAmount = creditAmount;
        this.monthlyPayment = monthlyPayment;
        this.interestRate = interestRate;
        this.bankEmployee = bankEmployee;
        this.paymentAccount = paymentAccount;
    }

    @Override
    public String toString() {
        return "Информация о кредитном счете" + "\n" +
                "id: " + id + "\n" +
                "Пользователь, за которым закреплен этот кредитный счет: " + client.getFcs() + "\n" +
                "Название банка, где взят кредит: " + bank.getName() + "\n" +
                "Дата начала кредита: " + startDate + "\n" +
                "Дата окончания кредита: " + endDate + "\n" +
                "Кол-во месяцев, на которые взят кредит: " + numMonths + "\n" +
                "Сумма кредита: " + creditAmount + "\n" +
                "Ежемесячный платеж " + monthlyPayment + "\n" +
                "Процентная ставка: " + interestRate + "\n" +
                "Сотрудник, который выдал кредит: " + bankEmployee.getFcs() + "\n" +
                "Платежный счет в банке: " + paymentAccount.getId() + " " + paymentAccount.getBank().getName() + "\n";
    }

    public int getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    public int getInterestRate() {
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

    public int getMonthlyPayment() {
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

    public int getNumMonths() {
        return numMonths;
    }

    public void setNumMonths(int numMonths) {
        this.numMonths = numMonths;
    }
}
