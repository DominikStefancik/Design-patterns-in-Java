package com.nortoncommander.designpatterns.behavioral.command.api;

/**
 * Represents an abstract command in the Command design pattern.
 *
 * The command object represents a request or method call which needs to be executed.
 * It usually defines one method without parameters to execute the call.
 *
 * The invoker of the command doesn't know the details of the call. It just calls the execution of the command
 * without knowing exactly how to execute it.
 */
public interface Command {

  /**
   * Executes the command on which it is called.
   *
   * The reason why it is so simple and without any parameters is because the command instance (on which this method
   * is called) contains in itself all necessary information to execute the command/call.
   * It contains info about the receiver and the parameters of the method being called.
   */
  void execute();
}
