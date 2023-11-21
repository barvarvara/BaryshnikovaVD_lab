package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.CreditAccountService;

import java.time.LocalDate;

public class CreditAccountServiceImpl implements CreditAccountService {
    @Override
    public CreditAccount create(User user, Bank bank, LocalDate startDate, LocalDate endDate, int monthsCount, double creditAmount, double monthlyPayment, double interestRate, Employee bankEmployee, PaymentAccount paymentAccount) {
        if (bank == null) {
            System.out.println("Ошибка! Невозможно создать счёт без банка");
            return null;
        }

        return new CreditAccount(user, bank, startDate, endDate, monthsCount, creditAmount, monthlyPayment, interestRate, bankEmployee, paymentAccount);
    }

    @Override
    public void delete(CreditAccount account) {
        account.setBank(null);
        account.setUser(null);
        account.setStartDate(null);
        account.setEndDate(null);
        account.setMonthsCount(0);
        account.setCreditAmount(0);
        account.setMonthlyPayment(0);
        account.setInterestRate(0);
        account.setBankEmployee(null);
        account.setPaymentAccount(null);
    }

    @Override
    public boolean makeMonthlyPayment(CreditAccount account) {
        if (account == null || account.getPaymentAccount() == null) {
            System.out.println("Ошибка! нет счёта, с которого может осуществляться перевод.");
            return false;
        }

        final double monthlyPayment = account.getMonthlyPayment();
        final double balance = account.getPaymentAccount().getBalance();

        if (balance < monthlyPayment) {
            System.out.println("Ошибка! На платежном счете недостаточно средст для оплаты ежемесячного платежа.");
            return false;
        }

        account.getPaymentAccount().setBalance(balance - monthlyPayment);
        account.setCreditAmount(account.getCreditAmount() - monthlyPayment);

        return true;
    }
}
