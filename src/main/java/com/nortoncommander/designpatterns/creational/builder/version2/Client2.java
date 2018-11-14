package com.nortoncommander.designpatterns.creational.builder.version2;

import com.nortoncommander.designpatterns.creational.builder.domain.Address;
import com.nortoncommander.designpatterns.creational.builder.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * This is our client which also works as "director" and uses particular builders
 */
public class Client2 {
  private static final Logger LOGGER = LoggerFactory.getLogger(Client2.class);

  public static void main(String[] args) {
    User user = createUser();

    // UserDTO version with inner builder class
    UserDTO.UserDTOBuilder userDTOBuilder = UserDTO.builder();

    UserDTO userDTO = directBuild(userDTOBuilder, user);
    LOGGER.info(userDTO.toString());
  }

  // Method representing director in the Builder pattern
  public static UserDTO directBuild(UserDTO.UserDTOBuilder builder, User user) {
    return builder.withFirstName(user.getFirstName())
        .withLastName(user.getLastName())
        .withBirthday(user.getBirthday())
        .withAddress(user.getAddress())
        .build();
  }

  public static User createUser() {
    User user = new User();
    user.setFirstName("John");
    user.setLastName("McKintosh");
    user.setBirthday(LocalDate.of(1960, 5, 15));
    Address address = new Address();
    address.setHouseNumber("100");
    address.setStreet("State Street");
    address.setCity("Pawnee");
    address.setState("Indiana");
    address.setZipCode("479888");
    user.setAddress(address);

    return user;
  }
}
