package com.home.controller.business;

import com.home.controller.business.service.LectureService;
import com.home.model.LectureItem;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class UpGradesStudent implements Command{
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");
     String[] strings = httpServletRequest.getParameterValues("grade");
        String id = httpServletRequest.getParameter("id");
      List<LectureItem> lectureItems = (List<LectureItem>) httpServletRequest.getSession().getAttribute("lectureItems");

        for (int i = 0; i < lectureItems.size(); i++) {
            lectureItems.get(i).setGrade(Integer.parseInt(strings[i]));
            lectureItems.get(i).setDateGrade(new Date());
        }
        LectureService lectureService = (LectureService) httpServletRequest.getServletContext().getAttribute("LectureService");
        lectureService.update(lectureItems,Long.parseLong(id));

        return configManager.getProperties("professor_main_page");
    }
}
