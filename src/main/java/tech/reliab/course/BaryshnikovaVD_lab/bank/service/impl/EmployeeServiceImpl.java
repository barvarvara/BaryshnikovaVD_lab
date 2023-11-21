package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Bank;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankOffice;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Employee;
import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.JobName;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee create(String fcs, LocalDate birthday, JobName jobName, Bank bank, boolean isWorkingAtHome, BankOffice bankOffice, boolean canWithdrawCredit, double salaryAmount) {
        return new Employee(fcs, birthday, jobName, bank, isWorkingAtHome, bankOffice, canWithdrawCredit, salaryAmount);
    }

    @Override
    public void delete(Employee employee) {
        employee.setFcs("");
        employee.setBirthday(null);
        employee.setJobName(null);
        employee.setBank(null);
        employee.setWorkingAtHome(false);
        employee.setCanWithdrawCredit(false);
        employee.setSalaryAmount(0);
        employee.setBankOffice(null);
    }
}
