package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.*;

/**
 * Сервис для работы с сущностью Банк
 */
public interface BankService {
    /**
     * Создает новый банк
     *
     * @param bank объект класса Банк, информация которого копируется в создаваемый
     * @return возвращает созданный новый банк
     */
    Bank create(Bank bank);

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
     * Оформляет заявку на кредит
     *
     * @param bank    банк, в котором клиент хочет взять кредит
     * @param account кредитный счет, который закреплен за клиентом
     * @param user  клиент, который хочет взять кредит
     * @return true, если получилось принять заявку на кредит, false -- в противном случае
     */
    boolean approveCredit(Bank bank, CreditAccount account, User user);
}
