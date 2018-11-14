package com.nortoncommander.designpatterns.creational.builder.impl.rest;

import com.nortoncommander.designpatterns.creational.builder.api.UserDTO;
import com.nortoncommander.designpatterns.creational.builder.api.UserDTOBuilder;
import com.nortoncommander.designpatterns.creational.builder.domain.Address;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a concrete builder for creating UserRestDTO objects
 */
public class UserRestDTOBuilder implements UserDTOBuilder {
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

  private String firstName;
  private String lastName;
  private String birthday;
  private String address;
  private UserRestDTO userRestDTO;

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
    this.birthday = formatter.format(birthday);
    return this;
  }

  @Override
  public UserDTOBuilder withAddress(Address address) {
    this.address = new StringBuilder()
        .append(address.getHouseNumber())
        .append(" ")
        .append(address.getStreet())
        .append(", ")
        .append(address.getCity())
        .append(", ")
        .append(address.getState())
        .append(" ")
        .append(address.getZipCode())
        .toString();
    return this;
  }

  @Override
  public UserDTO build() {
    this.userRestDTO = new UserRestDTO(this.firstName, this.lastName, this.birthday, this.address);
    return this.userRestDTO;
  }

  @Override
  public UserDTO getUserDTO() {
    return this.userRestDTO;
  }
}
