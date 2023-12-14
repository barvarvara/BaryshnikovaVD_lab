package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Bank;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankOffice;
import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Employee;
import tech.reliab.course.BaryshnikovaVD_lab.bank.enums.JobName;

import java.time.LocalDate;

public interface EmployeeService {
    Employee create(String fcs, LocalDate birthday, JobName jobName, Bank bank, boolean isWorkingAtHome, BankOffice bankOffice, double salaryAmount);

    void delete(Employee employee);
}