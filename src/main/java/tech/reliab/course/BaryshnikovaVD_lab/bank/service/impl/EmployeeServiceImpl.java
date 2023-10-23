package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.Employee;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee create(Employee employee) {
        if (employee == null) {
            return null;
        }

        return new Employee(employee);
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
