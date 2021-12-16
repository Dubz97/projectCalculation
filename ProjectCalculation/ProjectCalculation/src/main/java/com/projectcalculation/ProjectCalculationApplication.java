package com.projectcalculation;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.projectcalculation.Controllers", "com.projectcalculation.Service"})
public class ProjectCalculationApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProjectCalculationApplication.class, args);


  }

}
