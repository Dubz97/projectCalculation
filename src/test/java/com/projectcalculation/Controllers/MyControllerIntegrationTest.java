package com.projectcalculation.Controllers;

import com.projectcalculation.Service.WelcomeService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.mockito.Mockito.when;


@WebMvcTest
class MyControllerIntegrationTest {



  @MockBean
  private WelcomeService welcomeService;

  @Test
  void shouldGetDeafultWelcomeMessage() throws Exception {
    when(welcomeService.getWelcomeMessage("Stranger")).thenReturn("Welcome Stranger");



  }
}