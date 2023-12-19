package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Map;

public interface CreditAccountService {
    CreditAccount create(User user, Bank bank, LocalDate startDate, LocalDate endDate, int monthsCount, double creditAmount, double monthlyPayment, double interestRate, Employee bankEmployee, PaymentAccount paymentAccount);

    CreditAccount create(User user, Bank bank, LocalDate startDate, int monthsCount, double creditAmount, double monthlyPayment, double interestRate, Employee bankEmployee, PaymentAccount paymentAccount);

    void delete(CreditAccount account);

    boolean makeMonthlyPayment(CreditAccount account);

    boolean transferAccountToAnotherBank(String fileName, Bank otherBank, Map<Integer, User> users, Map<Integer, Bank> banks) throws FileNotFoundException;
}
