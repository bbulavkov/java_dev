package org.example.dao.v1;

import org.example.entity.User;
import org.example.storage.DataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    private final DataSource dataSource;

    public UserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User getByName(String name) {
        try (Connection connection = dataSource.getConnection()) {

            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery("select id, name, age " +
                    "from postgres.java_lessons.users where name = '" + name + "' ")) {

                while (resultSet.next()) {

                    int entityId = resultSet.getInt("id");
                    String entityName = resultSet.getString("name");
                    int age = resultSet.getInt("age");

                    return new User(entityId, entityName, age);
                }
            }

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
