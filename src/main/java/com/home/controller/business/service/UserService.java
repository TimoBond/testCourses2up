package com.home.controller.business.service;

import com.home.controller.storage.dao.UserDAO;
import com.home.model.User;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class UserService implements Serializable {
    private UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    public User findUser(String login, String password){
        return userDAO.find(login,password);
    }

    public List<User> findUsers(String type){
          return userDAO.findAll().stream().filter(user -> user.getClass().getSimpleName().equalsIgnoreCase(type))
                  .collect(Collectors.toList());
    }
    public User update(User user){return userDAO.update(user);}
    public User create(User user){return userDAO.create(user);}

    public User delete(User user){User user1 =  userDAO.delete(user);
        System.out.println(user1 +" v userServis");
    return user1;}
    public User findUser(long id){return userDAO.find(id);}
    public boolean checkLoginPas(String loggin, String password){return  userDAO.checkLoginPass(loggin,password);}

    public boolean updatePhoto(User user){return userDAO.updatePhoto(user);}
}
