package com.nortoncommander.designpatterns.behavioral.memento.impl;

import com.nortoncommander.designpatterns.behavioral.memento.domain.Workflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an originator (receiver) in the Memento design pattern. It will take "snapshots" of the workflow designer state.
 * It uses Memento object to represent a particular state.
 *
 * In our example, this class represents a workflow designer in a hypothetical workflow designer application which
 * allows adding/removing items into a workflow diagram and supports Undo operation.
 *
 */
public class WorkflowDesigner {

  private static final Logger LOGGER = LoggerFactory.getLogger(WorkflowDesigner.class);

  private Workflow workflow;

  public void createWorkflow(String name) {
    workflow = new Workflow(name);
  }

  public Workflow getWorkflow() {
    return this.workflow;
  }

  public Memento getMemento() {
    if (workflow == null) {
      return new Memento();
    }

    return new Memento(workflow.getName(), workflow.getSteps().toArray(new String[] {}));
  }

  public void setMemento(Memento memento) {
    // if memento is empty, the workflow was null
    if (memento.isEmpty()) {
      this.workflow = null;
    } else { // otherwise set the workflow to the state stored in the memento object
      this.workflow = new Workflow(memento.getWorkflowName(), memento.getWorkflowSteps());
    }
  }

  public void addStep(String step) {
    this.workflow.addStep(step);
  }

  public void removeStep(String step) {
    this.workflow.removeStep(step);
  }

  public void printWorkflow() {
    if (workflow == null) {
      LOGGER.info("There is no workflow created");
    } else {
      LOGGER.info(workflow.toString());
    }
  }

  /**
   * Represents a memento object in the Memento design pattern. It represents a particular "snapshot"
   * of the workflow designer object to which it belongs.
   *
   * NOTE: Only originator object can create and have access to its memento object and nobody else from outside.
   * That's why the Memento class is often defined as an inner class.
   *
   */
  public class Memento {
    private String workflowName;
    private String[] workflowSteps;

    private Memento() {

    }

    private Memento(String workflowName, String[] workflowSteps) {
      this.workflowName = workflowName;
      this.workflowSteps = workflowSteps;
    }

    private String getWorkflowName() {
      return workflowName;
    }

    /**
     * Only originator object has access to the steps of its memento object
     */
    private String[] getWorkflowSteps() {
      return workflowSteps;
    }

    private boolean isEmpty() {
      return this.workflowName == null && this.workflowSteps == null;
    }
  }
}
