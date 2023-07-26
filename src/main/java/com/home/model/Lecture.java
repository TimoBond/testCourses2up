package com.home.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lecture extends Entity<Long>{
    private Date dateStart;
    private Date dateFinish;
    private List<LectureItem> lectureItems = new ArrayList<>();
    private Course course;
    public Lecture(long id, Date dateStart, Date dateFinish, List<LectureItem> lectureItems, Course course){
        super(id);
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.lectureItems = lectureItems;
        this.course = course;
    }

    public Lecture(Date dateStart, Date dateFinish, List<LectureItem> lectureItems, Course course){
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.lectureItems = lectureItems;
        this.course = course;
    }
    public Lecture(){}

    public Course getCourse() {
        return course;
    }

    public Date getDateFinish() {
        return dateFinish;
    }

    public List<LectureItem> getLectureItems() {
        return lectureItems;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setLectureItems(List<LectureItem> lectureItems) {
        this.lectureItems = lectureItems;
    }
}
