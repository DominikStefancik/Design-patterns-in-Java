package com.nortoncommander.designpatterns.creational.builder;

import com.nortoncommander.designpatterns.creational.builder.api.UserDTO;
import com.nortoncommander.designpatterns.creational.builder.api.UserDTOBuilder;
import com.nortoncommander.designpatterns.creational.builder.domain.Address;
import com.nortoncommander.designpatterns.creational.builder.domain.User;
import com.nortoncommander.designpatterns.creational.builder.impl.rest.UserRestDTOBuilder;
import com.nortoncommander.designpatterns.creational.builder.impl.web.UserWebDTOBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * This is our client which also works as "director" and uses particular builders
 */
public class Client {
  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) {
    User user = createUser();

    // UserDTO Web version
    UserDTOBuilder userWebDTOBuilder = new UserWebDTOBuilder();

    UserDTO userWebDTO = directBuild(userWebDTOBuilder, user);
    LOGGER.info(userWebDTO.toString());

    // UserDTO Rest version
    UserDTOBuilder userRestDTOBuilder = new UserRestDTOBuilder();

    UserDTO userRestDTO = directBuild(userRestDTOBuilder, user);
    LOGGER.info(userRestDTO.toString());
  }

  // Method representing director in the Builder pattern
  public static UserDTO directBuild(UserDTOBuilder builder, User user) {
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
