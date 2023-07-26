package com.home.controller.business;

import com.home.controller.business.service.LectureService;
import com.home.model.Lecture;
import com.home.model.User;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class NewGradeCommand implements Command {

    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        LectureService lectureService = (LectureService) httpServletRequest.getServletContext().getAttribute("LectureService");
        HttpSession httpSession = httpServletRequest.getSession();
        User user = (User) httpSession.getAttribute("User");
        List<Lecture> lectures = lectureService.findLectureByTeacher(user.getId());
        httpServletRequest.setAttribute("Lectures", lectures);
        return configManager.getProperties("lecturesByTeacher");
    }
}