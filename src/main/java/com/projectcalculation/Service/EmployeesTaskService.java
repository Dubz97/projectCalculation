package com.projectcalculation.Service;

import com.projectcalculation.Model.EmployeeTasks;
import com.projectcalculation.Model.Project;
import com.projectcalculation.repositories.EmployeeTasksRepository;

import java.util.List;

public class EmployeesTaskService {

  private EmployeeTasksRepository employeeTasksRepository = new EmployeeTasksRepository();


  // @Author : Christopher Samsing
  public void postProjectDetail(EmployeeTasks employeeTasks) {
    employeeTasksRepository.postTaskDetail(employeeTasks);
  }

  // @Author : Christoffer Pedersen
  public List<EmployeeTasks> getAllEmployeeTasks(EmployeeTasks employeeTasks) {
    return employeeTasksRepository.getAllEmployeeTasks(employeeTasks);
  }

  // @Author : Christoffer Pedersen
  public List<EmployeeTasks> getSpecificTask(String specificTask) {
    return employeeTasksRepository.getSpecificTask(specificTask);
  }
}
