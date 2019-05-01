package com.nortoncommander.designpatterns.behavioral.memento.api.command;

/**
 * Represents an action/command in the workflow.
 *
 * NOTE: The implementation of the workflow action is implemented as the Command design pattern.
 *
 */
public interface WorkflowCommand {

  void execute();
  void undo();
}
