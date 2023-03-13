package org.example.service;

import org.example.dao.v2.UserCRUDRepository;
import org.example.entity.User;

import java.sql.SQLException;

public class UserService {

    private final UserCRUDRepository userCRUDRepository;


    public UserService(UserCRUDRepository userCRUDRepository) {
        this.userCRUDRepository = userCRUDRepository;
    }

    public User getById(int id){
        try {
            return userCRUDRepository.getById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
