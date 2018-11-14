package com.nortoncommander.designpatterns.creational.builder.version2;

import com.nortoncommander.designpatterns.creational.builder.domain.Address;

import java.time.LocalDate;
import java.time.Period;

/**
 * Represents a concrete product/object of the Builder pattern.
 * This version of the Builder pattern with inner builder class is commonly used in real applications.
 * Note: The product class has only constructor with no arguments and all setters are made private
 */
public class UserDTO {
  private String name;
  private String address;
  private String age;

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getAge() {
    return age;
  }

  private void setName(String name) {
    this.name = name;
  }

  private void setAddress(String address) {
    this.address = address;
  }

  private void setAge(String age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "UserDTO { " +
        "name = '" + name + '\'' +
        ", address = '" + address + '\'' +
        ", age = " + age +
        " }";
  }

  // Get builder instance
  public static UserDTOBuilder builder() {
    return new UserDTOBuilder();
  }

  // Inner builder class
  public static class UserDTOBuilder {
    private String firstName;
    private String lastName;
    private String age;
    private String address;
    private UserDTO userDTO;

    public UserDTOBuilder withFirstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public UserDTOBuilder withLastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public UserDTOBuilder withBirthday(LocalDate birthday) {
      Period ageInYears = Period.between(birthday, LocalDate.now());
      this.age = Integer.toString(ageInYears.getYears());
      return this;
    }

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

    public UserDTO build() {
      this.userDTO = new UserDTO();
      this.userDTO.setName(this.firstName + " " + this.lastName);
      this.userDTO.setAddress(this.address);
      this.userDTO.setAge(this.age);

      return this.userDTO;
    }

    public UserDTO getUserDTO() {
      return this.userDTO;
    }
  }
}
