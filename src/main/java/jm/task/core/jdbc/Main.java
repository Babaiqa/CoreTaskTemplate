package jm.task.core.jdbc;


import jm.task.core.jdbc.dao.UserDaoJDBCImpl;


public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Петр", " Петров", (byte) 20);
        userDaoJDBC.saveUser("Иван", "Иванов", (byte) 25);
        userDaoJDBC.saveUser("Сергей", "Сергеев", (byte) 30);
        userDaoJDBC.saveUser("Александр", "Александров", (byte) 35);
        System.out.println(userDaoJDBC.getAllUsers());
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();
    }
}
