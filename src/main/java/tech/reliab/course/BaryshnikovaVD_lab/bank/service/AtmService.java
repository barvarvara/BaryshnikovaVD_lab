package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankAtm;

public interface AtmService {
    BankAtm create(BankAtm bankAtm);

    void delete(BankAtm bankAtm);

    boolean depositMoney(BankAtm bankAtm, double moneyAmount);

    boolean withdrawMoney(BankAtm bankAtm, double moneyAmount);
}