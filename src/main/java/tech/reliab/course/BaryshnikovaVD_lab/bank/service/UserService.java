package tech.reliab.course.BaryshnikovaVD_lab.bank.service;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.User;

public interface UserService {
    User create(User user);

    void delete(User user);
}
