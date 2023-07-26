package com.home.controller.business;

import com.home.controller.business.service.UserService;
import com.home.model.Admin;
import com.home.model.Student;
import com.home.model.Teacher;
import com.home.model.User;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginCommand implements Command{

    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");
        UserService userService = (UserService) httpServletRequest.getServletContext().getAttribute("UserService");// сохраняет в окружения сервелета и потом его можно доставать
        User user = userService.findUser(login,password);
        HttpSession httpSession = httpServletRequest.getSession(true);// выдает сессию, тру если нет  сесси тогда создаст новую, еслы блыа, выдаст прошлую сессию
        httpSession.setMaxInactiveInterval(200);//200 мин живет ссесия
        httpSession.setAttribute("User",user);//стринг - названия атрибута по которому можно искать
        System.out.println("user " + user);
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");//
       if(user instanceof Admin){
           return configManager.getProperties("admin_main_page");
        }if(user instanceof Student){
            return configManager.getProperties("student_main_page");
        }else if(user instanceof Teacher){
            return configManager.getProperties("professor_main_page");
        }
        httpServletRequest.setAttribute("wrongLoginPassword","Wrong login or password!");
        String page = configManager.getProperties("login");
        return page;
    }
}
