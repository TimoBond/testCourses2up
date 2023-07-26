package com.home.controller.business;

import com.home.controller.business.service.LectureService;
import com.home.model.LectureItem;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class StudentsByLecture implements Command {
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
        LectureService lectureService = (LectureService) httpServletRequest.getServletContext().getAttribute("LectureService");
        String id = httpServletRequest.getParameter("id");
        String dateFinish = httpServletRequest.getParameter("dateFinish");
        List<LectureItem> lectureItems =  lectureService.find(Long.parseLong(id));
       HttpSession httpSession =  httpServletRequest.getSession();
       httpSession.setAttribute("lectureItems",lectureItems);
        httpServletRequest.setAttribute("dateFinish",dateFinish);
        httpServletRequest.setAttribute("id", id);
        return configManager.getProperties("studentsByLecture");
    }
}
