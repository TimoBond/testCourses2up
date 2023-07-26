package com.home.controller.business;

import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class GoToCourse implements Command {
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        String id = httpServletRequest.getParameter("id");
        if (id.equals("1")) {
            return configManager.getProperties("digitalDrawing");
        }
        if (id.equals("2")) {
            return configManager.getProperties("3d");
        }
        if (id.equals("3")) {
            return configManager.getProperties("gameGraphics");
        }
        if (id.equals("4")) {
            return configManager.getProperties("2DAnimation");
        }
        if (id.equals("5")) {
            return configManager.getProperties("2DCharacterArtist");
        }
        if (id.equals("6")) {
            return configManager.getProperties("academicDrawing");
        }
        return null;
    }
}
