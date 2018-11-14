package com.nortoncommander.designpatterns.creational.builder.impl.web;

import com.nortoncommander.designpatterns.creational.builder.api.UserDTO;
import com.nortoncommander.designpatterns.creational.builder.api.UserDTOBuilder;
import com.nortoncommander.designpatterns.creational.builder.domain.Address;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represents a concrete builder for creating UserWebDTO objects
 */
public class UserWebDTOBuilder implements UserDTOBuilder {
  private String firstName;
  private String lastName;
  private String age;
  private String address;
  private UserWebDTO userWebDTO;

  @Override
  public UserDTOBuilder withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  @Override
  public UserDTOBuilder withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  @Override
  public UserDTOBuilder withBirthday(LocalDate birthday) {
    Period ageInYears = Period.between(birthday, LocalDate.now());
    this.age = Integer.toString(ageInYears.getYears());
    return this;
  }

  @Override
  public UserDTOBuilder withAddress(Address address) {
    this.address = new StringBuilder()
        .append(address.getHouseNumber())
        .append(",")
        .append(address.getStreet())
        .append("\n")
        .append(address.getCity())
        .append("\n")
        .append(address.getState())
        .append(" ")
        .append(address.getZipCode())
        .toString();
    return this;
  }

  @Override
  public UserDTO build() {
    String name = firstName + " " + lastName;
    this.userWebDTO = new UserWebDTO(name, this.address, this.age);
    return this.userWebDTO;
  }

  @Override
  public UserDTO getUserDTO() {
    return this.userWebDTO;
  }
}
