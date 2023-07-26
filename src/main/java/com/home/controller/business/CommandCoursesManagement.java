package com.home.controller.business;

import com.home.controller.business.service.CourseService;
import com.home.model.Course;
import com.home.util.ConfigManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class CommandCoursesManagement implements Command {
    @Override
    public String execute(HttpServletRequest httpServletRequest) throws ServletException, IOException {

       CourseService courseService =(CourseService) httpServletRequest.getServletContext().getAttribute("CourseService");
      List<Course> courses =  courseService.findCourses();
        for (int i = 0; i < courses.size(); i++) {
            courses.get(i).setCoverFileName("course"+ courses.get(i).getId());
        }
        HttpSession httpSession = httpServletRequest.getSession();
        File file = new File(httpServletRequest.getServletContext().getRealPath("/resources/images"));
        FileUtils.forceMkdir(file);
        for (int i = 0; i <courses.size(); i++) {
            Course course =  courses.get(i);
            byte[] photo = course.getCover();
            String path = httpServletRequest.getServletContext().getRealPath("resources/images/"+course.getCoverFileName()+".jpg");
            course.setCoverFileName("course"+course.getId()+".jpg");
//            System.out.println(teacher.getPhotoFileName() + " webi info");
            OpenOption[] openOptions ={StandardOpenOption.CREATE,StandardOpenOption.WRITE};
            Files.write(Path.of(path), photo, openOptions);
        }
        courses.stream().forEach(course -> System.out.println(course.getId() + " coirseee"));
        httpSession.setAttribute("Courses",courses);
        System.out.println("popalo v find user");
        ConfigManager configManager = (ConfigManager) httpServletRequest.getServletContext().getAttribute("ConfigManager");

            return   configManager.getProperties("courses_management");

    }
}
