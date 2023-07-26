package com.home.controller.business;

import com.home.controller.business.service.UserService;
import com.home.model.Student;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class RegistrationStudent implements Command{
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        boolean isOk = true;
        UserService userService = (UserService) httpServletRequest.getServletContext().getAttribute("UserService");
        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");
        boolean check = userService.checkLoginPas(login,password);
        String name = httpServletRequest.getParameter("name");
        String wrong = "не правильно заполненые";
        if(name.equals("")){
            wrong = wrong + "name";
            isOk = false;
        }
        String surname = httpServletRequest.getParameter("surname");
        if(surname.equals("")){
            wrong = wrong + "surname";
            isOk = false;
        }

        if(login.equals("")|| check == true){
           wrong = wrong + " login";
            isOk=false;
        }

        if(password.equals("") || check == true){
           wrong = wrong + " password";
            isOk=false;
        }
        String mail = httpServletRequest.getParameter("mail");
        if(!mail.matches("^(.+)@(.+)$")){
            wrong = wrong + "Mail can`t be empty or no @";
            isOk = false;
        }
        String phone = httpServletRequest.getParameter("phone");
        if(phone.length() != 10 || phone.equals("") || phone.matches("[^0-9]+")){
            wrong = wrong + " wrong phone";
            System.out.println(phone.length());
            isOk=false;
        }
        String course = httpServletRequest.getParameter("course");
        if(course.equals("")){
            wrong = wrong + " course";
            isOk = false;
        }

        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        if(isOk == false){
            httpServletRequest.setAttribute("wrong",  wrong);
            return configManager.getProperties("create_student");
        }
       userService.create(new Student(name,surname,login,password,mail,Long.parseLong(phone),Integer.parseInt(course)));
        return  configManager.getProperties("login");
    }
}
