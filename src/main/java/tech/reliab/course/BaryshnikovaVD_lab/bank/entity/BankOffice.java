package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.UUID;

public class BankOffice {
    private static int currentId;

    @Expose(serialize = true)
    private int id;

    @Expose(serialize = true)
    private String name;

    @Expose(serialize = true)
    private String address;

    @Expose(serialize = true)
    private boolean isWorking;

    @Expose(serialize = true)
    private boolean isPossibleToPlaceAtm;

    @Expose(serialize = true)
    private boolean isCreditAvailable;

    @Expose(serialize = true)
    private boolean isMoneyWithdrawAvailable;

    @Expose(serialize = true)
    private boolean isDepositMoneyAvailable;

    @Expose(serialize = true)
    private double moneyAmount;

    @Expose(serialize = true)
    private double rentPrice;

    @Expose(serialize = false)
    private ArrayList<BankAtm> bankAtms;

    @Expose(serialize = false)
    private ArrayList<Employee> employees;

    @Expose(serialize = true)
    private Bank bank;

    public BankOffice(String name, String address, boolean isWorking, boolean isPossibleToPlaceAtm, boolean isCreditAvailable, boolean isMoneyWithdrawAvailable, boolean isDepositMoneyAvailable, double moneyAmount, double rentPrice, Bank bank) {
        id = currentId++;
        this.bankAtms = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.name = name;
        this.address = address;
        this.isWorking = isWorking;
        this.isPossibleToPlaceAtm = isPossibleToPlaceAtm;
        this.isCreditAvailable = isCreditAvailable;
        this.isMoneyWithdrawAvailable = isMoneyWithdrawAvailable;
        this.isDepositMoneyAvailable = isDepositMoneyAvailable;
        this.moneyAmount = moneyAmount;
        this.rentPrice = rentPrice;
        this.bank = bank;
    }

    public BankOffice(BankOffice bankOffice) {
        this(bankOffice.name, bankOffice.address, bankOffice.isWorking, bankOffice.isPossibleToPlaceAtm, bankOffice.isCreditAvailable, bankOffice.isMoneyWithdrawAvailable, bankOffice.isDepositMoneyAvailable, bankOffice.moneyAmount, bankOffice.rentPrice, bankOffice.bank);
    }

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "Название: " + name + "\n" +
                "Адрес: " + address + "\n" +
                "Банк: " + bank.getName() + "\n" +
                "Статус: " + (isWorking ? "работает" : "не работает") + "\n" +
                (isPossibleToPlaceAtm ? "Можно" : "Нельзя") + " разместить банкомат\n" +
                "Кол-во банкоматов: " + bankAtms.size() + "\n" +
                "Кол-во сотрудников: " + employees.size() + "\n" +
                (isCreditAvailable ? "Можно" : "Нельзя") + " оформить кредит\n" +
                (isMoneyWithdrawAvailable ? "Р" : "Не р") + "аботает на выдачу денег\n" +
                (isDepositMoneyAvailable ? "Можно" : "Нельзя") + " внести деньги\n" +
                "Кол-во денег: " + String.format("%.2f", moneyAmount) + "\n" +
                "Стоимость аренды: " + String.format("%.2f", rentPrice) + "\n";
    }

    public JsonObject toJson() {
        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("id", id);
        jsonObject.addProperty("name", name);
        jsonObject.addProperty("address", address);
        jsonObject.add("bank", bank.toJson());
        jsonObject.addProperty("isWorking", isWorking);
        jsonObject.addProperty("isPossibleToPlaceAtm", isPossibleToPlaceAtm);
        jsonObject.addProperty("isCreditAvailable", isCreditAvailable);
        jsonObject.addProperty("isMoneyWithdrawAvailable", isMoneyWithdrawAvailable);
        jsonObject.addProperty("isDepositMoneyAvailable", isDepositMoneyAvailable);
        jsonObject.addProperty("moneyAmount", moneyAmount);
        jsonObject.addProperty("rentPrice", rentPrice);

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public boolean isMoneyWithdrawAvailable() {
        return isMoneyWithdrawAvailable;
    }

    public void setMoneyWithdrawAvailable(boolean moneyWithdrawAvailable) {
        isMoneyWithdrawAvailable = moneyWithdrawAvailable;
    }

    public boolean isCreditAvailable() {
        return isCreditAvailable;
    }

    public void setCreditAvailable(boolean creditAvailable) {
        isCreditAvailable = creditAvailable;
    }

    public boolean isDepositMoneyAvailable() {
        return isDepositMoneyAvailable;
    }

    public void setDepositMoneyAvailable(boolean depositMoneyAvailable) {
        isDepositMoneyAvailable = depositMoneyAvailable;
    }

    public boolean isPossibleToPlaceAtm() {
        return isPossibleToPlaceAtm;
    }

    public void setPossibleToPlaceAtm(boolean possibleToPlaceAtm) {
        isPossibleToPlaceAtm = possibleToPlaceAtm;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public ArrayList<BankAtm> getBankAtms() {
        return bankAtms;
    }

    public void setBankAtms(ArrayList<BankAtm> bankAtms) {
        this.bankAtms = bankAtms;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
