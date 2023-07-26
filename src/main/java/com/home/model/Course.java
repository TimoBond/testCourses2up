package com.home.model;

public class Course extends Entity<Integer> {
    private String title;
    private byte[] cover;
    private int duration;
    private String description;
    private Teacher professor;
    private String CoverFileName = "";

    public Course(int id, String title,byte[] cover, int duration, String description, Teacher professor){
        super(id);
        this.title = title;
        this.cover = cover;
        this.duration = duration;
        this.description = description;
        this.professor = professor;
    }
    public  Course( String title,byte[] cover, int duration, String description, Teacher professor){
        this.title = title;
        this.cover = cover;
        this.duration = duration;
        this.description = description;
        this.professor = professor;
    }
    public Course(){}

    public byte[] getCover() {
        return cover;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getDescription() {
        return description;
    }

    public Teacher getProfessor() {
        return professor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCoverFileName(String coverFileName) {
        CoverFileName = coverFileName;
    }

    public String getCoverFileName() {
        return CoverFileName;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
