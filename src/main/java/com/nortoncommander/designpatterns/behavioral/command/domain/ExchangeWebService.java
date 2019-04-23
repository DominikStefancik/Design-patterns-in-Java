package com.nortoncommander.designpatterns.behavioral.command.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a receiver in the Command design pattern.
 * On this object a command will call the particular operation(s)/method(s).
 *
 * In our example, this concrete class represents a fictional exchange service which works with different
 * mailing lists and can add/remove/modify various contacts to/from/in these mailing lists.
 * Then it contacts an exchange server to make desired changes with the contacts and mailing lists.
 */
public class ExchangeWebService {

  private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeWebService.class);

  public void addMemberToMailingList(String contact, String contactGroup) {
    // Do some logic with the input parameters

    // then call the exchange server to save the changes

    // after the addition was successful, inform the user
    LOGGER.info("Added contact {} to the contact group {}", contact, contactGroup);
  }

  public void removeMemberFromMailingList(String contact, String contactGroup) {
    // Do some logic with the input parameters

    // then call the exchange server to save the changes

    // after the removal was successful, inform the user
    LOGGER.info("Removed contact {} from the contact group {}", contact, contactGroup);
  }

  public void sendEmailToMailingList(String content, String contactGroup) {
    // Do some logic with the input parameters

    // then call the exchange server to send the message

    // after the message was successfully sent, inform the user
    LOGGER.info("Message with the content '{}' sent to the contact group {}", content, contactGroup);
  }
}
