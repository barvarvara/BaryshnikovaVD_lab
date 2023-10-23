package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Bank;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.BankService;

import java.util.Random;

import static utils.Constants.*;

public class BankServiceImpl implements BankService {
    public double calculetaInterestRank(Bank bank) {
        if (bank != null) {
            final Random random = new Random();
            final byte rating = bank.getRating();

            final double centralBankInterestRate = random.nextDouble() * MAX_BANK_INTEREST_RATE;
            final double maxBankInterestRate = MAX_BANK_INTEREST_RATE - centralBankInterestRate;
            final double bankInterestRateMargin = (random.nextDouble() * maxBankInterestRate) * ((double) (110 - rating) / 100);
            final double interestRate = centralBankInterestRate + bankInterestRateMargin;

            bank.setInterestRate(interestRate);
            return interestRate;
        }
        return 0;
    }

    @Override
    public Bank create(Bank bank) {

        return null;
    }
}
