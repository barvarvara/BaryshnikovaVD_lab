package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Bank;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankAtm;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankOffice;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Employee;

public interface BankOfficeService {
    BankOffice create(String name, String address, boolean isWorking, boolean isPossibleToPlaceAtm, boolean isCreditAvailable, boolean isMoneyWithdrawAvailable, boolean isDepositMoneyAvailable, double moneyAmount, double rentPrice, Bank bank);

    void delete(BankOffice bankOffice);

    boolean addAtm(BankOffice bankOffice, BankAtm atm);

    boolean deleteAtm(BankOffice bankOffice, BankAtm atm);

    boolean addEmployee(BankOffice bankOffice, Employee employee);

    boolean deleteEmployee(BankOffice bankOffice, Employee employee);

    boolean withdrawMoney(BankOffice bankOffice, double moneyAmount);

    boolean depositMoney(BankOffice bankOffice, double moneyAmount);

    boolean checkBankOffice(BankOffice bankOffice, double moneyAmount);

    boolean isBankOfficeSuitable(BankOffice bankOffice, double moneyAmount);
}
