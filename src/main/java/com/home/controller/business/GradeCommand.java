package com.home.controller.business;

import com.home.controller.business.service.LectureService;
import com.home.model.Lecture;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class GradeCommand implements Command {

    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        LectureService lectureService = (LectureService) httpServletRequest.getServletContext().getAttribute("LectureService");
        String id = httpServletRequest.getParameter("id");
        Lecture lecture = lectureService.findGradeByStudent(Long.parseLong(id));
        httpServletRequest.setAttribute("lectureGrade", lecture);
        return configManager.getProperties("grade");
    }
}
