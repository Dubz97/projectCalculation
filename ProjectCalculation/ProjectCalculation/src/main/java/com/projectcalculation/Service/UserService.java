package com.projectcalculation.Service;

import com.projectcalculation.repositories.UserRepository;
import com.projectcalculation.Model.User;

import java.util.List;

// @Author : Christoffer Pedersen
public class UserService {


  private UserRepository userRepository = new UserRepository();


  public User checkLogin(User user) {
    return userRepository.checkLogin(user);
  }

  public void postUserDetails(User user) {
    userRepository.saveUser(user);
  }
}
