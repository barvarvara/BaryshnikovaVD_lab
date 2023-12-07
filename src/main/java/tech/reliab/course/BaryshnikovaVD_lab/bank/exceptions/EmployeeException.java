package tech.reliab.course.BaryshnikovaVD_lab.bank.exceptions;

public class EmployeeException extends RuntimeException {
    public EmployeeException(String errorMessage, int employeeId) {
        super("Ошибка! Сотрудник с id=" + employeeId + ". " + errorMessage);
    }

}
