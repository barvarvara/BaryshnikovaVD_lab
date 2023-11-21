package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Bank;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.PaymentAccount;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.User;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {
    @Override
    public PaymentAccount create(User user, Bank bank, double balance) {
        return new PaymentAccount(user, bank, balance);
    }

    @Override
    public void delete(PaymentAccount account) {
        account.setUser(null);
        account.setBank(null);
        account.setBalance(0);
    }

    @Override
    public boolean depositMoney(PaymentAccount account, double moneyAmount) {
        if (account == null) {
            System.out.println("Error: Несуществующий платежный счёт.");
            return false;
        }

        account.setBalance(account.getBalance() + moneyAmount);

        return true;
    }

    @Override
    public boolean withdrawMoney(PaymentAccount paymentAccount, double moneyAmount) {
        if (paymentAccount == null) {
            System.out.println("Error: Несуществующий платежный счёт.");
            return false;
        }

        if (paymentAccount.getBalance() < moneyAmount) {
            System.out.println("Error: Недостаточно средств на счёте для выдачи необходимой суммы");
            return false;
        }

        paymentAccount.setBalance(paymentAccount.getBalance() - moneyAmount);

        return true;
    }
}
