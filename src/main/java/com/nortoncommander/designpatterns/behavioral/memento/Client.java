package com.nortoncommander.designpatterns.behavioral.memento;

import com.nortoncommander.designpatterns.behavioral.memento.api.command.WorkflowCommand;
import com.nortoncommander.designpatterns.behavioral.memento.impl.WorkflowDesigner;
import com.nortoncommander.designpatterns.behavioral.memento.impl.command.AddStepCommand;
import com.nortoncommander.designpatterns.behavioral.memento.impl.command.CreateWorkflowCommand;

import java.util.LinkedList;

public class Client {

  public static void main(String[] args) {
    WorkflowDesigner workflowDesigner = new WorkflowDesigner();
    LinkedList<WorkflowCommand> commands = runCommands(workflowDesigner);

    workflowDesigner.printWorkflow();
    undoLastCommand(commands);
    workflowDesigner.printWorkflow();
    undoLastCommand(commands);
    workflowDesigner.printWorkflow();
    undoLastCommand(commands);
    workflowDesigner.printWorkflow();
    undoLastCommand(commands);
    workflowDesigner.printWorkflow();
  }

  private static LinkedList<WorkflowCommand> runCommands(WorkflowDesigner workflowDesigner) {
    LinkedList<WorkflowCommand> commands = new LinkedList<>();

    WorkflowCommand command = new CreateWorkflowCommand(workflowDesigner, "Leave workflow");
    commands.add(command);
    command.execute();

    command = new AddStepCommand(workflowDesigner, "Create Leave application");
    commands.add(command);
    command.execute();

    command = new AddStepCommand(workflowDesigner, "Submit Leave application");
    commands.add(command);
    command.execute();

    command = new AddStepCommand(workflowDesigner, "Leave application approved");
    commands.add(command);
    command.execute();

    return commands;
  }

  private static void undoLastCommand(LinkedList<WorkflowCommand> commands) {
    if (!commands.isEmpty()) {
      commands.removeLast().undo();
    }
  }
}
