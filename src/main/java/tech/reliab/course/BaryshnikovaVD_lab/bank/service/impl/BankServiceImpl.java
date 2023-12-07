package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;
import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.BankAtmStatus;
import tech.reliab.course.BaryshnikovaVD_lab.bank.exceptions.CreditException;
import tech.reliab.course.BaryshnikovaVD_lab.bank.exceptions.NotFoundException;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.*;

import java.time.LocalDate;
import java.util.*;

import static tech.reliab.course.BaryshnikovaVD_lab.bank.utils.Constants.*;

public class BankServiceImpl implements BankService {
    @Override
    public Bank create(String name) {
        Bank newBank = new Bank(name);

        newBank.setRating((int) (Math.random() * MAX_BANK_RATING));
        newBank.setTotalAmountMoney(Math.random() * MAX_TOTAL_MONEY);
        newBank.setInterestRate(calcInterestRate(newBank));

        return newBank;
    }

    @Override
    public void delete(Bank bank) {
        bank.setName("");
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
            System.out.println("Ошибка! не существует банка или офиса банка");
            return false;
        }

        ArrayList<BankOffice> bankOffices = bank.getBankOffices();
        if (bankOffices == null)
            bankOffices = new ArrayList<>();

        bankOffices.add(office);
        bank.setBankOffices(bankOffices);
        office.setBank(bank);

        return true;
    }

    @Override
    public boolean deleteBankOffice(Bank bank, BankOffice office) {
        if (bank == null || office == null) {
            System.out.println("Ошибка! не существует банка или офиса банка");
            return false;
        }

        office.setBank(null);

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        ArrayList<BankAtm> bankAtms = office.getBankAtms();
        bankAtms.forEach(bankAtm -> {
            bankOfficeService.deleteAtm(office, bankAtm);
        });

        ArrayList<Employee> employees = office.getEmployees();
        employees.forEach(employee -> {
            bankOfficeService.deleteEmployee(office, employee);
        });

        ArrayList<BankOffice> bankOffices = bank.getBankOffices();
        if (bankOffices.isEmpty()) {
            System.out.println("Ошибка! невозможно удалить офис, т.к. за банком не закреплено офисов");
            return false;
        } else {
            bankOffices.remove(office);
            if (bankOffices.isEmpty())
                bank.setBankOffices(null);
            else
                bank.setBankOffices(bankOffices);
        }

        return true;
    }

    @Override
    public boolean addAtm(Bank bank, BankAtm atm) {
        if (bank == null || atm == null) {
            System.out.println("Ошибка! не существует банка или банкомата");
            return false;
        }

        ArrayList<BankAtm> bankAtms = bank.getBankAtms();
        if (bankAtms == null)
            bankAtms = new ArrayList<>();

        bankAtms.add(atm);

        atm.setBank(bank);
        bank.setBankAtms(bankAtms);

        return true;
    }

    @Override
    public boolean addUser(Bank bank, User user) {
        if (bank == null || user == null) {
            System.out.println("Ошибка! не существует банка или клиента");
            return false;
        }

        ArrayList<User> bankUsers = bank.getUsers();
        if (bankUsers == null)
            bankUsers = new ArrayList<>();

        bankUsers.add(user);
        bank.setUsers(bankUsers);


        ArrayList<Bank> userBanks = user.getBanks();
        if (userBanks == null)
            userBanks = new ArrayList<>();

        userBanks.add(bank);
        user.setBanks(userBanks);

        return true;
    }


    @Override
    public boolean addEmployee(Bank bank, Employee employee) {
        if (bank == null || employee == null) {
            System.out.println("Ошибка! не существует банка или сотрудника банка");
            return false;
        }

        ArrayList<Employee> employees = bank.getEmployees();
        if (employees == null)
            employees = new ArrayList<>();

        employee.setWorkingAtHome(false);
        employee.setBank(bank);
        employees.add(employee);

        bank.setEmployees(employees);

        return true;
    }

    @Override
    public boolean deleteEmployee(Bank bank, Employee employee) {
        if (bank == null || employee == null) {
            System.out.println("Ошибка! не существует банка или сотрудника банка");
            return false;
        }

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();

        if (!employee.isWorkingAtHome()) {
            ArrayList<BankOffice> bankOffices = bank.getBankOffices();
            BankOffice bankOffice = bankOffices.get(bankOffices.indexOf(employee.getBankOffice()));
            bankOfficeService.deleteEmployee(bankOffice, employee);
        }

        employee.setBank(null);
        employee.setBankOffice(null);

        ArrayList<Employee> employees = bank.getEmployees();
        if (employees.isEmpty()) {
            System.out.println("Ошибка! невозможно убрать сотрудника, т.к. за банком не закреплен ни один сотрудник");
            return false;
        } else {
            employees.remove(employee);
            if (employees.isEmpty())
                bank.setEmployees(null);
            else
                bank.setEmployees(employees);
        }

        return true;
    }

    @Override
    public boolean depositMoney(Bank bank, double moneyAmount) {
        if (bank == null) {
            System.out.println("Ошибка! Несуществующий банк.");
            return false;
        }

        bank.setTotalAmountMoney(bank.getTotalAmountMoney() + moneyAmount);

        return true;
    }

    @Override
    public boolean withdrawMoney(Bank bank, double moneyAmount) {
        if (bank == null) {
            System.out.println("Ошибка! Несуществующий банк.");
            return false;
        }

        if (bank.getTotalAmountMoney() < moneyAmount) {
            System.out.println("Ошибка! Недостаточно средств в банке для выдачи необходимой суммы");
            return false;
        }

        bank.setTotalAmountMoney(bank.getTotalAmountMoney() - moneyAmount);

        return true;
    }

    @Override
    public void printInfo(Bank bank) {
        if (bank == null) {
            System.out.println("Ошибка! Банк не был найден");
            return;
        }

        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nИнформация о банке: \n" + bank.toString());

        System.out.println("Офисы банка: \n");
        ArrayList<BankOffice> bankOffices = bank.getBankOffices();
        bankOffices.forEach((System.out::println));

        System.out.println("Банкоматы: \n");
        ArrayList<BankAtm> bankAtms = bank.getBankAtms();
        bankAtms.forEach((System.out::println));

        System.out.println("Сотрудники: \n");
        ArrayList<Employee> employees = bank.getEmployees();
        employees.forEach((System.out::println));

        System.out.println("Клиенты: \n");
        ArrayList<User> users = bank.getUsers();
        users.forEach((System.out::println));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
    }


    @Override
    public boolean approveCredit(Bank bank, CreditAccount account, double moneyAmount, Employee employee) throws CreditException, NotFoundException {
        if (account != null && bank != null && employee != null) {
            double creditMoneyAmount = account.getCreditAmount();

            if (bank.getTotalAmountMoney() >= creditMoneyAmount) {
                double paymentPerMonth = creditMoneyAmount * (bank.getInterestRate() / 100 + 1) / account.getMonthsCount();

                if (account.getUser().getMonthlyIncome() >= paymentPerMonth) {
                    if (account.getUser().getCreditRating() < 5000 && bank.getRating() > 50) {
                        throw new CreditException("Слишком низкий рейтинг для выдачи кредита: рейтинг клиента = " + account.getUser().getCreditRating() + ", рейтинг банка = " + bank.getRating());
                    }

                    account.setBankEmployee(employee);
                    account.setMonthlyPayment(paymentPerMonth);
                    account.setBank(bank);
                    account.setInterestRate(bank.getInterestRate());

                    LocalDate dateEnd = account.getStartDate();
                    dateEnd = dateEnd.plusMonths(account.getMonthsCount());
                    account.setEndDate(dateEnd);

                    return true;
                } else {
                    throw new CreditException("У клиента недостаточный ежемесячный доход: " + account.getUser().getMonthlyIncome() + " < " + paymentPerMonth);
                }
            }
        } else {
            throw new NotFoundException("Аккаунт, банк или сотрудник банка");
        }
        return false;
    }

    @Override
    public boolean withdrawCredit(Bank bank, CreditAccount account, Employee employee, BankOffice bankOffice, User user) throws NotFoundException {
        if (account != null && bank != null && employee != null) {
            List<BankAtm> bankAtms = bankOffice.getBankAtms();

            for (BankAtm atm : bankAtms) {
                if (atm.getStatus() == BankAtmStatus.WORK && atm.getMoneyAmount() >= account.getCreditAmount()) {
                    UserService userService = new UserServiceImpl();
                    userService.addCreditAccount(user, account);

                    AtmService atmService = new AtmServiceImpl();
                    atmService.withdrawMoney(atm, account.getCreditAmount());

                    return true;
                }
            }
        } else {
            throw new NotFoundException("Аккаунт, банк или сотрудник банка");
        }

        throw new NotFoundException("Подходящий банкомат");
    }

    @Override
    public boolean isBankSuitable(Bank bank, Double amount) {
        List<BankOffice> bankOffices = bank.getBankOffices();
        List<BankOffice> bankOfficesSuitable = new ArrayList<>();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();

        for (BankOffice bankOffice : bankOffices) {
            if (bankOfficeService.isBankOfficeSuitable(bankOffice, amount)) {
                bankOfficesSuitable.add(bankOffice);
            }
        }

        return !(bankOfficesSuitable.isEmpty());
    }

    @Override
    public List<Bank> selectBanks(Map<Integer, Bank> banks, Double amount, int monthsCount) throws CreditException {
        List<Bank> selectedBanks = new ArrayList<>();
        for (Bank bank : banks.values())
            if (isBankSuitable(bank, amount))
                selectedBanks.add(bank);

        if (selectedBanks.isEmpty())
            throw new CreditException("Не найдено ни одного подходящего банка для получения кредита с параметрами: amount=" + amount + " monthsCount=" + monthsCount);

        return selectedBanks;
    }


}
