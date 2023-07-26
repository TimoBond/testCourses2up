package com.home.controller.business.service;

import com.home.controller.storage.dao.CourseDAO;
import com.home.model.Course;

import java.io.Serializable;
import java.util.List;

public class CourseService implements Serializable {
    CourseDAO courseDAO;

    public CourseService (CourseDAO courseDAO){this.courseDAO = courseDAO;}

    public List<Course> findCourses(){return courseDAO.findCourses();}

}
