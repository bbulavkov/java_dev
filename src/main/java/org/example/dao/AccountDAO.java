package org.example.dao;

import org.example.entity.Account;

import java.sql.SQLException;

public interface AccountDAO {
    Account getById(int id) throws SQLException;

    void persist(Account account);

    void merge(Account account);
}
