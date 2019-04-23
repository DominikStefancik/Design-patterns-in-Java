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
 * In our example, this class represents the action of adding a member to a mailing list in the exchange web service.
 */
public class AddMemberCommand implements Command {

  private static final Logger LOGGER = LoggerFactory.getLogger(AddMemberCommand.class);

  // An email address which will be added into a mailing list
  private final String emailAddress;

  // A name of the mailing list
  private final String listName;

  // Reference to the object on which method "addMemberToMailingList" will be called
  private final ExchangeWebService receiver;

  /**
   * The constructor is the only place where the command object should receive all necessary info to execute the
   * call.
   */
  public AddMemberCommand(String emailAddress, String listName, ExchangeWebService service) {
    LOGGER.info("Creating AddMemberCommand with exchange service={}, emailAddress={}, listName={}",
        service, emailAddress, listName);

    this.emailAddress = emailAddress;
    this.listName = listName;

    // the service parameter can be optional, because
    // the service can be looked up at runtime, e.g. from a application container
    this.receiver = service;
  }

  @Override
  public void execute() {
    this.receiver.addMemberToMailingList(emailAddress, listName);
  }
}
