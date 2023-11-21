import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.*;
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
                BankOffice bankOffice = bankOfficeService.create("Офис №" + j + " " + bank.getName(), "Адрес " + j, true, true, true, true, true, 10000000, 10000, bank);
                bankService.addBankOffice(bank, bankOffice);

                for (int k = 0; k < EMPLOYEE_NUM; k++) {
                    LocalDate birthday = LocalDate.of(random.nextInt(1990, 2002), random.nextInt(1, 13), random.nextInt(1, 29));
                    String name = NAMES.get(random.nextInt(NAMES.size()));
                    Employee employee = employeeService.create(name, birthday, JobName.getRandom(), bank, false, bankOffice, true, random.nextInt(80000, 160000));

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
            System.out.println("3 - Выйти из системы");

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
                    int userId = scanner.nextInt();

                    System.out.println(users.get(userId));
                    userService.printAccounts(users.get(userId));

                    break;
                case 3:
                    quitProgram = true;
                    break;
                default:
                    System.out.println("\nНеизвестная команда.\n");

            }
        }

    }

}