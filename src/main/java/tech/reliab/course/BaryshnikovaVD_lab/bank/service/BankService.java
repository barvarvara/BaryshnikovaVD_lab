package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;

import java.util.List;
import java.util.Map;

/**
 * Сервис для работы с сущностью Банк
 */
public interface BankService {
    /**
     * Создает новый банк
     *
     * @param name название нового банка
     * @return возвращает созданный новый банк
     */
    Bank create(String name);

    /**
     * Удаляет банк (обнуляет его поля)
     *
     * @param bank объект класса Банк, который будет удалён
     */
    void delete(Bank bank);

    /**
     * Добавляет в банк новый офис банка
     *
     * @param bank   банк, в который будет добавлен офис
     * @param office офис банка, который будет добавлен
     * @return true, если удалось добавить офис, false -- в противном случае
     */
    boolean addBankOffice(Bank bank, BankOffice office);

    /**
     * Удаляет офис из банка
     *
     * @param bank   банк, в котором удаляется офис
     * @param office офис банка, который будет удален
     * @return true, если получилось удалить банк офиса, false -- в противном случае
     */
    boolean deleteBankOffice(Bank bank, BankOffice office);

    /**
     * Добавляет сотрудника в банк
     *
     * @param bank     банк, в который будет добавлен сотрудник
     * @param employee сотрудник, который будет добавлен
     * @return true, если получилось добавить сотрудника в банк, false -- в противном случае
     */
    boolean addEmployee(Bank bank, Employee employee);

    /**
     * Добавляет банкомат в банк
     *
     * @param bank банк, в который будет добавлен сотрудник
     * @param atm  банкомат, принадлежащий банку
     * @return true, если получилось добавить банкомат в банк, false -- в противном случае
     */
    boolean addAtm(Bank bank, BankAtm atm);

    /**
     * Добавляет клиента в банк
     *
     * @param bank банк, в который будет добавлен сотрудник
     * @param user клиент банка
     * @return true, если получилось добавить клиента в банк, false -- в противном случае
     */
    boolean addUser(Bank bank, User user);

    /**
     * Удаляет сотрудника из банка
     *
     * @param bank     банк, из которого удалется сотрудник
     * @param employee сотрудника, которого нужно удалить из банка
     * @return true, если получилось удалить сотрудника, false -- в противном случае
     */
    boolean deleteEmployee(Bank bank, Employee employee);

    /**
     * Вносит moneyAmount денег в банк
     *
     * @param bank        банк, в который нужно внести сумму
     * @param moneyAmount кол-во денег, которые нужно внести
     * @return true, если получилось внести сумму в банк, false -- в противном случае
     */
    boolean depositMoney(Bank bank, double moneyAmount);

    /**
     * Выдает деньги из банка
     *
     * @param bank        банк, из которого нужно произвести выдачу денег
     * @param moneyAmount сумма, которую нужно выдать
     * @return true, если получилось выдать нужную сумму, false -- в противном случае
     */
    boolean withdrawMoney(Bank bank, double moneyAmount);

    /**
     * Выводит информацию о банке
     *
     * @param bank банк, информацию о котором, нужно вывести в консоль
     */
    public void printInfo(Bank bank);

    /**
     * Логика одобрения кредита банком для кредитного счёта
     * @param bank  банк, который выдает кредит
     * @param account кредитный счет
     * @param employee работник, который выдает кредит
     * @return true, если кредит был одобрен, false -- в противном случае
     */
    public boolean approveCredit(Bank bank, CreditAccount account, double moneyAmount, Employee employee);

    public boolean withdrawCredit(Bank bank, CreditAccount account, Employee employee, BankOffice bankOffice, User user);

    public boolean isBankSuitable(Bank bank, Double amount);

    public List<Bank> selectBanks(Map<Integer, Bank> banks, Double amount, int monthsCount);
}
