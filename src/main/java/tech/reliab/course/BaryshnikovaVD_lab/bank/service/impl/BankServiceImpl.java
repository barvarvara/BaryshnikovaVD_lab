package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.BankService;

import java.util.Random;

import static tech.reliab.course.BaryshnikovaVD_lab.bank.utils.Constants.*;

public class BankServiceImpl implements BankService {
    @Override
    public Bank create(Bank bank) {
        if (bank == null) {
            return null;
        }

        Bank newBank = new Bank(bank);

        newBank.setRating((int) (Math.random() * MAX_BANK_RATING));
        newBank.setTotalAmountMoney(Math.random() * MAX_TOTAL_MONEY);
        newBank.setInterestRate(calcInterestRate(newBank));

        return newBank;
    }

    @Override
    public void delete(Bank bank) {
        bank.setName("");
        bank.setOfficesCount(0);
        bank.setAtmCount(0);
        bank.setEmployeeCount(0);
        bank.setUsersCount(0);
        bank.setRating(0);
        bank.setTotalAmountMoney(0);
        bank.setInterestRate(0);
    }


    private double calcInterestRate(Bank bank) {
        if (bank == null)
            return 0;

        final Random random = new Random();
        final int rating = bank.getRating();

        final double centralBankInterestRate = random.nextDouble() * MAX_BANK_INTEREST_RATE;
        final double maxBankInterestRate = MAX_BANK_INTEREST_RATE - centralBankInterestRate;
        final double bankInterestRateMargin = (random.nextDouble() * maxBankInterestRate) * ((double) (110 - rating) / 100);

        return centralBankInterestRate + bankInterestRateMargin;
    }

    @Override
    public boolean addBankOffice(Bank bank, BankOffice office) {
        if (bank == null || office == null) {
            System.out.println("Error: не существует банка или офиса банка");
            return false;
        }

        office.setBank(bank);
        bank.setOfficesCount(bank.getOfficesCount() + 1);

        return true;
    }

    @Override
    public boolean deleteBankOffice(Bank bank, BankOffice office) {
        if (bank == null || office == null) {
            System.out.println("Error: не существует банка или офиса банка");
            return false;
        }

        office.setBank(null);
        int newOfficesCount = bank.getOfficesCount() - 1;
        if (newOfficesCount < 0) {
            System.out.println("Error: невозможно удалить офис, т.к. за банком не закреплено офисов");
            return false;
        }

        bank.setOfficesCount(newOfficesCount);

        return true;
    }

    @Override
    public boolean addEmployee(Bank bank, Employee employee) {
        if (bank == null || employee == null) {
            System.out.println("Error: не существует банка или сотрудника банка");
            return false;
        }

        employee.setBank(bank);
        bank.setEmployeeCount(bank.getEmployeeCount() + 1);

        return true;
    }

    @Override
    public boolean deleteEmployee(Bank bank, Employee employee) {
        if (bank == null || employee == null) {
            System.out.println("Error: не существует банка или сотрудника банка");
            return false;
        }

        employee.setBank(null);
        int newEmployeeCount = bank.getEmployeeCount() - 1;
        if (newEmployeeCount < 0) {
            System.out.println("Error: невозможно убрать сотрудника, т.к. за банком не закреплен ни один сотрудник");
            return false;
        }

        bank.setEmployeeCount(newEmployeeCount);

        return true;
    }

    @Override
    public boolean depositMoney(Bank bank, double moneyAmount) {
        if (bank == null) {
            System.out.println("Error: Несуществующий банк.");
            return false;
        }

        bank.setTotalAmountMoney(bank.getTotalAmountMoney() + moneyAmount);

        return true;
    }

    @Override
    public boolean withdrawMoney(Bank bank, double moneyAmount) {
        if (bank == null) {
            System.out.println("Error: Несуществующий банк.");
            return false;
        }

        if (bank.getTotalAmountMoney() < moneyAmount) {
            System.out.println("Error: Недостаточно средств в банке для выдачи необходимой суммы");
            return false;
        }

        bank.setTotalAmountMoney(bank.getTotalAmountMoney() - moneyAmount);

        return true;
    }
}
