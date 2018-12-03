package com.nortoncommander.designpatterns.creational.factorymethod;

import com.nortoncommander.designpatterns.creational.factorymethod.api.Message;
import com.nortoncommander.designpatterns.creational.factorymethod.api.MessageCreator;
import com.nortoncommander.designpatterns.creational.factorymethod.impl.JSONMessageCreator;
import com.nortoncommander.designpatterns.creational.factorymethod.impl.TextMessageCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) {
    // Using creator to create a product, choice of the creator determines the type of product created
    printMessage(new JSONMessageCreator());

    // Using another creator to create another product
    printMessage(new TextMessageCreator());
  }

  private static void printMessage(MessageCreator messageCreator) {
    LOGGER.info("Creator: {}", messageCreator.getClass());

    Message message = messageCreator.getMessage();
    LOGGER.info("Message: {}", message.getContent());
  }
}
