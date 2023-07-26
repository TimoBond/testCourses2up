package com.home.model;

public class Student extends User {

    private int course;

    public Student(long id, String name, String surname, String login, String password,String mail, long phone, int course){
        super(id, name, surname, login, password, mail, phone);
        this.course = course;
    }

    public Student(String name, String surname, String login, String password, String mail, long phone, int course){
       super(name,surname,login,password,mail,phone);
       this.course = course;

    }
    public Student(){}




    public int getCourse() {
        return course;
    }
}
