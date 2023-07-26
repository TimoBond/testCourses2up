package com.home.model;

public class User extends Entity<Long>{
    private String name;
    private String surname;
    private String login;
    private String password;
    private String mail;
    private long phone;
    private byte[] photo;

    private String photoFileName = "";

    public User (long id, String name, String surname, String login, String password,String mail, long phone){
        super(id);
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
    }
    public User(String name, String surname, String login, String password, String mail, long phone){
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
    }
    public User(){};

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getPhotoFileName(){
        return photoFileName;
    }
    public void setPhotoFileName(String photoFileName){
        this.photoFileName = photoFileName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public long getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String toString(){
        return "Id - " + getId() + " name - " + name + " surename - "+ surname + " login" + login + " "
                + getClass().getSimpleName();
    }
}
