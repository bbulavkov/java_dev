package org.example.notes.dao;

import org.example.entity.User;
import org.example.storage.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private final DataSource dataSource;

    private final PreparedStatement selectByNameStatement;
    private final PreparedStatement insertStatement;

    private final PreparedStatement truncateStatement;

    public UserDAO(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        Connection connection = dataSource.getConnection();

        selectByNameStatement = connection
                .prepareStatement("select * from java_lessons.users where name = ? ");

        insertStatement = connection
                .prepareStatement("insert into java_lessons.users  (name, age)  values (? , ?)");

        truncateStatement = connection
                .prepareStatement("truncate table java_lessons.users");
    }

    public User getByName(String name) throws SQLException {
        selectByNameStatement.setString(1, name);
        ResultSet resultSet = selectByNameStatement.executeQuery();

        while (resultSet.next()) {
            int entityId = resultSet.getInt("id");
            String entityName = resultSet.getString("name");
            int age = resultSet.getInt("age");

            return new User(entityId, entityName, age);
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

    public int[] create(String[] names, int[] ages) throws SQLException {
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            int age = ages[i];

            insertStatement.setString(1, name);
            insertStatement.setInt(2, age);

            insertStatement.addBatch();
        }
        return insertStatement.executeBatch();
    }

    public void deleteAll() throws SQLException {
        truncateStatement.executeUpdate();
    }
}

