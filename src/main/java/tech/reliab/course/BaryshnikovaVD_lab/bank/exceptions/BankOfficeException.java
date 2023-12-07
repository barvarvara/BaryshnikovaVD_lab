package tech.reliab.course.BaryshnikovaVD_lab.bank.exceptions;

public class BankOfficeException extends RuntimeException{
    public BankOfficeException(String errorMessage, int officeBankId) {
        super("Ошибка! Банковский офис №" + officeBankId + ". " + errorMessage);
    }
}
