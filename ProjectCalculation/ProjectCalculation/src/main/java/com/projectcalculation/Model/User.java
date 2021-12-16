package com.projectcalculation.Model;

public class User {

  private String username;
  private String password;
  private String mail;
  private String firstName;
  private String lastName;
  private int userId;


  public User(String username, String password, String mail, String firstName, String lastName, int userId) {
    this.username = username;
    this.password = password;
    this.mail = mail;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userId = userId;
  }
  public User(String username, String password, String firstName, String lastName, int userId) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userId = userId;
  }
  public User(String username) {}

  public User() {}

  public User(String username, String password, String mail, String firstName, String lastName) {
    this.username = username;
    this.password = password;
    this.mail = mail;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public User(String username, String password) {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
