package com.home.controller.business;

import com.home.controller.business.service.UserService;
import com.home.model.Teacher;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class UpdateUsersCommand implements Command{
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        UserService userService = (UserService) httpServletRequest.getServletContext().getAttribute("UserService");
        System.out.println("update");
        String wrong = "";
        boolean isOk = true;
      Teacher teacher = (Teacher)  httpServletRequest.getSession().getAttribute("selectedUser");
        String surname = httpServletRequest.getParameter("surname");
        String mail = httpServletRequest.getParameter("mail");
        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");
        String about = httpServletRequest.getParameter("about");

        if(! mail.matches("^(.+)@(.+)$")){
            wrong = wrong + "Mail can`t be empty or no @";
            isOk = false;
        }
        String name =  httpServletRequest.getParameter("name");
        if(name.equals("") || surname.equals("") || login.equals("") || password.equals("") ||
         about.equals("about")){
            wrong = wrong + "sumthing zero";
            isOk=false;
        }
        String phone = httpServletRequest.getParameter("phone");
        if(phone.length() != 10 ||  phone.matches("[^0-9]+")){
            wrong = wrong + " wrong phone";
            System.out.println(phone.length());
            isOk=false;
        }
        String teacherLevel = httpServletRequest.getParameter("teacherLevel");
        if(teacherLevel.equals("") ){
            wrong = wrong + "wrong teacher level";
            isOk = false;
        }
        String experience = httpServletRequest.getParameter("experience");
        if (experience.equals("") || experience.matches("[^0-9]+")){
            wrong = wrong + "exp";
            isOk = false;
        }
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");

        if(isOk == true){
            teacher.setName(name);
            teacher.setSurname(surname);
            teacher.setLogin(login);
            teacher.setPassword(password);
            teacher.setPhone(Long.parseLong(phone));
            teacher.setMail(mail);
         teacher = (Teacher) userService.update(teacher);
        }else {
            httpServletRequest.setAttribute("wrongUp",wrong);
            return configManager.getProperties("updateTeacher");
        }
        if(teacher != null){
            return configManager.getProperties("teacher_Management");
        }
        return null;
    }
}
