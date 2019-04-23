package com.nortoncommander.designpatterns.behavioral.command.impl;

import com.nortoncommander.designpatterns.behavioral.command.api.Command;
import com.nortoncommander.designpatterns.behavioral.command.domain.ExchangeWebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a concrete command in the Command design pattern.
 * A concrete command should have everything it needs to execute itself. It has to have a reference to the
 * object (receiver) on which it will call the desired method and all input parameters to call the method.
 *
 * In our example, this class represents the action of sending an email to members of a mailing list in
 * the exchange web service.
 */
public class SendEmailCommand implements Command {

  private static final Logger LOGGER = LoggerFactory.getLogger(SendEmailCommand.class);

  // Content of a message being sent
  private final String content;

  // A name of the mailing list
  private final String listName;

  // Reference to the object on which method "sendEmailToMailingList" will be called
  private final ExchangeWebService receiver;

  /**
   * The constructor is the only place where the command object should receive all necessary info to execute the
   * call.
   */
  public SendEmailCommand(String content, String listName, ExchangeWebService service) {
    LOGGER.info("Creating SendEmailCommand with exchange service={}, content={}, listName={}",
        service, content, listName);
    this.content = content;
    this.listName = listName;

    // the service parameter can be optional, because
    // the service can be looked up at runtime, e.g. from a application container
    this.receiver = service;
  }

  @Override
  public void execute() {
    this.receiver.sendEmailToMailingList(content, listName);
  }
}
