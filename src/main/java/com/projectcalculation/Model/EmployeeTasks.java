package com.projectcalculation.Model;

public class EmployeeTasks {



  private String employee;
  private String tasks;
  private double startDate;
  private double endDate;
  private double timeUsed;
  private double timeLeft;
  private int taskId;
  private int projectId;


  public EmployeeTasks(String employee, String tasks, double startDate, double endDate, double timeUsed, double timeLeft, int taskId, int projectId) {
    this.employee = employee;
    this.tasks = tasks;
    this.startDate = startDate;
    this.endDate = endDate;
    this.timeUsed = timeUsed;
    this.timeLeft = timeLeft;
    this.taskId = taskId;
    this.projectId = projectId;
  }

  public EmployeeTasks() {}

  public String getEmployee() {
    return employee;
  }

  public void setEmployee(String employee) {
    this.employee = employee;
  }

  public String getTasks() {
    return tasks;
  }

  public void setTasks(String tasks) {
    this.tasks = tasks;
  }

  public double getStartDate() {
    return startDate;
  }

  public void setStartDate(double startDate) {
    this.startDate = startDate;
  }

  public double getEndDate() {
    return endDate;
  }

  public void setEndDate(double endDate) {
    this.endDate = endDate;
  }

  public double getTimeUsed() {
    return timeUsed;
  }

  public void setTimeUsed(double timeUsed) {
    this.timeUsed = timeUsed;
  }

  public double getTimeLeft() {
    return timeLeft;
  }

  public void setTimeLeft(double timeLeft) {
    this.timeLeft = timeLeft;
  }

  public int getTaskId() {
    return taskId;
  }

  public void setTaskId(int taskId) {
    this.taskId = taskId;
  }

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
  }
}
