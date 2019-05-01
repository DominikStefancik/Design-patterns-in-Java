package com.nortoncommander.designpatterns.behavioral.memento.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a workflow in a hypothetical workflow designer application which allows adding/removing items
 * into a workflow and supports Undo operation.
 *
 */
public class Workflow {

  private String name;
  private List<String> steps;

  public Workflow(String name) {
    this.name = name;
    this.steps = new LinkedList<>();
  }

  public Workflow(String name, String... steps) {
    this.name = name;
    this.steps = new LinkedList<>();

    if (steps != null && steps.length > 0) {
      Collections.addAll(this.steps, steps);
    }
  }

  public String getName() {
    return name;
  }

  public List<String> getSteps() {
    return steps;
  }

  public void addStep(String step) {
    this.steps.add(step);
  }

  public void removeStep(String step) {
    this.steps.remove(step);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("Workflow [name=");
    builder.append(name);
    builder.append("]\n");
    builder.append("Begin -> ");

    for (String step : this.steps) {
      builder.append(step);
      builder.append(" -> ");
    }

    return builder.toString();
  }
}
