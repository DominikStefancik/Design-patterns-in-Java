package com.nortoncommander.designpatterns.creational.builder.version1.api;

import com.nortoncommander.designpatterns.creational.builder.domain.Address;

import java.time.LocalDate;

/**
 * Represents an abstract builder
 */
public interface UserDTOBuilder {
  // methods to build "parts" of product at a time
  UserDTOBuilder withFirstName(String firstName);
  UserDTOBuilder withLastName(String lastName);
  UserDTOBuilder withBirthday(LocalDate birthday);
  UserDTOBuilder withAddress(Address address);

  // method to "assemble" the final product/object
  UserDTO build();

  // (optional) method to fetch already built product/object
  UserDTO getUserDTO();

}
