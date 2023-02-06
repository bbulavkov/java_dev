package org.example.notes.service;

import org.example.notes.dao.AccountDAO;
import org.example.notes.entity.Account;
import org.example.storage.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountService {

    private final AccountDAO accountDAO;
    private final DataSource dataSource;

    public AccountService(AccountDAO accountDAO, DataSource dataSource) {
        this.accountDAO = accountDAO;
        this.dataSource = dataSource;
    }

    public void makeTransfer(int sourceAccountId, int destinationAccountId, int amount) throws SQLException {

        Account source = accountDAO.getById(sourceAccountId);
        if (source == null) {
            System.out.println("Account " + sourceAccountId + " not found");
        }

        Account destination = accountDAO.getById(destinationAccountId);
        if (destination == null) {
            System.out.println("Account " + destinationAccountId + " not found");
        }


        boolean isSuccessful = accountDAO.makeTransfer(source, destination, amount);
        System.out.println("IsSuccessful " +isSuccessful);
    }
}
