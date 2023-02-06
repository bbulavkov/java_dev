package org.example.dao.v2;

import org.example.entity.User;
import org.example.storage.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private final DataSource dataSource;

    private final PreparedStatement selectStatement;
    private final PreparedStatement insertStatement;

    public UserDAO(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        Connection connection = dataSource.getConnection();

        this.selectStatement = connection
                .prepareStatement("select * from java_lessons.users where id = ? ");

        this.insertStatement = connection
                .prepareStatement("insert into postgres.java_lessons.users (name, age) VALUES(?, ?)");

    }

    public User getById(int id) throws SQLException {
        selectStatement.setInt(1, id);
        ResultSet resultSet = selectStatement.executeQuery();

        while (resultSet.next()) {
            int entityId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            return new User(entityId, name, age);
        }

        resultSet.close();

        return null;
    }

    public void create(String name, int age) {
        try {
            insertStatement.setString(1, name);
            insertStatement.setInt(2, age);

            insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(String[] names, int[] ages) {
        try {
            for (int i = 0; i < names.length; i++) {
                String name = names[i];
                int age = ages[i];

                insertStatement.setString(1, name);
                insertStatement.setInt(2, age);
                insertStatement.addBatch();
            }
            insertStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
