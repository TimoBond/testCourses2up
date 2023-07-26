package com.home.controller.storage.dao;

import com.home.model.Lecture;
import com.home.model.LectureItem;

import java.util.List;

public interface LectureDAO extends DAO<Lecture,Long> {

    List<LectureItem> find(long id);

    Lecture findGradeByStudent(long idUser);

    List<Lecture> findLectures();

    List<Lecture> findLectureByTeacher(long idTeacher);

    boolean update(List<LectureItem> lectureItems, long id);
    }

