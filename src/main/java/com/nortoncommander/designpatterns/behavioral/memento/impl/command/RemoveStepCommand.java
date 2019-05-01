package com.nortoncommander.designpatterns.behavioral.memento.impl.command;

import com.nortoncommander.designpatterns.behavioral.memento.impl.WorkflowDesigner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a concrete workflow command.
 *
 */
public class RemoveStepCommand extends AbstractWorkflowCommand {

  private static final Logger LOGGER = LoggerFactory.getLogger(RemoveStepCommand.class);

  private String step;

  public RemoveStepCommand(WorkflowDesigner receiver, String step) {
    super(receiver);
    this.step = step;
  }

  @Override
  public void execute() {
    /* Before we execute the command we will store the receiver's state. Then if a user wants to undo this
     * command, we can restore the state, because we have it in the memento object.
     */
    this.memento = receiver.getMemento();
    receiver.removeStep(this.step);

    LOGGER.info("Removing '{}' command executed. Receiver's state: {}", step, receiver.getWorkflow());
  }
}
