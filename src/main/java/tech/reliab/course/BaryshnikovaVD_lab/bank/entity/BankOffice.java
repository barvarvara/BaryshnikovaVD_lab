package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import java.util.UUID;

public class BankOffice {
    private int id;
    private String name;
    private String address;
    private boolean isWorking;
    private boolean isPossibleToPlaceAtm;
    private int numAtm;
    private boolean isCreditAvailable;
    private boolean isMoneyWithdrawAvailable;
    private boolean isDepositMoneyAvailable;
    private double moneyAmount;
    private double rentPrice;
    private Bank bank;

    public BankOffice(String name, String address, boolean isWorking, boolean isPossibleToPlaceAtm, int numAtm, boolean isCreditAvailable, boolean isMoneyWithdrawAvailable, boolean isDepositMoneyAvailable, double moneyAmount, double rentPrice, Bank bank) {
        id = Math.abs(UUID.randomUUID().hashCode());
        this.name = name;
        this.address = address;
        this.isWorking = isWorking;
        this.isPossibleToPlaceAtm = isPossibleToPlaceAtm;
        this.numAtm = numAtm;
        this.isCreditAvailable = isCreditAvailable;
        this.isMoneyWithdrawAvailable = isMoneyWithdrawAvailable;
        this.isDepositMoneyAvailable = isDepositMoneyAvailable;
        this.moneyAmount = moneyAmount;
        this.rentPrice = rentPrice;
        this.bank = bank;
    }

    public BankOffice(BankOffice bankOffice) {
        this(bankOffice.name, bankOffice.address, bankOffice.isWorking, bankOffice.isPossibleToPlaceAtm, bankOffice.numAtm, bankOffice.isCreditAvailable, bankOffice.isMoneyWithdrawAvailable, bankOffice.isDepositMoneyAvailable, bankOffice.moneyAmount, bankOffice.rentPrice, bankOffice.bank);
    }

    @Override
    public String toString() {
        return "Информация об офисе банка" + "\n" +
                "id: " + id + "\n" +
                "Название: " + name + "\n" +
                "Адрес: " + address + "\n" +
                "Банк: " + bank.getName() + "\n" +
                "Статус: " + (isWorking ? "работает" : "не работает") + "\n" +
                "Можно ли разместить банкомат? " + (isPossibleToPlaceAtm ? "да" : "нет") + "\n" +
                "Кол-во банкоматов в данном офисе: " + numAtm + "\n" +
                "Можно ли оформить кредит в данном офисе? " + (isCreditAvailable ? "да" : "нет") + "\n" +
                "Работает ли на выдачу денег? " + (isMoneyWithdrawAvailable ? "да" : "нет") + "\n" +
                "Можно ли внести деньги? " + (isDepositMoneyAvailable ? "да" : "нет") + "\n" +
                "Кол-во денег в банковском офисе: " + String.format("%.2f", moneyAmount) + "\n" +
                "Стоимость аренды банковского офиса: " + String.format("%.2f", rentPrice) + "\n\n";
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

    public int getNumAtm() {
        return numAtm;
    }

    public void setNumAtm(int numAtm) {
        this.numAtm = numAtm;
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
}