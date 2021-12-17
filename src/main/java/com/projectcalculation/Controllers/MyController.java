package com.projectcalculation.Controllers;


import com.projectcalculation.Model.EmployeeTasks;
import com.projectcalculation.Model.Project;
import com.projectcalculation.Service.EmployeesTaskService;

import com.projectcalculation.Service.ProjectService;
import com.projectcalculation.Service.UserService;
import com.projectcalculation.Service.WelcomeService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import com.projectcalculation.Model.User;

@Controller
public class MyController {

  UserService userService = new UserService();
  ProjectService projectService = new ProjectService();
  EmployeesTaskService employeesTaskService = new EmployeesTaskService();
  User user = new User();



  //@Author Christoffer Pedersen
  private WelcomeService welcomeService;      //test


  public MyController(WelcomeService welcomeService)  {   //test
    this.welcomeService = welcomeService;
  }

  @GetMapping("/welcome")     //test
  public String welcome(@RequestParam(defaultValue = "Stranger") String name) {
    return welcomeService.getWelcomeMessage(name);
  }



  // @Author : Christopher Samsing
  @GetMapping("/createProject")
  public String createProject(Project project, Model model, WebRequest request) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    project.setCaseId(user.getUserId());

    model.addAttribute("project", project);
    model.addAttribute("user", user);

    return "createProject";
  }

  // @Author : Christopher Samsing
  @PostMapping("/createProject")
  public String saveProject(WebRequest request, Project project) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    project.setCaseId(user.getUserId());

    projectService.postProjectDetail(project);


    return "redirect:/createProject";
  }

  // @Author : Christoffer Pedersen
  @GetMapping("/employeeTask")
  public String createEmployeeTask(EmployeeTasks employeeTasks, Model model, WebRequest request) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION); //I get gør denne at man SKAL være logget ind for at se siden
    employeeTasks.setProjectId(user.getUserId());                               //I get gør denne at man SKAL være logget ind for at se siden

    model.addAttribute("employeeTasks", employeeTasks);
    model.addAttribute("user", user);

    return "employeeTask";
  }

  // @Author : Christoffer Pedersen
  @PostMapping("/employeeTask")
  public String saveEmployeeTask(WebRequest request, EmployeeTasks employeeTasks) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);   //I post gør denne at man gemmer infoen under den rigtige userId
    employeeTasks.setProjectId(user.getUserId());                                 //I post gør denne at man gemmer infoen under den rigtige userId

    employeesTaskService.postProjectDetail(employeeTasks);


    return "redirect:/employeeTask";
  }

  // @Author : Christoffer Pedersen
  @GetMapping("/editEmployeeTask")
  public String showList(Model model, EmployeeTasks employeeTasks, WebRequest request) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    employeeTasks.setProjectId(user.getUserId());

    model.addAttribute("EmployeeTaskList", employeesTaskService.getAllEmployeeTasks(employeeTasks));

    return "editEmployeeTask";
  }

  // @Author : Christoffer Pedersen
  @PostMapping("/editEmployeeTask")
  public String editEmployeeTask(WebRequest request, EmployeeTasks employeeTasks, Project project, Model model) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    employeeTasks.setProjectId(project.getCaseId());
    model.addAttribute("EmployeeTaskList", employeesTaskService.getAllEmployeeTasks(employeeTasks));
    return "redirect:/editEmployeeTask";
  }

  // @Author : Christoffer Pedersen
  @GetMapping("/editProject")     //Vis projekt info
  public String showInfo(Project project, Model model, WebRequest request) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    project.setCaseId(user.getUserId());

    model.addAttribute("projectList", projectService.getAllProjects(project));

    return "editProject";
  }

  // @Author : Christoffer Pedersen
  @PostMapping("/editProject")
  public String editInfoSumbit(@ModelAttribute Project project, Model model, WebRequest request) {
    //model.addAttribute("project", listAllInfoService.listAllInfo());
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    project.setCaseId(user.getUserId());


    model.addAttribute("projectList", projectService.updateProject(project));
    return "redirect:/editProject";
  }

  // @Author : Christopher Samsing
  @GetMapping("/login")
  public String login(User user, Model model) {
    model.addAttribute("user", user);
    return "login";
  }

  // @Author : Christoffer Pedersen
  @GetMapping("/show")
  public String show(WebRequest request, Model model, Project project, User user, EmployeeTasks employeeTasks) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    project.setCaseId(user.getUserId());
    employeeTasks.setProjectId(user.getUserId());

    model.addAttribute("employee", employeeTasks);
    model.addAttribute("projectList", projectService.getAllProjects(project));
    model.addAttribute("employeeProjectList", employeesTaskService.getAllEmployeeTasks(employeeTasks));
    //model.addAttribute("timeCalculation", projectCalculator.timeCalculation(project));


    return "showProject";
  }

  // @Author : Christoffer Pedersen
  @PostMapping("/show")
  public String buildProject(WebRequest request, Model model, Project project, User user, EmployeeTasks employeeTasks) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    project.setCaseId(user.getUserId());
    employeeTasks.setProjectId(user.getUserId());


    model.addAttribute("employee", employeeTasks);
    model.addAttribute("projectList", projectService.getAllProjects(project));
    model.addAttribute("employeeProjectList", employeesTaskService.getAllEmployeeTasks(employeeTasks));

    //Form request med button

    return "showProject";
  }

  // @Author : Christoffer Pedersen
  @PostMapping("/showFilter")
  public String showFilter(WebRequest request, Model model, Project project, EmployeeTasks employeeTasks) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    project.setCaseId(user.getUserId());
    employeeTasks.setProjectId(user.getUserId());

//  System.out.println(request.getParameter("tasks"));            // tester i vores konsol om vi får det rigtige id
//  System.out.println(request.getParameter("employeeTasks"));   //  tester i vores konsol om vi får det rigtige id
    model.addAttribute("project", project);
    model.addAttribute("employee", employeeTasks);
    model.addAttribute("EmployeeTaskList", employeesTaskService.getSpecificTask(request.getParameter("employeeTasks")));
    model.addAttribute("projectList", projectService.getSpecificProject(request.getParameter("tasks")));

    return "showProject";
  }

  // @Author : Christopher Samsing
  @GetMapping("/")
  public String index() {


    return "index";
  }

  // @Author : Christopher Samsing
  @GetMapping("/create")   // Create knappen til create siden
  public String createUser(Model model, User user) {
    model.addAttribute("user", user);
    return "createAccount";
  }

  // @Author : Christopher Samsing
  @PostMapping("/create/user") //tjek denne metode, opretter heller ikke users i DB
  public String indexSubmit(WebRequest request, User user, Model model) {
    //Retrieve values from HTML form via WebRequest
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    user.setUsername(username);
    user.setPassword(password);
    userService.postUserDetails(user);

//    user = userService.createUser();
    request.setAttribute("user", user, WebRequest.SCOPE_SESSION);


    return "login";

  }

  // @Author : Christopher Samsing
  private void setSessionInfo(WebRequest request, User user) {    // Bruges til at huske seperate users
    // Place user info on session
    request.setAttribute("user", user, WebRequest.SCOPE_SESSION);
  }

  // @Author : Christopher Samsing
  @PostMapping("/login/index")
  public String indexLogin(WebRequest request, Model model, User user) {

    User loggedIn = userService.checkLogin(user);

    if (loggedIn == null) {
      model.addAttribute("loginError", true);
      return "login";
    } else {
      setSessionInfo(request, loggedIn);
      model.addAttribute("loginSucces", true);
      return "project";
    }
  }

  // @Author : Christoffer Pedersen
  @GetMapping("/deleteRow")
  public String deleteRow(Project project, WebRequest request, Model model) {
    user = (User) request.getAttribute("user", WebRequest.SCOPE_SESSION);
    project.setCaseId(user.getUserId());
    model.addAttribute("projectList", projectService.getAllProjects(project));
    model.addAttribute("project", project);
    projectService.dropRow(project);
    return "deleteRow";
  }

  // @Author : Christoffer Pedersen
  @PostMapping("/deleteRow")
  public String deleteRow2(Project project, WebRequest request, Model model) {
    project.setCaseId(user.getUserId());
    model.addAttribute("projectList", projectService.getAllProjects(project));
    model.addAttribute("project", project);
    projectService.dropRow(project);
    return "redirect:/deleteRow";
  }

}