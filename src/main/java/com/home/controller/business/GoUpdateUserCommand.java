package com.home.controller.business;

import com.home.controller.business.service.UserService;
import com.home.model.Student;
import com.home.model.Teacher;
import com.home.model.User;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class GoUpdateUserCommand implements Command{
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        System.out.println("go up");
        UserService userService = (UserService) httpServletRequest.getServletContext().getAttribute("UserService");
      String id = httpServletRequest.getParameter("id");
        System.out.println(id + " id!");
      User selectedUser =  userService.findUser(Long.parseLong(id));
        selectedUser.setPhotoFileName(selectedUser.getId()+".jpg");
        System.out.println(selectedUser.getPhotoFileName());
      ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
      HttpSession httpSession = httpServletRequest.getSession();
      httpSession.setAttribute("selectedUser", selectedUser);
      if(selectedUser instanceof Student){
          httpServletRequest.setAttribute("selectedUser",selectedUser);
          return configManager.getProperties("updateStudent");
      }if(selectedUser instanceof Teacher){
            httpServletRequest.setAttribute("selectedUser",selectedUser);
          return configManager.getProperties("upTeacher");
        }
        return configManager.getProperties("student_main_page");
    }
}
