package com.projectcalculation.repositories;

import com.projectcalculation.DBManager.DBManager;
import com.projectcalculation.Model.EmployeeTasks;
import com.projectcalculation.Model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {


  // @Author : Christopher Samsing
  public void postProjectDetail(Project project) {
    Connection con = DBManager.getConnection();
    String QUERY = "INSERT INTO project(name, caseId, timeFrame, timeUsed, timeLeft, percentageCalculated) values (?,?,?,?,?,?)";
    PreparedStatement preparedStatement;

    try {
      preparedStatement = con.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, project.getName());
      preparedStatement.setInt(2, project.getCaseId());
      preparedStatement.setDouble(3, project.getTimeFrame());
      preparedStatement.setDouble(4, project.getTimeUsed());
      preparedStatement.setDouble(5, project.getTimeLeft());
      preparedStatement.setDouble(6, (project.getTimeUsed() / project.getTimeFrame()) * 100);


      preparedStatement.executeUpdate();

      ResultSet ids = preparedStatement.getGeneratedKeys();
      ids.next();
      int id = ids.getInt(1);
      project.setProjectId(id);

    } catch (Exception ignore) {

    }
  }

  // @Author : Christoffer Pedersen
  public List<Project> getAllProjects(Project project) {
    List<Project> result = new ArrayList<>();
    Project project1 = null;
    Connection con = DBManager.getConnection();

    String QUERY = "SELECT * FROM project";

    try {
      PreparedStatement ps = con.prepareStatement(QUERY);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        project1 = new Project(rs.getInt("projectId"),
            rs.getString("name"),
            rs.getInt("caseId"),
            rs.getDouble("timeFrame"),
            rs.getDouble("timeUsed"),
            rs.getDouble("timeLeft"),
            rs.getDouble("percentageCalculated"));
        result.add(project1);
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return result;
  }

  // @Author : Christoffer Pedersen
  public void dropRow(Project project) {
    Connection con = DBManager.getConnection();
    String QUERY = "DELETE FROM project WHERE projectId = ?";
    PreparedStatement preparedStatement;

    try {
      preparedStatement = con.prepareStatement(QUERY);
      preparedStatement.setInt(1, project.getProjectId());

      preparedStatement.executeUpdate();

    } catch (SQLException ex) {
      ex.printStackTrace();
    }

  }

  // @Author : Christoffer Pedersen
  public List<Project> getSpecificProject(String specificProject) {
    List<Project> result = new ArrayList<>();
    Project project1 = null;
    Connection con = DBManager.getConnection();
    int projectId = Integer.parseInt(specificProject);
    String QUERY = "SELECT * FROM project WHERE projectId = ?";

    try {
      PreparedStatement ps = con.prepareStatement(QUERY);
      ps.setInt(1, projectId);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        project1 = new Project(rs.getInt("projectId"),
            rs.getString("name"),
            rs.getInt("caseId"),
            rs.getDouble("timeFrame"),
            rs.getDouble("timeUsed"),
            rs.getDouble("timeLeft"),
            rs.getDouble("percentageCalculated"));
        result.add(project1);
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return result;
  }
  public List<Project> getSpecificProject2(Project project) {
    List<Project> result = new ArrayList<>();
    Project project1 = null;
    Connection con = DBManager.getConnection();
    //int projectId = Integer.parseInt(specificProject);
    String QUERY = "SELECT * FROM project WHERE projectId = ?";

    try {
      PreparedStatement ps = con.prepareStatement(QUERY);
      ps.setInt(1, project.getCaseId());
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        project1 = new Project(rs.getInt("projectId"),
            rs.getString("name"),
            rs.getInt("caseId"),
            rs.getDouble("timeFrame"),
            rs.getDouble("timeUsed"),
            rs.getDouble("timeLeft"),
            rs.getDouble("percentageCalculated"));
        result.add(project1);
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
    }
    return result;
  }


  // @Author : Christopher Samsing
  public Project updateProject(Project project) {
    Connection con = DBManager.getConnection();
    String QUERY = "UPDATE project SET name = ?, timeFrame = ?, timeUsed = ?, timeLeft = ?, percentageCalculated = ? where projectId = ?";
    PreparedStatement preparedStatement;
    try {
      preparedStatement = con.prepareStatement(QUERY, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, project.getName());
      preparedStatement.setDouble(2, project.getTimeFrame());
      preparedStatement.setDouble(3, project.getTimeUsed());
      preparedStatement.setDouble(4, project.getTimeLeft());
      preparedStatement.setInt(5, project.getProjectId());
      preparedStatement.setDouble(6, (project.getTimeUsed() / project.getTimeFrame()) * 100);
      preparedStatement.executeUpdate();


    } catch (Exception ignore) {

    }
    return project;

  }
}