package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankAtm;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.AtmService;

public class AtmServiceImpl implements AtmService {
    @Override
    public BankAtm create(BankAtm bankAtm) {
        if (bankAtm == null) {
            return null;
        }

        if (bankAtm.getBankOffice() == null) {
            System.out.println("Error: BankOffice == null Банкомат может быть расположен только в банковском офисе.\n\n");
        }

        return new BankAtm(bankAtm);
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
            System.out.println("Error: Банкомат не существует.\n\n");
            return false;
        }

        if (!bankAtm.isMoneyWithdrawAvailable()) {
            System.out.println("Error: Банкомат не работает на выдачу денег.\n\n");
        }

        double newNumMoney = bankAtm.getMoneyAmount() - moneyAmount;
        if (newNumMoney < 0) {
            System.out.println("Error: Недостаточно денег в банкомате.\n\n");
        } else {
            bankAtm.setMoneyAmount(newNumMoney);
            return true;
        }

        return false;
    }

    @Override
    public boolean depositMoney(BankAtm bankAtm, double moneyAmount) {
        if (bankAtm == null) {
            System.out.println("Error: Банкомат не существует.\n\n");
            return false;
        }

        if (!bankAtm.isDepositMoneyAvailable()) {
            System.out.println("Error: В банкомат нельзя вносить деньги.\n\n");
            return false;
        }

        bankAtm.setMoneyAmount(bankAtm.getMoneyAmount() + moneyAmount);

        return true;
    }
}
