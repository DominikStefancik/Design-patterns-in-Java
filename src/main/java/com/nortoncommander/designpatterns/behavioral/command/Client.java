package com.nortoncommander.designpatterns.behavioral.command;

import com.nortoncommander.designpatterns.behavioral.command.api.Command;
import com.nortoncommander.designpatterns.behavioral.command.domain.ExchangeWebService;
import com.nortoncommander.designpatterns.behavioral.command.impl.AddMemberCommand;
import com.nortoncommander.designpatterns.behavioral.command.impl.RemoveMemberCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) throws InterruptedException {
    ExchangeWebService service = new ExchangeWebService();

    // The client creates a command and provides all necessary information
    Command command1 = new AddMemberCommand("john@doe.com", "employees", service);
    MailTasksRunner.getInstance().addCommand(command1);

    Command command2 = new AddMemberCommand("alan@apple.com", "employees", service);
    MailTasksRunner.getInstance().addCommand(command2);

    Command command3 = new RemoveMemberCommand("john@doe.com", "employees", service);
    MailTasksRunner.getInstance().addCommand(command3);

    Thread.sleep(3000);
    MailTasksRunner.getInstance().shutdown();
  }
}
