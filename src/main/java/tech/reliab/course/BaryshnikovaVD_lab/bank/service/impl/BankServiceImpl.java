package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.BankService;

import java.util.Random;

import static utils.Constants.*;

public class BankServiceImpl implements BankService {
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
        bank.setNumOffices(0);
        bank.setNumAtm(0);
        bank.setNumEmployee(0);
        bank.setNumUsers(0);
        bank.setRating(0);
        bank.setTotalAmountMoney(0);
        bank.setInterestRate(0);
    }

    @Override
    public boolean addBankOffice(Bank bank, BankOffice office) {
        return false;
    }

    @Override
    public boolean deleteBankOffice(Bank bank, BankOffice office) {
        return false;
    }

    @Override
    public boolean addEmployee(Bank bank, Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployee(Bank bank, Employee employee) {
        return false;
    }

    @Override
    public boolean depositMoney(Bank bank, double moneyAmount) {
        return false;
    }

    @Override
    public boolean withdrawMoney(Bank bank, double moneyAmount) {
        return false;
    }

    @Override
    public boolean approveCredit(Bank bank, CreditAccount account, User user) {
        return false;
    }
}
