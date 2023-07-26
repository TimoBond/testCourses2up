package com.home.controller.business;

import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class GoMenuCommand implements Command{
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
       String type =  httpServletRequest.getParameter("type");
        System.out.println(type);
       if(type.equals("courses")){
           System.out.println(type);
          return configManager.getProperties("courses");
        }if(type.equals("FAQ")){
           return configManager.getProperties("faq");
        };
        return configManager.getProperties("home");
    }
}
