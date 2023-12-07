import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.exceptions.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl.*;

import java.time.LocalDate;
import java.util.*;

import static tech.reliab.course.BaryshnikovaVD_lab.bank.utils.Constants.*;


public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        AtmService atmService = new AtmServiceImpl();
        UserService userService = new UserServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();

        Map<Integer, Bank> banks = new HashMap<>();
        Map<Integer, User> users = new HashMap<>();

        for (int i = 0; i < BANKS_NUM; i++) {
            Bank bank = bankService.create("Банк " + i);
            banks.put(bank.getId(), bank);

            for (int j = 0; j < BANK_OFFICES_NUM; j++) {
                BankOffice bankOffice = bankOfficeService.create("Офис №" + j + " " + bank.getName(), "Адрес " + j, true, true, true, true, true, 100000, 20000, bank);
                bankService.addBankOffice(bank, bankOffice);

                for (int k = 0; k < EMPLOYEE_NUM; k++) {
                    LocalDate birthday = LocalDate.of(random.nextInt(1990, 2002), random.nextInt(1, 13), random.nextInt(1, 29));
                    String name = NAMES.get(random.nextInt(NAMES.size()));
                    Employee employee = employeeService.create(name, birthday, JobName.getRandom(), bank, false, bankOffice, random.nextInt(80000, 160000));

                    bankService.addEmployee(bank, employee);
                    bankOfficeService.addEmployee(bankOffice, employee);
                }

                for (int k = 0; k < USERS_NUM; k++) {
                    LocalDate birthday = LocalDate.of(random.nextInt(1950, 2010), random.nextInt(1, 13), random.nextInt(1, 29));
                    String name = NAMES.get(random.nextInt(NAMES.size()));
                    User user = userService.create(name, birthday, "Место работы " + k);

                    bankService.addUser(bank, user);
                    users.put(user.getId(), user);
                }
            }

            for (int j = 0; j < BANK_ATM_NUM; j++) {
                BankOffice bankOffice = bank.getBankOffices().get(random.nextInt(bank.getBankOffices().size()));
                Employee employee = bankOffice.getEmployees().get(random.nextInt(bankOffice.getEmployees().size()));
                BankAtm bankAtm = atmService.create("Банкомат " + j,
                        BankAtmStatus.WORK,
                        bankOffice.getBank(),
                        bankOffice,
                        employee,
                        true, true,
                        5000, 50000
                );

                bankService.addAtm(bank, bankAtm);
                bankOfficeService.addAtm(bankOffice, bankAtm);
            }
        }

        for (User user : users.values()) {
            for (int j = 0; j < PAYMENT_ACCOUNTS_NUM; j++) {
                Bank bank = banks.get(random.nextInt(banks.size()));
                PaymentAccount paymentAccount = paymentAccountService.create(user, bank, 1000000);

                userService.addPaymentAccount(user, paymentAccount);
            }

            for (int j = 0; j < CREDIT_ACCOUNTS_NUM; j++) {
                Bank bank = banks.get(random.nextInt(banks.size()));
                Employee employee = bank.getEmployees().get(random.nextInt(bank.getEmployees().size()));
                PaymentAccount paymentAccount = user.getPaymentAccounts().get(random.nextInt(user.getPaymentAccounts().size()));

                LocalDate creditStartDate = LocalDate.of(2022, 1, 20);
                LocalDate creditEndDate = LocalDate.of(2025, 4, 20);
                CreditAccount creditAccount = creditAccountService.create(user, bank, creditStartDate, creditEndDate, 38, 20000000, 25000, 9.6, employee, paymentAccount);

                userService.addCreditAccount(user, creditAccount);
            }
        }

        Scanner scanner = new Scanner(System.in);

        boolean quitProgram = false;
        while (!quitProgram) {
            System.out.println("\nВыберите действие: ");
            System.out.println("1 - Посмотреть информацию о банке ");
            System.out.println("2 - Посмотреть информацию о клиенте банка ");
            System.out.println("3 - Взять кредит");
            System.out.println("0 - Выйти из системы");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.println("\nВыберите банк:  ");
                    for (Bank bank : banks.values())
                        System.out.println(bank.getId() + " - " + bank.getName());

                    System.out.println("\nВведите id банка:  ");
                    int bankId = scanner.nextInt();

                    if (bankId < 5)
                        bankService.printInfo(banks.get(bankId));
                    else
                        System.out.println("\nНеверный id банка!  ");

                    break;

                case 2:
                    System.out.println("\nВыберите клиента: ");
                    for (User user : users.values())
                        System.out.println(user.getId() + " - " + user.getFcs());

                    System.out.println("\nВведите id клиента: ");
                    int selectedUserId = scanner.nextInt();

                    System.out.println(users.get(selectedUserId));
                    userService.printAccounts(users.get(selectedUserId));

                    break;
                case 3:
                    System.out.println("\nВыберите клиента: ");
                    for (User user : users.values())
                        System.out.println(user.getId() + " - " + user.getFcs());

                    System.out.println("\nВведите id: ");
                    int userId = scanner.nextInt();

                    System.out.println("Информация о клиенте: ");
                    User user = users.get(userId);
                    try {
                        if (user != null)
                            System.out.print(user);
                        else
                            throw new NotFoundException("Пользователь с id=" + userId);
                    } catch (NotFoundException e) {
                        System.err.println(e.getMessage());
                        return;
                    }

                    System.out.println("\n\nВведите сумму кредита: ");
                    double creditAmount = scanner.nextDouble();

                    System.out.println("\nВведите количество месяцев, на которые хотите взять кредит: ");
                    int monthsCount = scanner.nextInt();

                    List<Bank> selectedBanks = bankService.selectBanks(banks, creditAmount, monthsCount);
                    System.out.println("\nВыберите банк из списка: \n");
                    for (Bank bank : selectedBanks) {
                        System.out.println("Банк №" + bank.getId() + ":\n" + bank);
                    }

                    System.out.println("\nВведите id банка: ");
                    int scannedBankId = scanner.nextInt();

                    try {
                        if (scannedBankId < selectedBanks.size()) {
                            Bank selectedBank = selectedBanks.get(scannedBankId);
                            System.out.println("\nВыберите банковский офис: \n");
                            List<BankOffice> bankOffices = selectedBank.getBankOffices();
                            for (BankOffice bankOffice : bankOffices)
                                System.out.println("Офис №" + bankOffice.getId() + ":\n" + bankOffice);

                            System.out.println("\nВведите id банковского офиса: ");
                            int scannedBankOfficeId = scanner.nextInt();
                            BankOffice selectedOffice;

                            try {
                                List<Integer> bankOfficesIds = bankOffices
                                        .stream()
                                        .map(BankOffice::getId)
                                        .toList();

                                if (bankOfficesIds.contains(scannedBankOfficeId)) {
                                    selectedOffice = bankOffices
                                            .stream()
                                            .filter((bankOffice -> bankOffice.getId() == scannedBankOfficeId))
                                            .toList().get(0);

                                    if (bankOfficeService.checkBankOffice(selectedOffice, creditAmount))
                                        System.out.println("\nВыбран офис №" + selectedOffice.getId() + ":\n" + selectedOffice);
                                } else
                                    throw new BankOfficeException("Неверный id банка офиса!", scannedBankOfficeId);
                            } catch (BankOfficeException e) {
                                System.err.println(e.getMessage());
                                return;
                            }

                            List<Employee> officeEmployees = selectedOffice.getEmployees()
                                    .stream()
                                    .filter((Employee::canWithdrawCredit))
                                    .toList();

                            try {
                                if (officeEmployees.isEmpty())
                                    throw new BankOfficeException("В офисе нет сотрудников, выдающих кредиты.", selectedOffice.getId());
                            } catch (BankOfficeException e) {
                                System.err.println(e.getMessage());
                                return;
                            }

                            Employee officeEmployee = officeEmployees.get(0);
                            System.out.println("Вам назначен сотрудник для выдачи кредита: id=" + officeEmployee.getId() + " " + officeEmployee.getFcs() + "\n");


                            PaymentAccount paymentAccount;
                            try {
                                paymentAccount = userService.getBestPaymentAccount(user, selectedBank.getId());
                            } catch (PaymentAccountNotFoundException e) {
                                paymentAccount = paymentAccountService.create(user, selectedBank, 0);
                                userService.addPaymentAccount(user, paymentAccount);
                            }

                            CreditAccount creditAccount = creditAccountService.create(user, selectedBank, LocalDate.now(), monthsCount, creditAmount, 0, 0, officeEmployee, paymentAccount);

                            System.out.println("Одобряем кредит...");

                            try {
                                if (bankService.approveCredit(selectedBank, creditAccount, creditAmount, officeEmployee)) {
                                    System.out.println("Кредит был одобрен! \n");
                                } else {
                                    System.out.println("Кредит не был одобрен.");
                                }
                            } catch (CreditException | NotFoundException e) {
                                System.err.println(e.getMessage());
                                return;
                            }

                            System.out.println("Оформляем кредит...");
                            try {
                                if (bankService.withdrawCredit(selectedBank, creditAccount, officeEmployee, selectedOffice, user)) {
                                    System.out.println("Вам был выдан кредит. \n" + "Ваш кредитный счёт: №" + creditAccount.getId() + "\n\n" + creditAccount);
                                } else {
                                    System.out.println("Кредит не был оформлен.");
                                }
                            } catch (CreditException | NotFoundException e) {
                                System.err.println(e.getMessage());
                                return;
                            }

                        } else {
                            throw new BankException("Неверный id банка");
                        }
                    } catch (BankException e) {
                        System.err.println(e.getMessage());
                        return;
                    }

                    break;
                case 0:
                    quitProgram = true;
                    break;
                default:
                    System.err.println("\nНеизвестная команда.\n");
            }
        }

        scanner.close();

    }
}