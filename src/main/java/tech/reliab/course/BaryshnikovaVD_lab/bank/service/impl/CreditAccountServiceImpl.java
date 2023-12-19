package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.BankService;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.CreditAccountService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CreditAccountServiceImpl implements CreditAccountService {
    @Override
    public CreditAccount create(User user, Bank bank, LocalDate startDate, LocalDate endDate, int monthsCount, double creditAmount, double monthlyPayment, double interestRate, Employee bankEmployee, PaymentAccount paymentAccount) {
        if (bank == null) {
            System.out.println("Ошибка! Невозможно создать счёт без банка");
            return null;
        }

        return new CreditAccount(user, bank, startDate, endDate, monthsCount, creditAmount, monthlyPayment, interestRate, bankEmployee, paymentAccount);
    }

    @Override
    public CreditAccount create(User user, Bank bank, LocalDate startDate, int monthsCount, double creditAmount, double monthlyPayment, double interestRate, Employee bankEmployee, PaymentAccount paymentAccount) {
        if (bank == null) {
            System.out.println("Ошибка! Невозможно создать счёт без банка");
            return null;
        }

        return new CreditAccount(user, bank, startDate, monthsCount, creditAmount, monthlyPayment, interestRate, bankEmployee, paymentAccount);
    }

    @Override
    public void delete(CreditAccount account) {
        account.setBank(null);
        account.setUser(null);
        account.setStartDate(null);
        account.setEndDate(null);
        account.setMonthsCount(0);
        account.setCreditAmount(0);
        account.setMonthlyPayment(0);
        account.setInterestRate(0);
        account.setBankEmployee(null);
        account.setPaymentAccount(null);
    }

    @Override
    public boolean makeMonthlyPayment(CreditAccount account) {
        if (account == null || account.getPaymentAccount() == null) {
            System.out.println("Ошибка! нет счёта, с которого может осуществляться перевод.");
            return false;
        }

        final double monthlyPayment = account.getMonthlyPayment();
        final double balance = account.getPaymentAccount().getBalance();

        if (balance < monthlyPayment) {
            System.out.println("Ошибка! На платежном счете недостаточно средст для оплаты ежемесячного платежа.");
            return false;
        }

        account.getPaymentAccount().setBalance(balance - monthlyPayment);
        account.setCreditAmount(account.getCreditAmount() - monthlyPayment);

        return true;
    }

    @Override
    public boolean transferAccountToAnotherBank(String fileName, Bank otherBank, Map<Integer, User> users, Map<Integer, Bank> banks) throws FileNotFoundException {
        File file = new File(fileName);

        if (!file.exists())
            throw new FileNotFoundException(fileName);

        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        JsonReader jsonReader = new JsonReader(new FileReader(fileName));

        CreditAccount[] creditAccountsJson = gson.fromJson(jsonReader, CreditAccount[].class);

        List<CreditAccount> creditAccounts = Arrays.asList(creditAccountsJson);

        for (CreditAccount creditAccountFrom : creditAccounts) {
            User paymentAccountUser = users.get(creditAccountFrom.getPaymentAccount().getUser().getId());
            ArrayList<CreditAccount> userCreditAccounts = paymentAccountUser.getCreditAccounts();
            int creditAccountId = creditAccountFrom.getId();
            int creditAccountIdx = paymentAccountUser.getCreditAccountIdxById(creditAccountId);

            CreditAccount creditAccountToPay = userCreditAccounts.get(creditAccountIdx);

            if (creditAccountToPay.getBank().getId() == otherBank.getId()) {
                System.out.println("id = " + creditAccountToPay.getId() + " уже был связан с этим банком!");
                return false;
            } else {
                creditAccountToPay.setBank(otherBank);
                creditAccountToPay.getPaymentAccount().setBank(otherBank);
            }

            User userInAccount = users.get(creditAccountToPay.getUser().getId());
            int userBankId = userInAccount.getBank().getId();
            Bank userBank = banks.get(userBankId);

            if (userBankId != otherBank.getId()) {
                BankService bankService = new BankServiceImpl();
                bankService.deleteUser(userBank, userInAccount);
                bankService.addUser(otherBank, userInAccount);
            }

            return true;
        }

        return false;
    }
}
