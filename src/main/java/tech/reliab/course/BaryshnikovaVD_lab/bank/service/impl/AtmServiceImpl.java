package tech.reliab.course.BaryshnikovaVD_lab.bank.service.impl;

import tech.reliab.course.BaryshnikovaVD_lab.bank.entity.BankAtm;
import tech.reliab.course.BaryshnikovaVD_lab.bank.service.AtmService;

public class AtmServiceImpl implements AtmService {
    @Override
    public BankAtm create(BankAtm bankAtm) {
        if (bankAtm == null) {
            return null;
        }

        return new BankAtm(bankAtm);
    }
}
