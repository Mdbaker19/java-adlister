package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import dao.Config;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class MySQLUsersDao implements Users{

    private Connection connection;

    public MySQLUsersDao(Config config){

        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

        } catch (SQLException e){
            throw new RuntimeException("Error connecting to database", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try{

            PreparedStatement stm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery(); // this is currently null in de bug when de bug set on line 37
            rs.next();
            return createUserObj(rs);

        } catch (SQLException e){
            throw new RuntimeException("No user found with username " + username, e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";

        try{

            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e){
            throw new RuntimeException("Error creating user ", e);
        }
    }

    @Override
    public String matchingPasswordForUN(String username){
        String query = "SELECT password FROM users WHERE username = ?";

        try{
            PreparedStatement stm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            rs.next();
            return rs.getString("password");


        } catch (SQLException e){
            throw new RuntimeException("No passwords match for username " + username, e);
        }
    }

    @Override
    public User createUser(String email, String un, String password) {
        User newUser = new User();
        newUser.setUsername(un);
        newUser.setEmail(email);
        newUser.setPassword(password);

        return newUser;
    }

    @Override
    public Set<String> allCurrUserNames() {
        // get all current usernames in DB against curr user name in servlet for a contains already

        Set<String> allUNs = new HashSet<>();

        String query = "SELECT username FROM users";

        try{

            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet rs = stm.executeQuery();

            while(rs.next()){
                allUNs.add(rs.getString("username"));
            }

            return allUNs;

        } catch (SQLException e){
            throw new RuntimeException("No users found", e);
        }

    }

    private User createUserObj(ResultSet rs) throws SQLException {
        return new User(
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

//    public static void main(String[] args) {
//        Set<String> test = DaoFactory.getUsersDao().allCurrUserNames();
//
//        System.out.println(test);
//    }

}
