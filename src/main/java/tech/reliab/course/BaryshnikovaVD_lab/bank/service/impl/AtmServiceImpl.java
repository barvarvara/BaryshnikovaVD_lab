package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Bank;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankAtm;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankOffice;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Employee;
import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.BankAtmStatus;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.AtmService;

public class AtmServiceImpl implements AtmService {
    @Override
    public BankAtm create(String name, BankAtmStatus status, Bank bank, BankOffice bankOffice, Employee employee, boolean isMoneyWithdrawAvailable, boolean isDepositMoneyAvailable, double atmServicePrice, double moneyAmount) {
        if (bank == null)
            System.out.println("Ошибка! Банка не существует.\n\n");

        if (bankOffice == null)
            System.out.println("Ошибка! Банкомат может быть расположен только в банковском офисе.\n\n");

        return new BankAtm(name, status, bank, bankOffice, employee, isMoneyWithdrawAvailable, isDepositMoneyAvailable, atmServicePrice, moneyAmount);
    }

    @Override
    public void delete(BankAtm bankAtm) {
        bankAtm.setName("");
        bankAtm.setBankOffice(null);
        bankAtm.setAddress("");
        bankAtm.setStatus(null);
        bankAtm.setBank(null);
        bankAtm.setMoneyAmount(0);
        bankAtm.setMoneyWithdrawAvailable(false);
        bankAtm.setDepositMoneyAvailable(false);
        bankAtm.setAtmServicePrice(0);
    }

    @Override
    public boolean withdrawMoney(BankAtm bankAtm, double moneyAmount) {
        if (bankAtm == null) {
            System.out.println("Ошибка! Банкомат не существует.\n\n");
            return false;
        }

        if (!bankAtm.isMoneyWithdrawAvailable()) {
            System.out.println("Ошибка! Банкомат не работает на выдачу денег.\n\n");
            return false;
        }

        double newMoneyCount = bankAtm.getMoneyAmount() - moneyAmount;
        if (newMoneyCount < 0) {
            System.out.println("Ошибка! Недостаточно денег в банкомате.\n\n");
        } else {
            bankAtm.setMoneyAmount(newMoneyCount);

            bankAtm.getBankOffice().setMoneyAmount(bankAtm.getBankOffice().getMoneyAmount() - moneyAmount);
            bankAtm.getBank().setTotalAmountMoney(bankAtm.getBank().getTotalAmountMoney() - moneyAmount);

            return true;
        }

        return false;
    }

    @Override
    public boolean depositMoney(BankAtm bankAtm, double moneyAmount) {
        if (bankAtm == null) {
            System.out.println("Ошибка! Банкомат не существует.\n\n");
            return false;
        }

        if (!bankAtm.isDepositMoneyAvailable()) {
            System.out.println("Ошибка! В банкомат нельзя вносить деньги.\n\n");
            return false;
        }

        bankAtm.setMoneyAmount(bankAtm.getMoneyAmount() + moneyAmount);
        bankAtm.getBankOffice().setMoneyAmount(bankAtm.getBankOffice().getMoneyAmount() + moneyAmount);
        bankAtm.getBank().setTotalAmountMoney(bankAtm.getBank().getTotalAmountMoney() + moneyAmount);

        return true;
    }
}
