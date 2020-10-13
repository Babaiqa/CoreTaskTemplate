package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Петр", " Петров", (byte) 20);
        userDaoJDBC.saveUser("Иван", "Иванов", (byte) 25);
        userDaoJDBC.saveUser("Сергей", "Сергеев", (byte) 30);
        userDaoJDBC.saveUser("Александр", "Александров", (byte) 35);
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();


    }
}
