package com.nortoncommander.designpatterns.behavioral.memento.impl.command;

import com.nortoncommander.designpatterns.behavioral.memento.api.command.WorkflowCommand;
import com.nortoncommander.designpatterns.behavioral.memento.impl.WorkflowDesigner;

/**
 * Represents an abstract workflow command which has an implementation of the Undo method.
 *
 * NOTE: The reason why the class is abstract is that the implementation of the Undo method is the same
 * for all workflow commands.
 */
public abstract class AbstractWorkflowCommand implements WorkflowCommand {

  protected WorkflowDesigner.Memento memento;
  protected WorkflowDesigner receiver;

  public AbstractWorkflowCommand(WorkflowDesigner receiver) {
    this.receiver = receiver;
  }

  @Override
  public void undo() {
    this.receiver.setMemento(memento);
  }
}
