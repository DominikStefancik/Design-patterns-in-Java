package com.nortoncommander.designpatterns.behavioral.command;

import com.nortoncommander.designpatterns.behavioral.command.api.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents an invoker in the Command design pattern.
 * The invoker is an object which will call execution of commands without knowing the details about
 * how to execute them.
 *
 * In our example, this class contains a list of commands waiting to be executed and it runs
 * a worker thread to execute them.
 * NOTE: The invoker doesn't have to be implemented as a thread. Here it is only to show that
 * commands can be queued and executed in parallel.
 */
public class MailTasksRunner implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(MailTasksRunner.class);

  private Thread runner;

  private List<Command> pendingCommands;

  private volatile boolean stop;

  private static final MailTasksRunner RUNNER = new MailTasksRunner();

  public static MailTasksRunner getInstance() {
    return RUNNER;
  }

  private MailTasksRunner() {
    pendingCommands = new LinkedList<>();
    runner = new Thread(this);
    runner.start();
  }

  /**
   * Run method takes pending commands and executes them one by one
   */
  @Override
  public void run() {
    while (true) {
      Command command = null;
      synchronized (pendingCommands) {
        if (pendingCommands.isEmpty()) {
          try {
            // wait until any command is available
            pendingCommands.wait();
          } catch (InterruptedException e) {
            LOGGER.info("Runner interrupted");
            if (stop) {
              LOGGER.info("Runner stopping");
              return;
            }
          }
        } else {
          command = pendingCommands.remove(0);
        }
      }

      if (command == null) {
        return;
      }

      command.execute();
    }
  }

  /**
   * Giving it a command will schedule it for later execution
   */
  public void addCommand(Command command) {
    synchronized (pendingCommands) {
      pendingCommands.add(command);
      pendingCommands.notifyAll();
    }
  }

  public void shutdown() {
    this.stop = true;
    this.runner.interrupt();
  }
}
