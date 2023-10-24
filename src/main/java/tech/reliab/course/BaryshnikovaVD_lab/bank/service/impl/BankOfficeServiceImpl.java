package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankAtm;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankOffice;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Employee;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.BankOfficeService;

public class BankOfficeServiceImpl implements BankOfficeService {
    @Override
    public BankOffice create(BankOffice bankOffice) {
        if (bankOffice == null) {
            return null;
        }

        return new BankOffice(bankOffice);
    }

    @Override
    public void delete(BankOffice bankOffice) {
        bankOffice.setName("");
        bankOffice.setAddress("");
        bankOffice.setWorking(false);
        bankOffice.setPossibleToPlaceAtm(false);
        bankOffice.setAtmCount(0);
        bankOffice.setCreditAvailable(false);
        bankOffice.setMoneyWithdrawAvailable(false);
        bankOffice.setDepositMoneyAvailable(false);
        bankOffice.setMoneyAmount(0);
        bankOffice.setRentPrice(0);
    }

    @Override
    public boolean addAtm(BankOffice bankOffice, BankAtm atm) {
        if (bankOffice == null || atm == null) {
            System.out.println("Error: не существует офиса банка или банкомата");
            return false;
        }

        if (!bankOffice.isPossibleToPlaceAtm()) {
            System.out.println("Error: невозможно разместить банкомат в офисе банка.");
            return false;
        }

        bankOffice.setAtmCount(bankOffice.getAtmCount() + 1);
        atm.setBankOffice(bankOffice);
        atm.setAddress(bankOffice.getAddress());

        return true;
    }

    @Override
    public boolean deleteAtm(BankOffice bankOffice, BankAtm atm) {
        if (bankOffice == null || atm == null) {
            System.out.println("Error: не существует офиса банка или банкомата");
            return false;
        }

        int atmCount = bankOffice.getAtmCount() - 1;
        if (atmCount < 0) {
            System.out.println("Error: невозможно убрать банкомат, потому что в офисе больше нет банкоматов");
            return false;
        }

        bankOffice.setAtmCount(atmCount);
        return true;
    }

    @Override
    public boolean addEmployee(BankOffice bankOffice, Employee employee) {
        if (bankOffice == null || employee == null) {
            System.out.println("Error: не существует офиса банка или сотрудника банка");
            return false;
        }

        employee.setBankOffice(bankOffice);
        employee.setBank(bankOffice.getBank());

        return true;
    }

    @Override
    public boolean deleteEmployee(BankOffice bankOffice, Employee employee) {
        if (bankOffice == null || employee == null) {
            System.out.println("Error: не существует офиса банка или сотрудника банка");
            return false;
        }

        return true;
    }

    @Override
    public boolean depositMoney(BankOffice bankOffice, double moneyAmount) {
        if (bankOffice == null) {
            System.out.println("Error: Офис банка не существует");
            return false;
        }

        if (!bankOffice.isDepositMoneyAvailable()) {
            System.out.println("Error: невозможно внести сумму на счет");
            return false;
        }

        bankOffice.setMoneyAmount(bankOffice.getMoneyAmount() + moneyAmount);

        return true;
    }

    @Override
    public boolean withdrawMoney(BankOffice bankOffice, double moneyAmount) {
        if (bankOffice == null) {
            System.out.println("Error: Офис банка не существует");
            return false;
        }

        if (!bankOffice.isMoneyWithdrawAvailable()) {
            System.out.println("Error: невозможно снять сумму с банкомата");
            return false;
        }

        if (bankOffice.getMoneyAmount() < moneyAmount) {
            System.out.println("Error: сумма денег в офисе недостаточно для выдачи");
            return false;
        }

        bankOffice.setMoneyAmount(bankOffice.getMoneyAmount() - moneyAmount);
        return true;
    }
}
