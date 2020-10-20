package jm.task.core.jdbc;


import jm.task.core.jdbc.service.*;


public class Main {
    public static void main(String[] args) {


        UserServiceImpl userServiceImpl = new UserServiceImpl();
        userServiceImpl.createUsersTable();
        userServiceImpl.saveUser("Петр", " Петров", (byte) 20);
        userServiceImpl.saveUser("Иван", "Иванов", (byte) 25);
        userServiceImpl.saveUser("Сергей", "Сергеев", (byte) 30);
        userServiceImpl.saveUser("Александр", "Александров", (byte) 35);
        System.out.println(userServiceImpl.getAllUsers());
        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();
    }
}
