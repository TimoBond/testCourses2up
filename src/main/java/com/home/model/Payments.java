package com.home.model;

import java.util.Date;

public class Payments extends Entity {
    private Lecture lecture;
    private boolean paid;
    private Date paymanDate;

    public Payments(int id, Lecture lecture, boolean paid, Date paymanDate){
        super(id);
        this.lecture = lecture;
        this.paid = paid;
        this.paymanDate = paymanDate;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public Date getPaymanDate() {
        return paymanDate;
    }

    public void setPaymanDate(Date paymanDate) {
        this.paymanDate = paymanDate;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
