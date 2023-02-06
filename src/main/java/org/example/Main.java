package org.example;

import org.example.dao.UserCRUDRepository;
import org.example.entity.User;
import org.example.storage.DataSource;
import org.flywaydb.core.Flyway;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new DataSource();

        UserCRUDRepository userCRUDRepository = new UserCRUDRepository(dataSource);

        User user = new User("John", 43);

        userCRUDRepository.create(user);

        User foundUser = userCRUDRepository.listAll().get(0);
        System.out.println("Found user " + foundUser);

        foundUser.setAge(44);
        userCRUDRepository.update(foundUser);

        foundUser = userCRUDRepository.getById(foundUser.getId());

        System.out.println("Found user after update " + foundUser);

        userCRUDRepository.deleteById(foundUser.getId());

        List<User> users = userCRUDRepository.listAll();

        if (users.isEmpty()) {
            System.out.println("Юзерів не маю ((");
        }
    }
}