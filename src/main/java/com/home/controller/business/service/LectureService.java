package com.home.controller.business.service;

import com.home.controller.storage.dao.LectureDAO;
import com.home.model.Lecture;
import com.home.model.LectureItem;

import java.io.Serializable;
import java.util.List;

public class LectureService implements Serializable {
    LectureDAO lectureDAO;

    public LectureService(LectureDAO lectureDAO){this.lectureDAO = lectureDAO;}


    public Lecture findGradeByStudent(long idUser){return lectureDAO.findGradeByStudent(idUser);}

    public List<Lecture> findLecture(){return lectureDAO.findLectures();}


    public List<Lecture> findLectureByTeacher(long idTeacher){return  lectureDAO.findLectureByTeacher(idTeacher);}


    public List<LectureItem> find(long id){return lectureDAO.find(id);}

    public boolean update(List<LectureItem> lectureItems, long id){return lectureDAO.update(lectureItems,id);}
        }




