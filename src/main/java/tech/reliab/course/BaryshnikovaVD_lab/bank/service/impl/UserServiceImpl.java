package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.stream.JsonReader;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.exceptions.PaymentAccountNotFoundException;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.BankService;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.UserService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static tech.reliab.course.BaryshnikovaVD_lab.bank.utils.Constants.MAX_MONTHLY_INCOME;

public class UserServiceImpl implements UserService {
    private int calcCreditRating(User user) {
        final double monthlyIncome = user.getMonthlyIncome();
        return (monthlyIncome % 1000 > 0) ? (int) (Math.ceil(monthlyIncome / 1000) * 100) : (int) (monthlyIncome / 10);
    }

    @Override
    public User create(String fcs, LocalDate birthday, String workplace) {
        User newUser = new User(fcs, birthday, workplace);
        newUser.setMonthlyIncome((Math.random() * MAX_MONTHLY_INCOME));
        newUser.setCreditRating(calcCreditRating(newUser));

        return newUser;
    }

    @Override
    public void delete(User user) {
        user.setFcs("");
        user.setBirthday(null);
        user.setWorkplace("");
        user.setMonthlyIncome(0);
        user.setCreditRating(0);
    }

    @Override
    public boolean addCreditAccount(User user, CreditAccount creditAccount) {
        if (user == null || creditAccount == null) {
            System.out.println("Ошибка! не существует клиента или кредитного счёта");
            return false;
        }

        ArrayList<CreditAccount> creditAccounts = user.getCreditAccounts();
        if (creditAccounts == null)
            creditAccounts = new ArrayList<>();

        creditAccounts.add(creditAccount);
        user.setCreditAccounts(creditAccounts);
        creditAccount.setUser(user);

        return true;
    }

    @Override
    public boolean deleteCreditAccount(User user, CreditAccount creditAccount) {
        if (user == null || creditAccount == null) {
            System.out.println("Ошибка! не существует клиента или кредитного счета");
            return false;
        }

        ArrayList<CreditAccount> creditAccounts = user.getCreditAccounts();
        creditAccounts.remove(creditAccount);

        if (creditAccounts.isEmpty())
            user.setCreditAccounts(null);
        else
            user.setCreditAccounts(creditAccounts);

        creditAccount.setUser(null);

        return true;
    }

    @Override
    public boolean addPaymentAccount(User user, PaymentAccount paymentAccount) {
        if (user == null || paymentAccount == null) {
            System.out.println("Ошибка! не существует клиента или платежного счета");
            return false;
        }

        ArrayList<PaymentAccount> paymentAccounts = user.getPaymentAccounts();
        if (paymentAccounts == null)
            paymentAccounts = new ArrayList<>();

        paymentAccounts.add(paymentAccount);
        user.setPaymentAccounts(paymentAccounts);

        return true;
    }

    @Override
    public boolean deletePaymentAccount(User user, PaymentAccount paymentAccount) {
        if (user == null || paymentAccount == null) {
            System.out.println("Ошибка! не существует клиента или платежного счета");
            return false;
        }

        ArrayList<PaymentAccount> paymentAccounts = user.getPaymentAccounts();
        paymentAccounts.remove(paymentAccount);

        if (paymentAccounts.isEmpty())
            user.setPaymentAccounts(null);
        else
            user.setPaymentAccounts(paymentAccounts);

        paymentAccount.setUser(null);

        return true;
    }


    @Override
    public void printAccounts(User user) {
        if (user == null) {
            System.out.println("Ошибка! Клиент не был найден");
            return;
        }

        ArrayList<PaymentAccount> paymentAccounts = user.getPaymentAccounts();
        if (paymentAccounts != null) {
            System.out.println("\nПлатёжные счета: \n");
            paymentAccounts.forEach(System.out::println);
        }

        ArrayList<CreditAccount> creditAccounts = user.getCreditAccounts();
        if (creditAccounts != null) {
            System.out.println("Кредитные счета: \n");
            creditAccounts.forEach(System.out::println);
        }

    }

    @Override
    public PaymentAccount getBestPaymentAccount(User user, int bankId) {
        List<PaymentAccount> selectedPaymentAccounts = user.getPaymentAccounts().stream().filter(paymentAccount -> paymentAccount.getBank().getId() == bankId).toList();

        if (!selectedPaymentAccounts.isEmpty()) {
            PaymentAccount bestPaymentAccount = selectedPaymentAccounts.get(0);

            for (int i = 1; i < selectedPaymentAccounts.size(); i++) {
                PaymentAccount currentPaymentAccount = selectedPaymentAccounts.get(i);
                if (bestPaymentAccount.getBalance() < currentPaymentAccount.getBalance()) {
                    bestPaymentAccount = currentPaymentAccount;
                }
            }

            return bestPaymentAccount;
        } else {
            throw new PaymentAccountNotFoundException();
        }

    }

    @Override
    public boolean exportUserAccountsToTxtFile(User user, Bank bank) {
        try {
            PrintWriter writer = new PrintWriter("accounts.txt");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            List<CreditAccount> creditAccounts = user.getCreditAccounts();
            List<PaymentAccount> paymentAccounts = user.getPaymentAccounts();

            JsonArray creditAccountsToWrite = new JsonArray();
            JsonArray paymentAccountsToWrite = new JsonArray();

            int bankId = bank.getId();
            for (PaymentAccount paymentAccount : paymentAccounts) {
                if (paymentAccount.getBank().getId() == bankId) {
                    creditAccountsToWrite.add(paymentAccount.toJson());
                }
            }

            for (CreditAccount creditAccount : creditAccounts) {
                if (creditAccount.getBank().getId() == bankId) {
                    paymentAccountsToWrite.add(creditAccount.toJson());
                }
            }

            writer.println(gson.toJson(creditAccountsToWrite));
            writer.println(gson.toJson(paymentAccountsToWrite));

            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка! Не удалось записать данные в файл. " + e);
            return false;
        }

        return true;
    }
}
