package com.projectcalculation.Service;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {

    public String getWelcomeMessage(String name)  {
      return String.format("Welcome %s", name);
    }
}
