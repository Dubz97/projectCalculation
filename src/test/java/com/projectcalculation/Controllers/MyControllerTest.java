package com.projectcalculation.Controllers;

import com.projectcalculation.Service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MyControllerTest {

  @Test
  void shouldWeWelcome() {    //Unit test
    WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
    when(welcomeService.getWelcomeMessage("John")).thenReturn("Welcome John");
    MyController myController = new MyController(welcomeService);
    assertEquals("Welcome John", myController.welcome("John"));
  }
}