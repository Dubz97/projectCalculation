package com.projectcalculation.Calculation;

import com.projectcalculation.Model.Project;

public class ProjectCalculator {

  Project project = new Project();

  // Regne resterende tid ud, evt i procenter

  public double timeCalculation(Project project)  {   //???
    double timeCompletition = project.getTimeFrame() - project.getTimeUsed();
    double timeCompletitionPercentage = (project.getTimeUsed() / project.getTimeFrame());

    System.out.println(project.getTimeUsed());
    System.out.println(timeCompletition);
    System.out.println(timeCompletitionPercentage);
    return timeCompletition;
  }




}
