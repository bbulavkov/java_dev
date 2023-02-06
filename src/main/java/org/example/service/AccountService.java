package org.example.service;

import org.example.dao.AccountDAO;
import org.example.entity.Account;

import java.sql.SQLException;

public class AccountService {

    private final AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void makeTransfer(int sourceId, int destinationId, int sum) throws SQLException {
        Account source = accountDAO.getById(sourceId);

        if (source != null) {
            Account destination = accountDAO.getById(destinationId);

            if (destination != null) {
                accountDAO.makeTransfer(source, destination, sum);
            }
        }
    }
}
