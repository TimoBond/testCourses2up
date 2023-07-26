package com.home.controller.storage.dao.impl.mySQL;

import com.home.controller.storage.dao.LectureDAO;
import com.home.model.Course;
import com.home.model.Lecture;
import com.home.model.LectureItem;
import com.home.model.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLLectureDAO implements LectureDAO {

    private static final String CREATE = "insert into lectures (date_start, date_finish, course_id) values (?,?,?);";
    private static final String UPDATE = "update lectures set date_start =?, date_finish =? where idlectures = ?;";

    private static final String UPDATE_ITEMS = "update letcure_items set grade =?, dateGrade = ? where idL =? and id_student = ?;";
    private DataSource dataSource;

    public MySQLLectureDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Lecture create(Lecture lecture) {
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, new java.sql.Date(lecture.getDateStart().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(lecture.getDateStart().getTime()));
            preparedStatement.setInt(3, lecture.getCourse().getId());
            int a = preparedStatement.executeUpdate();
            if (a == 0) {
                return null;
            }
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                lecture.setId(resultSet.getLong(1));
                return lecture;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return null;
    }

    @Override
    public Lecture update(Lecture lecture) {
        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(UPDATE)) {
            preparedStatement.setDate(1, new java.sql.Date(lecture.getDateStart().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(lecture.getDateFinish().getTime()));
            int a = preparedStatement.executeUpdate();
            if (a == 0) {
                return null;
            }
            return lecture;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(List<LectureItem> lectureItems, long id){

        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(UPDATE_ITEMS)){
            for (int i = 0; i < lectureItems.size(); i++) {
                preparedStatement.setInt(1, lectureItems.get(i).getGrade());
                preparedStatement.setDate(2, new java.sql.Date(lectureItems.get(i).getDateGrade().getTime()));
                preparedStatement.setLong(3, id);
                preparedStatement.setLong(4, lectureItems.get(i).getStudent().getId());
                preparedStatement.addBatch();
            }
        preparedStatement.executeBatch();

                return true;

        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return false;
    }

    @Override
    public Lecture find(Long aLong) {
        try (Statement statement = dataSource.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from lectures where idlectures = " + aLong + ";");
            if (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getInt(4));
                return new Lecture(resultSet.getLong(1), resultSet.getDate(2),
                        resultSet.getDate(3), null, course);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Lecture delete(Lecture lecture) {
        try (Statement statement = dataSource.getConnection().createStatement()) {
            int a = statement.executeUpdate("delete from lectures where idlectures = " + lecture.getId() + ";");
            if (a == 0) {
                return null;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public List<LectureItem> find(long id) {
        try (Statement statement = dataSource.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("select letcure_items.*, users.name, users.surename " +
                    "from letcure_items left join users on letcure_items.id_student = idusers where idL =" + id + ";");
            List<LectureItem> lectureItems = new ArrayList<>();
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong(2));
                student.setName(resultSet.getString(7));
                student.setSurname(resultSet.getString(8));
                lectureItems.add(new LectureItem(student, resultSet.getInt(3), resultSet.getDate(4), resultSet.getString(5), resultSet.getInt(6)));
            }
            return lectureItems;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public Lecture findGradeByStudent(long idUser) {
        try (Statement statement = dataSource.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery("select letcure_items.*, course.title " +
                    "from letcure_items left join lectures on  letcure_items.id_student = lectures.idlectures left join course on lectures.course_id = course.idcourse where letcure_items.id_student = "+idUser+" group by DATE(dateGrade) order by  DATE(dateGrade)");
            List<LectureItem> lectureItems = new ArrayList<>();
            while (resultSet.next()) {
                LectureItem lectureItem = new LectureItem(new Student(), resultSet.getInt(3), resultSet.getDate(4), resultSet.getString(5),
                        resultSet.getInt(6));
                lectureItem.setCourse(resultSet.getString(7));
                lectureItems.add(lectureItem);
            }
            Lecture lecture = new Lecture();
            lecture.setLectureItems(lectureItems);
            return lecture;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            ;
        }

        return null;
    }

    public List<Lecture> findLectures(){
        try (Statement statement = dataSource.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("select lectures.*, course.title " +
                    "from lectures left join course on lectures.course_id = course.idcourse");
            List<Lecture> lectures = new ArrayList<>();
            while (resultSet.next()){
                Course course = new Course();
                course.setTitle(resultSet.getString(5));
                lectures.add(new Lecture(resultSet.getLong(1),resultSet.getDate(2), resultSet.getDate(3),new ArrayList<>(),course));
            }
            return lectures;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return  null;
    }

    public List<Lecture> findLectureByTeacher(long idTeacher){
        try (Statement statement = dataSource.getConnection().createStatement()){
            ResultSet resultSet = statement.executeQuery("select lectures.idlectures, lectures.date_start, lectures.date_finish, course.title" +
                    " from course left join lectures on course.idcourse = lectures.course_id where course.professorId = " +idTeacher+ " and  lectures.complete = 0;" );
            List<Lecture> lectures = new ArrayList<>();
            while (resultSet.next()) {
            Course course = new Course();
            course.setTitle(resultSet.getString(4));
            lectures.add(new Lecture(resultSet.getLong(1),resultSet.getDate(2),resultSet.getDate(3),new ArrayList<>(),course));
            }
            return lectures;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }
}
