package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Bank;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankAtm;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankOffice;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Employee;
import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.BankAtmStatus;

public interface AtmService {
    BankAtm create(String name, BankAtmStatus status, Bank bank, BankOffice bankOffice, Employee employee, boolean isMoneyWithdrawAvailable, boolean isDepositMoneyAvailable, double atmServicePrice, double moneyAmount);

    void delete(BankAtm bankAtm);

    boolean depositMoney(BankAtm bankAtm, double moneyAmount);

    boolean withdrawMoney(BankAtm bankAtm, double moneyAmount);
}