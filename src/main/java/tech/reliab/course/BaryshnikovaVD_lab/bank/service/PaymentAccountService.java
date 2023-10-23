package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.PaymentAccount;

public interface PaymentAccountService {
    PaymentAccount create(PaymentAccount account);

    void delete(PaymentAccount account);

    boolean depositMoney(PaymentAccount account, double moneyAmount);

    boolean withdrawMoney(PaymentAccount account, double moneyAmount);
}
