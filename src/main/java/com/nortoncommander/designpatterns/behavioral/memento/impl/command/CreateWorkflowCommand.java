package com.nortoncommander.designpatterns.behavioral.memento.impl.command;

import com.nortoncommander.designpatterns.behavioral.memento.impl.WorkflowDesigner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a concrete workflow command.
 *
 * In our example, this class represents the very first step of a workflow.
 *
 */
public class CreateWorkflowCommand extends AbstractWorkflowCommand {

  private static final Logger LOGGER = LoggerFactory.getLogger(CreateWorkflowCommand.class);

  private String step;

  public CreateWorkflowCommand(WorkflowDesigner receiver, String step) {
    super(receiver);
    this.step = step;
  }

  @Override
  public void execute() {
    // In this case the memento object will be null, because we don't have a workflow yet
    this.memento = receiver.getMemento();

    // first create a workflow, then add the step to the collection
    receiver.createWorkflow(this.step);
    receiver.addStep(this.step);

    LOGGER.info("'{}' step command executed. Receiver's state: {}", step, receiver.getWorkflow());
  }
}
