package org.example.dao;

import org.example.entity.Account;
import org.example.entity.User;
import org.example.storage.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {
    private final DataSource dataSource;
    private final PreparedStatement updateStatement;
    private final PreparedStatement selectByIdStatement;

    public AccountDAO(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        Connection connection = dataSource.getConnection();

        this.selectByIdStatement = connection
                .prepareStatement("select * from java_lessons.account where id = ? ");

        this.updateStatement = connection
                .prepareStatement("update java_lessons.account set money = ? where id = ?");
    }

    public Account getById(int id) throws SQLException {
        selectByIdStatement.setInt(1, id);

        ResultSet resultSet = selectByIdStatement.executeQuery();

        while (resultSet.next()) {
            int entityId = resultSet.getInt("id");
            int money = resultSet.getInt("money");

            return new Account(entityId, money);
        }

        return null;

    }

    public void makeTransfer(Account source, Account destination, int sum) throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);

        try {
            int moneyToUpdate = source.getMoney() - sum;
            update(source.getId(), moneyToUpdate);

            moneyToUpdate = destination.getMoney() + sum;
            update(destination.getId(), moneyToUpdate);

            connection.commit();
        } catch (Exception ex) {
            connection.rollback();
        } finally {
//            connection.setAutoCommit(true);
            connection.close();
        }


    }

    private void update(int id, int moneyToUpdate) throws SQLException {
        updateStatement.setInt(1, moneyToUpdate);
        updateStatement.setInt(2, id);

        updateStatement.executeUpdate();
    }
}
