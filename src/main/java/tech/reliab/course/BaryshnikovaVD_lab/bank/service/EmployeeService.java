package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Employee;

public interface EmployeeService {
    Employee create(Employee employee);

    void delete(Employee employee);
}