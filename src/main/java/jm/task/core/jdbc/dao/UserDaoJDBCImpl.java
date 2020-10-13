package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection conn;

    public UserDaoJDBCImpl() {
        conn = new Util().connect();
    }

    public void createUsersTable() {
        try {
            conn.createStatement().executeUpdate("CREATE TABLE IF NOT EXISTS usersTable (id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(20) NOT NULL, lastname VARCHAR(20) NOT NULL, age TINYINT NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            conn.createStatement().executeUpdate("DROP TABLE IF EXISTS usersTable");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            conn.createStatement().executeUpdate("INSERT INTO usersTable(name, lastname, age) VALUES ('"
                    + name + "', '"
                    + lastName + "', "
                    + age + ")");

            System.out.printf("User с именем – %s добавлен в базу данных" + '\n', name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            conn.createStatement().executeUpdate("DELETE FROM usersTable WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = conn.createStatement().executeQuery("SELECT * FROM usersTable");
            while (rs.next()){
                list.add(new User(rs.getString(2), rs.getString(3), rs.getByte(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try {
            conn.createStatement().executeUpdate("TRUNCATE TABLE usersTable");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
