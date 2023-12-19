package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Bank;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.CreditAccount;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.PaymentAccount;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.User;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Map;

public interface UserService {
    User create(String fcs, LocalDate birthday, String workplace);

    void delete(User user);

    boolean addCreditAccount(User user, CreditAccount creditAccount);

    boolean deleteCreditAccount(User user, CreditAccount creditAccount);

    boolean addPaymentAccount(User user, PaymentAccount paymentAccount);

    boolean deletePaymentAccount(User user, PaymentAccount paymentAccount);

    void printAccounts(User user);

    PaymentAccount getBestPaymentAccount(User user, int bankId);

    boolean exportUserAccountsToTxtFile(User user, Bank bank);
}
