package tech.reliab.course.BaryshnikovaVD_lab.bank.exceptions;

public class PaymentAccountNotFoundException extends RuntimeException {
    public PaymentAccountNotFoundException() {
        super("Ошибка! Платёжный аккаунт не найден");
    }

}
