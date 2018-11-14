package com.nortoncommander.designpatterns.creational.builder.version1.impl.rest;

import com.nortoncommander.designpatterns.creational.builder.version1.api.UserDTO;

/**
 * Represents a concrete product/object of the Builder pattern
 */
public class UserRestDTO implements UserDTO {
  private String firstName;
  private String lastName;
  private String birthday;
  private String address;

  public UserRestDTO(String firstName, String lastName, String birthday, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthday = birthday;
    this.address = address;
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

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "UserRestDTO { " +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", birthday='" + birthday + '\'' +
        ", address='" + address + '\'' +
        " }";
  }
}
