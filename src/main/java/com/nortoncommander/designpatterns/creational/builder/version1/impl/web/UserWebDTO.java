package com.nortoncommander.designpatterns.creational.builder.version1.impl.web;

import com.nortoncommander.designpatterns.creational.builder.version1.api.UserDTO;

/**
 * Represents a concrete product/object of the Builder pattern
 */
public class UserWebDTO implements UserDTO {
  private String name;
  private String address;
  private String age;

  public UserWebDTO(String name, String address, String age) {
    this.name = name;
    this.address = address;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "UserWebDTO { " +
        "name = '" + name + '\'' +
        ", address = '" + address + '\'' +
        ", age = " + age +
        " }";
  }
}
