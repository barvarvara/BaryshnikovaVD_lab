package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.BankAtmStatus;

public class BankAtm {
    private static int currentId;

    private int id;
    private String name;
    private String address;
    private BankAtmStatus status;
    private Bank bank;
    private BankOffice bankOffice;
    private Employee employee;
    private boolean isMoneyWithdrawAvailable;
    private boolean isDepositMoneyAvailable;
    private double moneyAmount;
    private double atmServicePrice;

    public BankAtm(String name, BankAtmStatus status, Bank bank, BankOffice bankOffice, Employee employee, boolean isMoneyWithdrawAvailable, boolean isDepositMoneyAvailable, double atmServicePrice, double moneyAmount) {
        id = currentId++;
        this.name = name;
        this.bankOffice = bankOffice;
        this.address = bankOffice.getAddress();
        this.status = status;
        this.bank = bank;
        this.employee = employee;
        this.moneyAmount = moneyAmount;
        this.isMoneyWithdrawAvailable = isMoneyWithdrawAvailable;
        this.isDepositMoneyAvailable = isDepositMoneyAvailable;
        this.atmServicePrice = atmServicePrice;
    }

    public BankAtm(BankAtm bankAtm) {
        this(bankAtm.name, bankAtm.status, bankAtm.bank, bankAtm.bankOffice, bankAtm.employee, bankAtm.isMoneyWithdrawAvailable, bankAtm.isDepositMoneyAvailable, bankAtm.atmServicePrice, bankAtm.moneyAmount);
    }

    @Override
    public String toString() {
        return "Информация о банкомате:" + "\n" +
                "id: " + id + "\n" +
                "Название: " + name + "\n" +
                "Адрес: " + address + "\n" +
                "Статус: " + (status == BankAtmStatus.WORK ? "работает" : (status == BankAtmStatus.DOESNT_WORK ? "не работает" : "нет денег")) + "\n" +
                "Банк: " + bank.getName() + "\n" +
                "Расположение банкомата: " + bankOffice.getName() + " " + bankOffice.getAddress() + "\n" +
                "Обслуживающий сотрудник: " + employee.getFcs() + "\n" +
                (!isMoneyWithdrawAvailable ? "Не р" : "Р") + "аботает на выдачу денег\n" +
                (!isDepositMoneyAvailable ? "Нельзя" : "Можно") + " внести деньги\n" +
                "Кол-во денег в банкомате: " + String.format("%.2f", moneyAmount) + "\n" +
                "Стоимость обслуживания: " + String.format("%.2f", atmServicePrice) + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BankAtmStatus getStatus() {
        return status;
    }

    public void setStatus(BankAtmStatus status) {
        this.status = status;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankOffice getBankOffice() {
        return bankOffice;
    }

    public void setBankOffice(BankOffice bankOffice) {
        this.bankOffice = bankOffice;
    }

    public double getAtmServicePrice() {
        return atmServicePrice;
    }

    public void setAtmServicePrice(double atmServicePrice) {
        this.atmServicePrice = atmServicePrice;
    }

    public double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public boolean isMoneyWithdrawAvailable() {
        return isMoneyWithdrawAvailable;
    }

    public void setMoneyWithdrawAvailable(boolean cashWithdrawAvailable) {
        isMoneyWithdrawAvailable = cashWithdrawAvailable;
    }

    public boolean isDepositMoneyAvailable() {
        return isDepositMoneyAvailable;
    }

    public void setDepositMoneyAvailable(boolean depositCashAvailable) {
        isDepositMoneyAvailable = depositCashAvailable;
    }
}
