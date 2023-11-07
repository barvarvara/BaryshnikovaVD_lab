import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl.*;

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        Bank bank = bankService.create(new Bank("Сбер"));
        System.out.print(bank);

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        BankOffice bankOffice = bankOfficeService.create(new BankOffice("Офис банка 1", "ул. Королева, 2Г", true, true, true, true, true, 10000000, 10000, bank));
        bankService.addBankOffice(bank, bankOffice);
        System.out.print(bankOffice);

        EmployeeService employeeService = new EmployeeServiceImpl();
        LocalDate birthday = LocalDate.of(2002, 8, 10);
        Employee employee = employeeService.create(new Employee("Employee manager 1", birthday, JobName.MANAGER, bank, false, bankOffice, true, 151000));
        bankService.addEmployee(bank, employee);
        bankOfficeService.addEmployee(bankOffice, employee);
        System.out.print(employee);

        AtmService atmService = new AtmServiceImpl();
        BankAtm bankAtm = atmService.create(new BankAtm("Банкомат 1", BankAtmStatus.WORK, bank, bankOffice, employee, true, true, 5000, 50000));
        bankService.addAtm(bank, bankAtm);
        bankOfficeService.addAtm(bankOffice, bankAtm);
        System.out.print(bankAtm);

        UserService userService = new UserServiceImpl();
        birthday = LocalDate.of(1998, 5, 1);
        User user = userService.create(new User("User 1", birthday, "Белгород", bank, 60000, 1000));
        bankService.addUser(bank, user);
        System.out.print(user);

        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        PaymentAccount paymentAccount = paymentAccountService.create(new PaymentAccount(user, bank, 1000000));
        System.out.print(paymentAccount);

        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        LocalDate creditStartDate = LocalDate.of(2022, 1, 20);
        LocalDate creditEndDate = LocalDate.of(2025, 4, 20);
        CreditAccount creditAccount = creditAccountService.create(new CreditAccount(user, bank, creditStartDate, creditEndDate, 38, 20000000, 25000, 9.6, employee, paymentAccount));
        System.out.print(creditAccount);

        System.out.print(bank);
    }
}