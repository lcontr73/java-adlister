package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String username) {
        User user = null;
        String query = "SELECT * FROM users WHERE username=?";
        try{
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                user = new User(
                        rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("email"),
                        rs.getString("password"));
            }
        } catch (SQLException sqle){
            throw new RuntimeException("Error connecting to db", sqle);
        }
        return user;
    }

//    public static void main(String[] args) {
//        Users usersDao = new MySQLUsersDao(new Config());
//        System.out.println(usersDao.findByUsername("bob"));
//        System.out.println(usersDao.findByUsername("tryagain"));
//    }


    @Override
    public Long insert(User user) {
        try {
            PreparedStatement stmt = connection.prepareStatement(createInsertQuery(user), Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }

    }

    private String createInsertQuery(User user) {
        return "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    }

//        public static void main(String[] args) {
//        Users usersDao = new MySQLUsersDao(new Config());
//        User newUser = new User(
//                "bob123",
//                "bob@email",
//                "password"
//        );
//        usersDao.insert(newUser);
//    }
}

