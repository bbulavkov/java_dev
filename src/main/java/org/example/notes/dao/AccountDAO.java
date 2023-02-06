package org.example.notes.dao;

import org.example.entity.User;
import org.example.notes.entity.Account;
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

        selectByIdStatement = connection
                .prepareStatement("select * from java_lessons.account where id = ? ");

        this.updateStatement = dataSource.getConnection()
                .prepareStatement("update java_lessons.account set money = ? where id = ?");

    }


    public Account getById(int id) throws SQLException {
        selectByIdStatement.setInt(1, id);

        try (ResultSet resultSet = selectByIdStatement.executeQuery()) {

            while (resultSet.next()) {
                int entityId = resultSet.getInt("id");
                int money = resultSet.getInt("money");

                return new Account(entityId, money);
            }
        }
        return null;
    }


    public boolean makeTransfer(Account source, Account destination, int amount) throws SQLException {
        Connection connection = dataSource.getConnection();
        try {
            connection.setAutoCommit(false);
            int moneyToUpdate = source.getMoney() - amount;
            updateStatement.setInt(1, moneyToUpdate);
            updateStatement.setInt(2, source.getId());
            boolean isSuccessful = updateStatement.executeUpdate() == 1;


            moneyToUpdate = destination.getMoney() + amount;
            updateStatement.setInt(1, moneyToUpdate);
            updateStatement.setInt(2, destination.getId());
            isSuccessful = isSuccessful && updateStatement.executeUpdate() == 1;

            connection.commit();

            return isSuccessful;
        } catch (Exception ex) {
            System.out.println("Exception while money transfer");
            connection.rollback();
        } finally {
            connection.setAutoCommit(true);
        }
        return false;
    }
}
