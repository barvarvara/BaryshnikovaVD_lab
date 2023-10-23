package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankAtm;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankOffice;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Employee;

public interface BankOfficeService {
    BankOffice create(BankOffice bankOffice);

    void delete(BankOffice bankOffice);

    boolean addAtm(BankOffice bankOffice, BankAtm atm);

    boolean deleteAtm(BankOffice bankOffice, BankAtm atm);

    boolean addEmployee(BankOffice bankOffice, Employee employee);

    boolean deleteEmployee(BankOffice bankOffice, Employee employee);

    boolean withdrawMoney(BankOffice bankOffice, double moneyAmount);

    boolean depositMoney(BankOffice bankOffice, double moneyAmount);
}
