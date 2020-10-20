package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.*;
import org.hibernate.SessionFactory;


public class Main {
    public static void main(String[] args) {


        UserDaoHibernateImpl UserDaoHibernateImpl = new UserDaoHibernateImpl();
        UserDaoHibernateImpl.createUsersTable();
        UserDaoHibernateImpl.saveUser("Петр", " Петров", (byte) 20);
        UserDaoHibernateImpl.saveUser("Иван", "Иванов", (byte) 25);
        UserDaoHibernateImpl.saveUser("Сергей", "Сергеев", (byte) 30);
        UserDaoHibernateImpl.saveUser("Александр", "Александров", (byte) 35);
//        System.out.println(UserDaoHibernateImpl.getAllUsers());
        UserDaoHibernateImpl.cleanUsersTable();
        UserDaoHibernateImpl.dropUsersTable();
    }
}
