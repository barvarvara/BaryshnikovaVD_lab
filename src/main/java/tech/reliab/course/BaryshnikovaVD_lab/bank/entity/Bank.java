package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;
import java.util.UUID;

/**
 * Класс сущности Банк
 */
public class Bank {

    /** Поле айди */
    private int id;

    /** Название банка */
    private String name;

    /** Кол-во банкоматов */
    private int numAtm;

    /** Кол-во офисов */
    private int numOffices;

    /** Кол-во сотрудников */
    private int numEmployee;

    /** Кол-во клиентов */
    private int numUsers;

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
        numOffices = 0;
        numAtm = 0;
        numEmployee = 0;
        numUsers = 0;
        rating = 0;
        totalAmountMoney = 0;
        interestRate = 0;
    }

    /** Конструктор класса Банк
     * @param name Название банка
     * @param numAtm Кол-во банкоматов
     * @param numOffices Кол-во офисов
     * @param numEmployee Кол-во сотрудников
     * @param numUsers Кол-во клиентов
     * */
    public Bank(String name, int numAtm, int numOffices, int numEmployee, int numUsers) {
        this(name);
        this.numOffices = numOffices;
        this.numAtm = numAtm;
        this.numEmployee = numEmployee;
        this.numUsers = numUsers;
    }

    /** Конструктор копирования класса Банк
     * @param bank Банк, информация из которого копируется в создаваемый банк
     * */
    public Bank(Bank bank) {
        this(bank.name, bank.numAtm, bank.numOffices, bank.numEmployee, bank.numUsers);
    }

    /** Переопределенный метод toString
     * @return возвращает представление объекта класса Банк в виде строки
     * */
    @Override
    public String toString() {
        return "Информация о банке" + "\n" +
                "id: " + id + "\n" +
                "Название: " + name + "\n" +
                "Кол-во офисов: " + numOffices + "\n" +
                "Кол-во банкоматов: " + numAtm + "\n" +
                "Кол-во сотрудников: " + numEmployee + "\n" +
                "Кол-во клиентов: " + numUsers + "\n" +
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

    public int getNumAtm() {
        return numAtm;
    }

    public void setNumAtm(int numAtm) {
        this.numAtm = numAtm;
    }

    public int getNumUsers() {
        return numUsers;
    }

    public void setNumUsers(int numUsers) {
        this.numUsers = numUsers;
    }

    public int getNumEmployee() {
        return numEmployee;
    }

    public void setNumEmployee(int numEmployee) {
        this.numEmployee = numEmployee;
    }

    public int getNumOffices() {
        return numOffices;
    }

    public void setNumOffices(int numOffices) {
        this.numOffices = numOffices;
    }
}
