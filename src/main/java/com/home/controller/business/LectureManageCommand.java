package com.home.controller.business;

import com.home.controller.business.service.LectureService;
import com.home.model.Lecture;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;

public class LectureManageCommand implements Command {
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {

        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        LectureService lectureService = (LectureService) httpServletRequest.getServletContext().getAttribute("LectureService");
        List<Lecture> lectures = lectureService.findLecture();
        httpServletRequest.setAttribute("Lectures", lectures);
        return configManager.getProperties("lectureManagement");
    }
}
