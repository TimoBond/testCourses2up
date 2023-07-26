package com.home.controller.storage.dao.impl.mySQL;

import com.home.controller.storage.dao.UserDAO;
import com.home.model.Admin;
import com.home.model.Student;
import com.home.model.Teacher;
import com.home.model.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUserDAO implements UserDAO {

    private static final String CREATE = "insert into users (name, surename, login, password, mail, phone, type, teacherLevel," +
            " teacherPhoto, teacherAbout, teacherExperince,StudentCourse) values (?,?,?,?,?,?,?,?,?,?,?,?);";
private static  final String UPDATE = "update users set login = ?, password = ?, phone = ?,teacherLevel = ?, teacherExperince = ?, studentCourse = ? where idusers = ?;";

private static  final  String UPPHOTO = "update users set teacherPhoto = ? where idusers = ?;";


    private DataSource dataSource;

    public MySQLUserDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public User create(User user) {

        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getMail());
            preparedStatement.setLong(6, user.getPhone());
            preparedStatement.setNull(8, Types.NULL);
            preparedStatement.setNull(9, Types.NULL);
            preparedStatement.setNull(10, Types.NULL);
            preparedStatement.setNull(11, Types.NULL);
            preparedStatement.setNull(12, Types.NULL);
            if (user instanceof Admin) {
                preparedStatement.setString(7, "admin");
            }
            if (user instanceof Teacher) {
                Teacher teacher = (Teacher) user;
                preparedStatement.setString(7, "teacher");
                preparedStatement.setString(8, teacher.getLevel());
                preparedStatement.setBytes(9, teacher.getPhoto());
                preparedStatement.setString(10, teacher.getAbout());
                preparedStatement.setInt(11, teacher.getExperience());
            }
            if (user instanceof Student) {

                Student student = (Student) user;
                preparedStatement.setString(7, "student");
                preparedStatement.setInt(12, student.getCourse());
            }
            int a = preparedStatement.executeUpdate();
            if (a == 0) {
                System.out.println("tyt null");
                return null;
            }
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getLong(1));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public User delete(User user) {
        try(Statement statement = dataSource.getConnection().createStatement()){
            int a = statement.executeUpdate("delete from users where idusers = " +user.getId()+" ;");
            if(a == 0){
                System.out.println(a);
                System.out.println(user + " null dao?");
                return null;
            }
            return user;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public User find(Long aLong) {
        try (Statement statement = dataSource.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("select  * from users where idusers ="+aLong+ ";");
            if(resultSet.next()){
                String name = resultSet.getString(2);
                String surename = resultSet.getString(3);
                String login = resultSet.getString(4);
                String password = resultSet.getString(5);
                String mail = resultSet.getString(6);
                long phone = resultSet.getLong(7);
                String type = resultSet.getString(8);
                if( type.equals("admin")){
                   return new Admin(aLong,name,surename,login,password,mail,phone);
                } if(type.equals("teacher")){

                    Teacher teacher =   new Teacher(aLong,name,surename,login,password,mail,phone,
                            resultSet.getString(9),
                            resultSet.getString(11), resultSet.getInt(12));
                    teacher.setPhoto( resultSet.getBytes(10));
                    return teacher;

                }if(type.equals("student")){
                  return  new Student(aLong,name,surename,login,password,mail,phone,resultSet.getInt(13));
                }
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public User find(String login, String password) {
        try (Statement statement = dataSource.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("select  * from users where login = '"+ login +"' and password = '" + password +"' ;" );
            if(resultSet.next()){
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String surename = resultSet.getString(3);
                String mail = resultSet.getString(6);
                long phone = resultSet.getLong(7);
                String type = resultSet.getString(8);
                if( type.equals("admin")){
                    return new Admin(id,name,surename,login,password,mail,phone);
                }if( type.equals("teacher")){
                    Teacher teacher =   new Teacher(id,name,surename,login,password,mail,phone,
                            resultSet.getString(9),
                            resultSet.getString(11), resultSet.getInt(12));
                    teacher.setPhoto( resultSet.getBytes(10));
                    return teacher;
                      }if(type.equals("student")){
                    return  new Student(id,name,surename,login,password,mail,phone,resultSet.getInt(13));
                }
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public User update(User user) {
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(UPDATE)){
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setLong(3, user.getPhone());
            if (user instanceof  Teacher){
                preparedStatement.setString(4,((Teacher) user).getLevel());
                preparedStatement.setInt(5,((Teacher) user).getExperience());
                preparedStatement.setNull(6,Types.NULL);
            }if(user instanceof  Student){
                preparedStatement.setNull(4,Types.NULL);
                preparedStatement.setNull(5,Types.NULL);
                preparedStatement.setInt(6, ((Student) user).getCourse());
            }
            preparedStatement.setLong(7,user.getId());
            int a = preparedStatement.executeUpdate();
            if (a == 0){
                return null;
            }
            return user;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    public List<User> findAll(){
        try(Statement statement = dataSource.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("select * from users");
            List<User> userList = new ArrayList<>();
            while (resultSet.next()){
                long id = resultSet.getLong(1);
                String name = resultSet.getString(2);
                String surename = resultSet.getString(3);
                String login = resultSet.getString(4);
                String password = resultSet.getString(5);
                String mail = resultSet.getString(6);
                long phone = resultSet.getLong(7);
                String type = resultSet.getString(8);
                if( type.equals("admin")){
                    userList.add( new Admin(id,name,surename,login,password,mail,phone));
                }if( type.equals("teacher")){
                    Teacher teacher =   new Teacher(id,name,surename,login,password,mail,phone,
                            resultSet.getString(9),
                            resultSet.getString(11), resultSet.getInt(12));
                    teacher.setPhoto( resultSet.getBytes(10));
                    userList.add(teacher);
                     }if(type.equals("student")){
                     userList.add(new Student(id,name,surename,login,password,mail,phone,resultSet.getInt(13)));
                }
            }
            return userList;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    public boolean checkLoginPass(String login, String password){
        try (Statement statement = dataSource.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("select users.idusers from users where login ='"+login+"' or password ='"+password+"' ;");
          return  resultSet.next();

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updatePhoto(User user) {
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(UPPHOTO)){
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setBytes(2,user.getPhoto());
            int a = preparedStatement.executeUpdate();
            if (a == 0){
                return false;
            }
            return true;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return false;
    }


}
