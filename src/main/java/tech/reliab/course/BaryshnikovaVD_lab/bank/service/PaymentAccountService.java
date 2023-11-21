package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Bank;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.PaymentAccount;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.User;

public interface PaymentAccountService {
    PaymentAccount create(User user, Bank bank, double balance);

    void delete(PaymentAccount account);

    boolean depositMoney(PaymentAccount account, double moneyAmount);

    boolean withdrawMoney(PaymentAccount account, double moneyAmount);
}
