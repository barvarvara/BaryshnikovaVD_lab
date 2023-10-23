package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.CreditAccount;

public interface CreditAccountService {
    CreditAccount create(CreditAccount account);

    void delete(CreditAccount account);

    boolean makeMonthlyPayment(CreditAccount account);
}
