package org.example.dao;

import org.example.entity.User;
import org.example.storage.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserCRUDRepository {
    private final DataSource dataSource;

    private final PreparedStatement selectStatement;
    private final PreparedStatement insertStatement;
    private final PreparedStatement updateStatement;
    private final PreparedStatement truncateStatement;
    private final PreparedStatement deleteByIdStatement;
    private final PreparedStatement selectAllStatement;

    public UserCRUDRepository(DataSource dataSource) throws SQLException {
        this.dataSource = dataSource;
        Connection connection = dataSource.getConnection();

        this.selectStatement = connection
                .prepareStatement("select * from java_lessons.users where id = ? ");

        this.selectAllStatement = connection
                .prepareStatement("select * from java_lessons.users");

        this.insertStatement = connection
                .prepareStatement("insert into postgres.java_lessons.users (name, age) VALUES(?, ?)");

        this.updateStatement = connection
                .prepareStatement(" update java_lessons.users set name = ? , age =? where id = ?;");


        this.truncateStatement = connection
                .prepareStatement("truncate table java_lessons.users");

        this.deleteByIdStatement = connection
                .prepareStatement("delete from  java_lessons.users where id = ?");

    }

    //    long create(String name) - додає нового клієнта з іменем name. Повертає ідентифікатор щойно створеного клієнта.
    public void create(User user) {
        try {
            insertStatement.setString(1, user.getName());
            insertStatement.setInt(2, user.getAge());

            insertStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //            String getById(long id) - повертає назву клієнта з ідентифікатором id
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

//    void setName(long id, String name) - встановлює нове ім'я name для клієнта з ідентифікатором id

    public void update(User user) {
        try {
            updateStatement.setString(1, user.getName());
            updateStatement.setInt(2, user.getAge());
            updateStatement.setInt(3, user.getId());

            updateStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //    void deleteById(long id) - видаляє клієнта з ідентифікатором id
    public void deleteById(int id) throws SQLException {
        try {

            deleteByIdStatement.setInt(1, id);

            deleteByIdStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll() throws SQLException {
        truncateStatement.executeUpdate();
    }

    //    List<Client> listAll()
    public List<User> listAll() throws SQLException {
        List<User> result = new ArrayList<>();
        ResultSet resultSet = selectAllStatement.executeQuery();

        while (resultSet.next()) {
            int entityId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            result.add(new User(entityId, name, age));
        }
        resultSet.close();

        return result;
    }
}
