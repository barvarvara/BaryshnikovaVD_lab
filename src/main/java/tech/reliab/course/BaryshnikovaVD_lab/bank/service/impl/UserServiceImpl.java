package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.User;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.UserService;

import static utils.Constants.MAX_MONTHLY_INCOME;

public class UserServiceImpl implements UserService {
    private int calcCreditRating(User user) {
        final double monthlyIncome = user.getMonthlyIncome();
        return (monthlyIncome % 1000 > 0) ? (int) (Math.ceil(monthlyIncome / 1000) * 100) : (int) (monthlyIncome / 10);
    }

    @Override
    public User create(User user) {
        if (user == null) {
            return null;
        }

        if (user.getBank() == null) {
            System.out.println("Error: Невозможно создать клиента без банка");
            return null;
        }

        User newUser = new User(user);
        newUser.setMonthlyIncome((Math.random() * MAX_MONTHLY_INCOME));
        newUser.setBankCreditRating(calcCreditRating(newUser));

        return newUser;
    }

    @Override
    public void delete(User user) {
        user.setFcs("");
        user.setBirthday(null);
        user.setWorkplace("");
        user.setBank(null);
        user.setMonthlyIncome(0);
        user.setBankCreditRating(0);
    }
}
