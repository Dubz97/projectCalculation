package com.projectcalculation.Model;


// @Author : Christopher Samsing
public class Project {

  private int projectId;
  private String name;
  private int caseId;
  private double timeFrame;
  private double timeUsed;
  private double timeLeft;
  private double percentageCalculated;


  public Project(int projectId, String name, int caseId, double timeFrame, double timeUsed, double timeLeft, double percentageCalculated) {
    this.projectId = projectId;
    this.name = name;
    this.caseId = caseId;
    this.timeFrame = timeFrame;
    this.timeUsed = timeUsed;
    this.timeLeft = timeLeft;
    this.percentageCalculated = percentageCalculated;
  }

  public double getPercentageCalculated() {
    return percentageCalculated;
  }

  public void setPercentageCalculated(double percentageCalculated) {
    this.percentageCalculated = percentageCalculated;
  }


  public Project() {
  }

  public int getProjectId() {
    return projectId;
  }

  public void setProjectId(int projectId) {
    this.projectId = projectId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getCaseId() {
    return caseId;
  }

  public void setCaseId(int caseId) {
    this.caseId = caseId;
  }

  public double getTimeFrame() {
    return timeFrame;
  }

  public void setTimeFrame(double timeFrame) {
    this.timeFrame = timeFrame;
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

  @Override
  public String toString() {
    return "Project{" +
        "projectId=" + projectId +
        ", name='" + name + '\'' +
        ", caseId=" + caseId +
        ", timeFrame=" + timeFrame +
        ", timeUsed=" + timeUsed +
        ", timeLeft=" + timeLeft +
        '}';
  }
}
