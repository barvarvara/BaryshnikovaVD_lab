package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.CreditAccount;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.CreditAccountService;

public class CreditAccountServiceImpl implements CreditAccountService {
    @Override
    public CreditAccount create(CreditAccount account) {
        if (account == null) {
            return null;
        }

        if (account.getBank() == null) {
            System.out.println("Error: Невозможно создать счёт без банка");
            return null;
        }

        return new CreditAccount(account);
    }

    @Override
    public void delete(CreditAccount account) {
        account.setBank(null);
        account.setUser(null);
        account.setStartDate(null);
        account.setEndDate(null);
        account.setNumMonths(0);
        account.setCreditAmount(0);
        account.setMonthlyPayment(0);
        account.setInterestRate(0);
        account.setBankEmployee(null);
        account.setPaymentAccount(null);
    }

    @Override
    public boolean makeMonthlyPayment(CreditAccount account) {
        if (account == null || account.getPaymentAccount() == null) {
            System.out.println("Error: нет счёта, с которого может осуществляться перевод.");
            return false;
        }

        final double monthlyPayment = account.getMonthlyPayment();
        final double balance = account.getPaymentAccount().getBalance();

        if (balance < monthlyPayment) {
            System.out.println("Error: На платежном счете недостаточно средст для оплаты ежемесячного платежа.");
            return false;
        }

        account.getPaymentAccount().setBalance(balance - monthlyPayment);
        account.setCreditAmount(account.getCreditAmount() - monthlyPayment);

        return true;
    }
}
