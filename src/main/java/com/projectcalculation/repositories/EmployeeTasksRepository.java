package com.projectcalculation.repositories;

import com.projectcalculation.DBManager.DBManager;
import com.projectcalculation.Model.EmployeeTasks;
import com.projectcalculation.Model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTasksRepository {


  // @Author : Christopher Samsing
  public void postTaskDetail(EmployeeTasks employeesTasks) {
    Connection con = DBManager.getConnection();
    String QUERY = "INSERT INTO employeesTasks(employee, tasks, startDate, endDate, timeUsed, timeLeft, projectId) values (?,?,?,?,?,?,?)";
    PreparedStatement preparedStatement;

    try {
      preparedStatement = con.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, employeesTasks.getEmployee());
      preparedStatement.setString(2, employeesTasks.getTasks());
      preparedStatement.setDouble(3, employeesTasks.getStartDate());
      preparedStatement.setDouble(4, employeesTasks.getEndDate());
      preparedStatement.setDouble(5, employeesTasks.getTimeUsed());
      preparedStatement.setDouble(6, employeesTasks.getTimeLeft());
      preparedStatement.setInt(7, employeesTasks.getProjectId());

      preparedStatement.executeUpdate();

      ResultSet ids = preparedStatement.getGeneratedKeys();
      ids.next();
      int id = ids.getInt(1);
      employeesTasks.setProjectId(id);

    } catch (Exception ignore) {
      ignore.printStackTrace();
    }
  }

  // @Author : Christoffer Pedersen
  public List<EmployeeTasks> getAllEmployeeTasks(EmployeeTasks employeeTasks) {
    List<EmployeeTasks> result = new ArrayList<>();
    EmployeeTasks employeeTasks1 = null;
    Connection con = DBManager.getConnection();

    String QUERY = "SELECT * FROM employeesTasks WHERE projectId = ?";

    try {
      PreparedStatement ps = con.prepareStatement(QUERY);
      ps.setInt(1, employeeTasks.getProjectId());
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        employeeTasks1 = new EmployeeTasks(rs.getString("employee"),
            rs.getString("tasks"),
            rs.getDouble("startDate"),
            rs.getDouble("endDate"),
            rs.getDouble("timeUsed"),
            rs.getDouble("timeLeft"),
            rs.getInt("taskId"),
            rs.getInt("projectId"));
        result.add(employeeTasks1);
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return result;
  }

  // @Author : Christoffer Pedersen
  public List<EmployeeTasks> getSpecificTask(String specificTask) {
    List<EmployeeTasks> result = new ArrayList<>();
    EmployeeTasks employeeTasks1 = null;
    Connection con = DBManager.getConnection();
    int taskId = Integer.parseInt(specificTask);
    String QUERY = "SELECT * FROM employeesTasks WHERE taskId = ?";

    try {
      PreparedStatement ps = con.prepareStatement(QUERY);
      ps.setInt(1, taskId);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        employeeTasks1 = new EmployeeTasks(rs.getString("employee"),
            rs.getString("tasks"),
            rs.getDouble("startDate"),
            rs.getDouble("endDate"),
            rs.getDouble("timeUsed"),
            rs.getDouble("timeLeft"),
            rs.getInt("taskId"),
            rs.getInt("projectId"));
        result.add(employeeTasks1);
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return result;
  }
}
