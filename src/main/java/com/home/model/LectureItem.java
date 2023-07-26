package com.home.model;


import java.util.Date;

public class LectureItem {
    private Student student;
    private int grade;
    private Date dateGrade;
    private String coment;
    private int gradeByStudent;

    private String course;
    public LectureItem(Student student, int grade, Date dateGrade,String coment, int gradeByStudent){
        this.dateGrade = dateGrade;
        this.grade = grade;
        this.student =student;
        this.coment = coment;
        this.gradeByStudent = gradeByStudent;
    }

    public String getComent() {
        return coment;
    }

    public int getGradeByStudent() {
        return gradeByStudent;
    }

    public Date getDateGrade() {
        return dateGrade;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setDateGrade(Date dateGrade) {
        this.dateGrade = dateGrade;
    }
}
