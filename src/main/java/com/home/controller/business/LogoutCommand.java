package com.home.controller.business;

import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LogoutCommand implements Command{

    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
       HttpSession httpSession = httpServletRequest.getSession();
       httpSession.invalidate();//delete session
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        return configManager.getProperties("login");
//        throw new UnsupportedOperationException();
    }
}
