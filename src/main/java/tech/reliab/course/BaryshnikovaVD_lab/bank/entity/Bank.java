package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;
import java.util.UUID;

public class Bank {
    private int id;
    private String name;
    private int numAtm;
    private int numOffices;
    private int numEmployee;
    private int numClients;
    private byte rating;
    private double totalAmountMoney;
    private double interestRate;

    public Bank(String name) {
        id = Math.abs(UUID.randomUUID().hashCode());
        this.name = name;
        numOffices = 0;
        numAtm = 0;
        numEmployee = 0;
        numClients = 0;
        rating = 0;
        totalAmountMoney = 0;
        interestRate = 0;
    }

    public Bank(String name, int numAtm, int numOffices, int numEmployee, int numClients) {
        this(name);
        this.numOffices = numOffices;
        this.numAtm = numAtm;
        this.numEmployee = numEmployee;
        this.numClients = numClients;
    }

    @Override
    public String toString() {
        return "Информация о банке" + "\n" +
                "id: " + id + "\n" +
                "Название: " + name + "\n" +
                "Кол-во офисов: " + numOffices + "\n" +
                "Кол-во банкоматов: " + numAtm + "\n" +
                "Кол-во сотрудников: " + numEmployee + "\n" +
                "Кол-во клиентов: " + numClients + "\n" +
                "Рейтинг банка: " + rating + "\n" +
                "Всего денег в банке: " + String.format("%.2f", totalAmountMoney) + "\n" +
                "Процентная ставка: " + String.format("%.2f", interestRate) + "\n";
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

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
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

    public int getNumClients() {
        return numClients;
    }

    public void setNumClients(int numClients) {
        this.numClients = numClients;
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
