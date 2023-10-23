package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.BankAtmStatus;

import java.util.UUID;

public class BankAtm {
    private int id;
    private String name;
    private String address;
    private BankAtmStatus status;
    private Bank bank;
    private BankOffice bankOffice;
    private Employee employee;
    private boolean isCashWithdrawAvailable;
    private boolean isDepositCashAvailable;
    private double numMoney;
    private double atmServicePrice;

    public BankAtm(String name, BankAtmStatus status, Bank bank, BankOffice location, String address, Employee employee, boolean isCashWithdrawAvailable, boolean isDepositCashAvailable, double atmServicePrice, double numMoney) {
        id = Math.abs(UUID.randomUUID().hashCode());
        this.name = name;
        this.bankOffice = location;
        this.address = address;
        this.status = status;
        this.bank = bank;
        this.employee = employee;
        this.numMoney = numMoney;
        this.isCashWithdrawAvailable = isCashWithdrawAvailable;
        this.isDepositCashAvailable = isDepositCashAvailable;
        this.atmServicePrice = atmServicePrice;
    }

    public BankAtm(BankAtm bankAtm) {
        this(bankAtm.name, bankAtm.status, bankAtm.bank, bankAtm.bankOffice, bankAtm.address, bankAtm.employee, bankAtm.isCashWithdrawAvailable, bankAtm.isDepositCashAvailable, bankAtm.atmServicePrice, bankAtm.numMoney);
    }

    @Override
    public String toString() {
        return "Информация о банкомате" + "\n" +
                "id: " + id + "\n" +
                "Название: " + name + "\n" +
                "Адрес: " + address + "\n" +
                "Статус: " + (status == BankAtmStatus.WORK ? "работает" : (status == BankAtmStatus.DOESNT_WORK ? "не работает" : "нет денег")) + "\n" +
                "Банк, которому принадлежит банкомат: " + bank.getName() + "\n" +
                "Расположение банкомата: " + bankOffice.getName() + " " + bankOffice.getAddress() + "\n" +
                "Обслуживающий сотрудник: " + employee.getFcs() + "\n" +
                "Работает ли на выдачу денег? " + (isCashWithdrawAvailable ? "да" : "нет") + "\n" +
                "Можно ли внести деньги?: " + (isDepositCashAvailable ? "да" : "нет") + "\n" +
                "Кол-во денег в банкомате: " + String.format("%.2f", numMoney) + "\n" +
                "Стоимость обслуживания банкомата: " + String.format("%.2f", atmServicePrice) + "\n";
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

    public double getNumMoney() {
        return numMoney;
    }

    public void setNumMoney(double numMoney) {
        this.numMoney = numMoney;
    }

    public boolean isCashWithdrawAvailable() {
        return isCashWithdrawAvailable;
    }

    public void setCashWithdrawAvailable(boolean cashWithdrawAvailable) {
        isCashWithdrawAvailable = cashWithdrawAvailable;
    }

    public boolean isDepositCashAvailable() {
        return isDepositCashAvailable;
    }

    public void setDepositCashAvailable(boolean depositCashAvailable) {
        isDepositCashAvailable = depositCashAvailable;
    }
}
