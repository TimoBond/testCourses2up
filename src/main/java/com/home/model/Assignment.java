package com.home.model;

import java.util.Date;

public class Assignment {
private long id;
private String title;
private String description;
private Date date;

public Assignment(long id, String title, String description, Date date){
    this.id = id;
    this.title = title;
    this.description = description;
    this.date = date;
}
public Assignment(){}

    public long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
