package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Класс сущности Банк
 */
public class Bank {
    /**
     * Статическое поле currentId для определения id следующего объекта класса
     */
    private static int currentId;

    /**
     * Поле id
     */
    @Expose(serialize = true)
    private int id;

    /**
     * Название банка
     */
    @Expose(serialize = true)
    private String name;

    /**
     * Массив банкоматов банка
     */
    @Expose(serialize = false)
    private ArrayList<BankAtm> bankAtms;

    /**
     * Массив офисов банка
     */
    @Expose(serialize = false)
    private ArrayList<BankOffice> bankOffices;

    /**
     * Массив сотрудников банка
     */
    @Expose(serialize = false)
    private ArrayList<Employee> employees;

    /**
     * Массив клиентов банка
     */
    @Expose(serialize = false)
    private ArrayList<User> users;

    /**
     * Рейтинг банка
     */
    @Expose(serialize = true)
    private int rating;

    /**
     * Всего денег в банке
     */
    @Expose(serialize = true)
    private double totalAmountMoney;

    /**
     * Процентная ставка
     */
    @Expose(serialize = true)
    private double interestRate;

    /**
     * Конструктор класса Банк
     *
     * @param name Название банка
     */
    public Bank(String name) {
        this.id = currentId++;
        this.name = name;
        this.bankOffices = new ArrayList<>();
        this.bankAtms = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.users = new ArrayList<>();
        this.rating = 0;
        this.totalAmountMoney = 0;
        this.interestRate = 0;
    }

    /**
     * Конструктор копирования класса Банк
     *
     * @param bank Банк, информация из которого копируется в создаваемый банк
     */
    public Bank(Bank bank) {
        this(bank.name);
    }

    /**
     * Переопределенный метод toString
     *
     * @return возвращает представление объекта класса Банк в виде строки
     */
    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "Название: " + name + "\n" +
                "Рейтинг банка: " + rating + "\n" +
                "Кол-во офисов: " + bankOffices.size() + "\n" +
                "Кол-во банкоматов: " + bankAtms.size() + "\n" +
                "Кол-во сотрудников: " + employees.size() + "\n" +
                "Кол-во клиентов: " + users.size() + "\n" +
                "Всего денег в банке: " + String.format("%.2f", totalAmountMoney) + "\n" +
                "Процентная ставка: " + String.format("%.2f", interestRate) + "\n";
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", id);
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("rating", rating);
        jsonObject.addProperty("totalAmountMoney", totalAmountMoney);
        jsonObject.addProperty("interestRate", interestRate);

        return jsonObject;
    }

    public String getName() {
        return name;
    }

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

    public ArrayList<BankAtm> getBankAtms() {
        return bankAtms;
    }

    public void setBankAtms(ArrayList<BankAtm> bankAtms) {
        this.bankAtms = bankAtms;
    }

    public ArrayList<BankOffice> getBankOffices() {
        return bankOffices;
    }

    public void setBankOffices(ArrayList<BankOffice> bankOffices) {
        this.bankOffices = bankOffices;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
