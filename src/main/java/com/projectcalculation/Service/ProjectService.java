package com.projectcalculation.Service;


import com.projectcalculation.Model.Project;
import com.projectcalculation.repositories.ProjectRepository;

import java.util.List;

public class ProjectService {

  private ProjectRepository projectRepository = new ProjectRepository();

  // @Author : Christopher Samsing
  public void postProjectDetail(Project project) {
    projectRepository.postProjectDetail(project);
  }

  // @Author : Christoffer Pedersen
  public List<Project> getAllProjects(Project project) {
    return projectRepository.getAllProjects(project);
  }

  // @Author : Christoffer Pedersen
  public void dropRow(Project project) {
    projectRepository.dropRow(project);
  }

  // @Author : Christoffer Pedersen
  public List<Project> getSpecificProject(String specificProject) {
    return projectRepository.getSpecificProject(specificProject);
  }
  public List<Project> getSpecificProject2(Project project) {
    return projectRepository.getSpecificProject2(project);
  }

  // @Author : Christopher Samsing
  public Project updateProject(Project project) {
    return projectRepository.updateProject(project);
  }
}
