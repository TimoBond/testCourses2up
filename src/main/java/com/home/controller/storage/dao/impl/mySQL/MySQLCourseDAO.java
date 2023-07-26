package com.home.controller.storage.dao.impl.mySQL;

import com.home.controller.storage.dao.CourseDAO;
import com.home.model.Course;
import com.home.model.Teacher;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLCourseDAO implements CourseDAO {
    private static final String CREATE = "insert into course (title, cover, duration, description, professorId)" +
            " values (?,?,?,?,?);";
    private static final String UPDATE = "update course  set title = ?, cover = ?,duration = ?, description = ?, professorId = ? where idcourse = ?;";
    private DataSource dataSource;

    public MySQLCourseDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public Course create(Course course) {
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, course.getTitle());
            preparedStatement.setBytes(2, course.getCover());
            preparedStatement.setInt(3, course.getDuration());
            preparedStatement.setString(4, course.getDescription());
            preparedStatement.setLong(5, course.getProfessor().getId());
            int a = preparedStatement.executeUpdate();
            if (a == 0) {
                return null;
            }
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                course.setId(resultSet.getInt(1));
                return course;
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Course update(Course course) {
        try (PreparedStatement preparedStatement =dataSource.getConnection().prepareStatement(UPDATE)){
            preparedStatement.setString(1,course.getTitle());
            preparedStatement.setBytes(2,course.getCover());
            preparedStatement.setInt(3,course.getDuration());
            preparedStatement.setString(4,course.getDescription());
            preparedStatement.setLong(5,course.getProfessor().getId());
            preparedStatement.setInt(6,course.getId());
            int a = preparedStatement.executeUpdate();
            if(a == 0){
                return null;
            }
            return course;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Course delete(Course course) {
        try (Statement statement = dataSource.getConnection().createStatement()){
            int a = statement.executeUpdate("delete from course where idcourse = " + course.getId() + ";");
            if (a == 0){
                return null;
            }
            return course;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Course find(Integer integer) {
        try (Statement statement = dataSource.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("select course.title, course.cover, course.duration, course.description," +
                    " users.idusers, users.name, users.surename, users.login, users.password, users.mail," +
                    " users.phone, users.teacherLevel, users.teacherPhoto, users.teacherAbout, users.teacherExperince from course left join user on course.professorId =users.idusers where idcourse = " +integer+ ";");
            if(resultSet.next()){
                String title = resultSet.getString(1);
                byte[] cover = resultSet.getBytes(2);
                int duration = resultSet.getInt(3);
                String description = resultSet.getString(4);
                Teacher professor = new Teacher(resultSet.getLong(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8),resultSet.getString(9),
                        resultSet.getString(10),resultSet.getLong(11),resultSet.getString(11),resultSet.getString(13),resultSet.getInt(14));
                professor.setPhoto(resultSet.getBytes(12));
                return  new Course(integer,title,cover,duration,description,professor);
            }
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Course find(String title, Teacher proffecor) {
        return null;
    }


    public List<Course> findCourses(){
        try (Statement statement = dataSource.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT course.idcourse, course.title, course.cover, course.duration, course.description," +
                    " users.idusers, users.name, users.surename, users.mail," +
                    " users.phone, users.teacherLevel, users.teacherPhoto, users.teacherAbout, users.teacherExperince FROM course LEFT JOIN users ON course.professorId = users.idusers;");
            List<Course>  courses = new ArrayList<>();
            while (resultSet.next()){
                Teacher teacher = new Teacher();
                System.out.println(resultSet.getLong(6) + " cccccc");
                teacher.setId(resultSet.getLong(6));
                teacher.setName(resultSet.getString(7));
                teacher.setSurname(resultSet.getString(8));
                teacher.setMail(resultSet.getString(9));
                teacher.setPhone(resultSet.getLong(10));
                teacher.setLevel(resultSet.getString(11));
                teacher.setPhoto(resultSet.getBytes(12));
                teacher.setAbout(resultSet.getString(13));
                teacher.setExperience(resultSet.getInt(14));
            courses.add( new Course( resultSet.getInt(1),resultSet.getString(2), resultSet.getBytes(3),
                    resultSet.getInt(4),resultSet.getString(5), teacher));
            }
            return courses;

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }
}
