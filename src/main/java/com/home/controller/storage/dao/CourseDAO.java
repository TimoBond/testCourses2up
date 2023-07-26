package com.home.controller.storage.dao;

import com.home.model.Course;
import com.home.model.Teacher;

import java.util.List;

public interface CourseDAO extends DAO<Course,Integer>{

    Course find(String title, Teacher proffecor);
    List<Course> findCourses();
}
