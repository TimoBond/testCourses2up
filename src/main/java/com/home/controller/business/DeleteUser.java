package com.home.controller.business;

import com.home.controller.business.service.UserService;

import com.home.model.User;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;

public class DeleteUser implements Command {
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        UserService userService = (UserService) httpServletRequest.getServletContext().getAttribute("UserService");
        User user = new User();
        String id = httpServletRequest.getParameter("id");
        String type = httpServletRequest.getParameter("type");
      List<User> userList = (List<User>) httpServletRequest.getSession().getAttribute("Users");
        user.setId(Long.parseLong(id));
        User user1  = userService.delete(user);
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        if(user1 == null){
            httpServletRequest.setAttribute("wrong","no delete");
        }else {
           userList.removeIf(user2 -> user2.getId() == user1.getId());
        }
       httpServletRequest.setAttribute("Users",userList);
        if (type.equals("student") ) {
            return configManager.getProperties("student_Management");
        }
        if (type.equals("teacher")) {
            return configManager.getProperties("teacher_Management");
        }

        return configManager.getProperties("admin_main_page");
    }
}
