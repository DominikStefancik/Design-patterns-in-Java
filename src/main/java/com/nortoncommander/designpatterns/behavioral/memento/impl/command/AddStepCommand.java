package com.nortoncommander.designpatterns.behavioral.memento.impl.command;

import com.nortoncommander.designpatterns.behavioral.memento.impl.WorkflowDesigner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a concrete workflow command.
 *
 */
public class AddStepCommand extends AbstractWorkflowCommand {

  private static final Logger LOGGER = LoggerFactory.getLogger(AddStepCommand.class);

  private String step;

  public AddStepCommand(WorkflowDesigner receiver, String step) {
    super(receiver);
    this.step = step;
  }

  @Override
  public void execute() {
    /* Before we execute the command we will store the receiver's state. Then if a user wants to undo this
     * command, we can restore the state, because we have it in the memento object.
     */
    this.memento = receiver.getMemento();
    receiver.addStep(this.step);

    LOGGER.info("Adding '{}' command executed. Receiver's state: {}", step, receiver.getWorkflow());
  }
}
