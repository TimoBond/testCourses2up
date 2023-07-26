package com.home.model;

public class Admin extends User{
    public Admin(long id, String name, String surname, String login, String password,String mail, long phone){
        super(id, name, surname, login, password, mail, phone);
    }
    public Admin( String name, String surname, String login, String password,String mail, long phone){
        super(name, surname, login, password, mail, phone);
    }
}
