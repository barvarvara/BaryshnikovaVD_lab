package tech.reliab.course.BaryshnikovaVD_lab.bank.entity;

import java.time.LocalDate;
import java.util.UUID;

public class Human {
    protected int id;
    protected String fcs;
    protected LocalDate birthday;

    public Human() {
        id = Math.abs(UUID.randomUUID().hashCode());
        fcs = "";
        birthday = null;
    }

    public Human(String fcs, LocalDate birthday) {
        this();
        this.fcs = fcs;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFcs() {
        return fcs;
    }

    public void setFcs(String fcs) {
        this.fcs = fcs;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
