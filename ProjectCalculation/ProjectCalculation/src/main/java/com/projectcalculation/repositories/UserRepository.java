package com.projectcalculation.repositories;

import java.sql.*;
import java.util.List;

import com.projectcalculation.DBManager.DBManager;
import com.projectcalculation.Model.User;

public class UserRepository {

  public User saveUser(User user) {
    Connection conn = DBManager.getConnection();

    String query = "insert into users(username, password, mail, firstName, lastName) values (?,?,?,?,?)";
    PreparedStatement preparedStatement;

    try {
      preparedStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, user.getUsername());
      preparedStatement.setString(2, user.getPassword());
      preparedStatement.setString(3, user.getMail());
      preparedStatement.setString(4, user.getFirstName());
      preparedStatement.setString(5, user.getLastName());

      preparedStatement.executeUpdate();


      ResultSet ids = preparedStatement.getGeneratedKeys();
      ids.next();
      int id = ids.getInt(1);
      user.setUserId(id);

    } catch (Exception ignore) {

    }
    return user;
  }

  public User checkLogin(User user) {
    User result = null;
    Connection conn = DBManager.getConnection();
    String SQL = "SELECT * FROM users where username = ? AND password = ?";
    try {
      PreparedStatement ps = conn.prepareStatement(SQL);
      ps.setString(1, user.getUsername());
      ps.setString(2, user.getPassword());
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        result = new User(rs.getString("username"), rs.getString("password"), rs.getString("mail"),
            rs.getString("firstName"), rs.getString("lastName"), rs.getInt("userId"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return result;
  }

  public User checkUsername(User user) {    //Bruges denne?
    try {
      Connection con = DBManager.getConnection();
      String SQL = "INSERT INTO Users (username, password, mail, firstName, lastName) VALUES (?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      ps.setString(1, user.getUsername());
      ps.setString(2, user.getPassword());
      ps.setString(3, user.getMail());
      ps.setString(4, user.getFirstName());
      ps.setString(5, user.getLastName());
      ps.executeUpdate();
      ResultSet ids = ps.getGeneratedKeys();
      ids.next();
      int id = ids.getInt(1);
      user.setUserId(id);
      return user;
    } catch (SQLException ex) {

    }
    return user;
  }
}
