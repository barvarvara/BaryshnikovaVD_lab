package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;
import java.util.UUID;

/**
 * Класс сущности Банк
 */
public class Bank {

    /** Поле id */
    private int id;

    /** Название банка */
    private String name;

    /** Кол-во банкоматов */
    private int atmCount;

    /** Кол-во офисов */
    private int officesCount;

    /** Кол-во сотрудников */
    private int employeeCount;

    /** Кол-во клиентов */
    private int usersCount;

    /** Рейтинг банка */
    private int rating;

    /** Всего денег в банке */
    private double totalAmountMoney;

    /** Процентная ставка */
    private double interestRate;

    /** Конструктор класса Банк
     * @param name Название банка*/
    public Bank(String name) {
        id = Math.abs(UUID.randomUUID().hashCode());
        this.name = name;
        officesCount = 0;
        atmCount = 0;
        employeeCount = 0;
        usersCount = 0;
        rating = 0;
        totalAmountMoney = 0;
        interestRate = 0;
    }

    /** Конструктор класса Банк
     * @param name Название банка
     * @param atmCount Кол-во банкоматов
     * @param officesCount Кол-во офисов
     * @param employeeCount Кол-во сотрудников
     * @param usersCount Кол-во клиентов
     * */
    public Bank(String name, int atmCount, int officesCount, int employeeCount, int usersCount) {
        this(name);
        this.officesCount = officesCount;
        this.atmCount = atmCount;
        this.employeeCount = employeeCount;
        this.usersCount = usersCount;
    }

    /** Конструктор копирования класса Банк
     * @param bank Банк, информация из которого копируется в создаваемый банк
     * */
    public Bank(Bank bank) {
        this(bank.name, bank.atmCount, bank.officesCount, bank.employeeCount, bank.usersCount);
    }

    /** Переопределенный метод toString
     * @return возвращает представление объекта класса Банк в виде строки
     * */
    @Override
    public String toString() {
        return "Информация о банке" + "\n" +
                "id: " + id + "\n" +
                "Название: " + name + "\n" +
                "Кол-во офисов: " + officesCount + "\n" +
                "Кол-во банкоматов: " + atmCount + "\n" +
                "Кол-во сотрудников: " + employeeCount + "\n" +
                "Кол-во клиентов: " + usersCount + "\n" +
                "Рейтинг банка: " + rating + "\n" +
                "Всего денег в банке: " + String.format("%.2f", totalAmountMoney) + "\n" +
                "Процентная ставка: " + String.format("%.2f", interestRate) + "\n\n";
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalAmountMoney() {
        return totalAmountMoney;
    }

    public void setTotalAmountMoney(double totalAmountMoney) {
        this.totalAmountMoney = totalAmountMoney;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getAtmCount() {
        return atmCount;
    }

    public void setAtmCount(int atmCount) {
        this.atmCount = atmCount;
    }

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getOfficesCount() {
        return officesCount;
    }

    public void setOfficesCount(int officesCount) {
        this.officesCount = officesCount;
    }
}
