package com.example.bankapp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {
    @Autowired
    private AccountDAO dao;
    @Transactional
    public void transfer(int fromId, int toId, double amount) {
        Account from = dao.getAccount(fromId);
        Account to = dao.getAccount(toId);
        from.setBalance(from.getBalance() - amount);
        to.setBalance(to.getBalance() + amount);
        dao.updateAccount(from);
        dao.updateAccount(to);
    }
}
