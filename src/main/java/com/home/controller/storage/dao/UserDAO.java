package com.home.controller.storage.dao;

import com.home.model.User;

import java.util.List;

public interface UserDAO extends DAO<User,Long>{

    User find(String login, String password);

    List<User> findAll();
    boolean checkLoginPass(String login, String password);
    boolean updatePhoto(User user);


}
