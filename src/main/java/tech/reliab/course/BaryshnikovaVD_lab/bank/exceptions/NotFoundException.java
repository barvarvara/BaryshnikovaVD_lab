package tech.reliab.course.BaryshnikovaVD_lab.bank.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entityName) {
        super("Ошибка! " + entityName + " не найден или не существует");
    }
}
