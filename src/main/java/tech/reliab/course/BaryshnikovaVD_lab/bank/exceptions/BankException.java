package tech.reliab.course.BaryshnikovaVD_lab.bank.exceptions;

public class BankException extends RuntimeException{
    public BankException(String errorMessage, String bankName) {
        super("Ошибка! Банк " + bankName + ". " + errorMessage);
    }

    public BankException(String errorMessage) {
        super("Ошибка! " + errorMessage);
    }
}
