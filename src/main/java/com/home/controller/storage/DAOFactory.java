package com.home.controller.storage;

import com.home.controller.storage.dao.DAO;
import com.home.controller.storage.dao.impl.mySQL.MySQLCourseDAO;
import com.home.controller.storage.dao.impl.mySQL.MySQLLectureDAO;
import com.home.controller.storage.dao.impl.mySQL.MySQLUserDAO;
import com.home.model.Entity;
import com.home.model.Lecture;
import com.home.model.User;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public abstract class DAOFactory {

    private static DAOFactory daoFactory = new MySqlDAOFactory();


    public abstract <E extends Entity<K>, K> DAO<E, K> getDAO(Class<E> clazz);

    public static DAOFactory getDaoFactory() {
        return daoFactory;
    }


    private static class MySqlDAOFactory extends DAOFactory {
        private DataSource dataSource;

        public MySqlDAOFactory() {
            try {
                Context context = (Context) new InitialContext().lookup("java:comp/env");
                dataSource = (DataSource) context.lookup("jdbc/courses");
            }catch (NamingException namingException){
                namingException.printStackTrace();
            }

        }

        public <E extends Entity<K>, K> DAO<E, K> getDAO(Class<E> clazz) {
            try {
                E e = clazz.newInstance();
                if (e instanceof User) {
                    return (DAO<E, K>) new MySQLUserDAO(dataSource);
                } if (e instanceof Lecture) {
                    return (DAO<E, K>) new MySQLLectureDAO(dataSource);
                } else {
                    return (DAO<E, K>) new MySQLCourseDAO(dataSource);
                }
            } catch (InstantiationException | IllegalAccessException exception) {
                exception.printStackTrace();
            }
            return null;
        }


    }


}
