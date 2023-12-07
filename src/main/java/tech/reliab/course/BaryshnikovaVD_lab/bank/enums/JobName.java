package tech.reliab.course.BaryshnikovaVD_lab.bank.enums;

public enum JobName {
    MANAGER,
    ADVISOR,
    PROGRAMMER,
    CREDIT_EXPERT;

    public static JobName getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
