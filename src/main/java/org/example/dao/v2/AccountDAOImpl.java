package org.example.dao.v2;

import org.example.dao.AccountDAO;
import org.example.entity.Account;
import org.example.entity.AccountType;
import org.example.storage.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOImpl implements AccountDAO {
    private final DataSource dataSource;
    private final PreparedStatement updateStatement;
    private final PreparedStatement selectByIdStatement;

    public AccountDAOImpl(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        Connection connection = dataSource.getConnection();

        this.selectByIdStatement = connection
                .prepareStatement("select * from java_lessons.account where id = ? ");

        this.updateStatement = connection
                .prepareStatement("update java_lessons.account set money = ? where id = ?");
    }

    @Override
    public Account getById(int id) throws SQLException {
        selectByIdStatement.setInt(1, id);

        ResultSet resultSet = selectByIdStatement.executeQuery();

        while (resultSet.next()) {
            int entityId = resultSet.getInt("id");
            int money = resultSet.getInt("money");

//            return Account.builder()
//            .build()
//                    new Account(entityId, money, AccountType.Direct);
            return null;
        }

        return null;

    }

    @Override
    public void persist(Account account) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void merge(Account account) {
        throw new UnsupportedOperationException();
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
