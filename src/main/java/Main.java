import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Bank;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankAtm;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankOffice;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Employee;
import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.BankAtmStatus;

import java.util.Date;


public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Сбер", 1000, 1000, 10000, 99999);
        System.out.print(bank);

        BankOffice bankOffice = new BankOffice("Офис банка 1", "ул. Королева, 2Г", true, true, 10, true, true, true, 10000000, 10000);
        System.out.print(bankOffice);

        Date birthday = new Date(2002, 8, 10);
//        Employee employee = new Employee("Барышникова Варвара Дмитриевна", )

//        BankAtm bankAtm = new BankAtm("Банкомат 1", BankAtmStatus.WORK, bank, bankOffice, employee)
    }
}