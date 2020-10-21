package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private Session session;
    private final SessionFactory sessionFactory;

    public UserDaoHibernateImpl() {
        sessionFactory = Util.getSessionFactory();
    }


    @Override
    public void createUsersTable() {
        try {
            session = sessionFactory.openSession();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS usersTable (id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(20) NOT NULL, lastname VARCHAR(20) NOT NULL, age TINYINT NOT NULL)").executeUpdate();
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            session = sessionFactory.openSession();
            session.createSQLQuery("DROP TABLE IF EXISTS usersTable").executeUpdate();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            User user = new User(name, lastName, age);

            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            User user;

            session = sessionFactory.openSession();
            session.beginTransaction();
            user = (User) session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        try {
            session = sessionFactory.openSession();
            list = session.createCriteria(User.class).list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    @Override
    public void cleanUsersTable() {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            List<User> list = session.createCriteria(User.class).list();
            for (User user : list) {
                session.delete(user);
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
