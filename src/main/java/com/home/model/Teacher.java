package com.home.model;

public class Teacher extends User {
    private String level;

    private String about;
    private int experience;

    public Teacher(long id, String name, String surname, String login, String password,String mail,
                   long phone, String level , String about, int experience){
        super(id, name, surname, login, password, mail, phone);
        this.level = level;
        this.about = about;
        this.experience = experience;
    }

    public Teacher(String name, String surname, String login, String password,String mail,
                   long phone, String level, String about, int experience){
        super( name, surname, login, password, mail, phone);
        this.level = level;
        this.about = about;
        this.experience = experience;
    }

    public Teacher(){}



    public int getExperience() {
        return experience;
    }

    public String getLevel() {
        return level;
    }

    public String getAbout() {
        return about;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
