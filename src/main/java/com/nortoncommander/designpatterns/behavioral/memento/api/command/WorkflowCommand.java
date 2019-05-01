package com.nortoncommander.designpatterns.behavioral.memento.api.command;

/**
 * Represents an action/command in the workflow. The command is a "caretaker" of the memento object,
 * i.e. it contains a memento object, so the action step can be undone/reverted.
 *
 * NOTE: The implementation of the workflow action is implemented as the Command design pattern.
 *
 */
public interface WorkflowCommand {

  void execute();
  void undo();
}
