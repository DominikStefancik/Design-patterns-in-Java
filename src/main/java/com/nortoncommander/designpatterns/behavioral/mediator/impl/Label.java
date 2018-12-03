package com.nortoncommander.designpatterns.behavioral.mediator.impl;

import com.nortoncommander.designpatterns.behavioral.mediator.api.UIControl;

/**
 * A concrete implementation of a colleague from the Mediator design pattern.
 * Every colleague has to have a reference to a mediator object, so it can notify the mediator that its
 * state has changed or mediator can notify it that some other colleague has changed.
 *
 * Note: Label is only a read-only UIControl, we don't have a change listener attached to it.
 */
public class Label extends javafx.scene.control.Label implements UIControl {

  private final UIMediator mediator;

  public Label(UIMediator mediator) {
    this.mediator = mediator;
    this.setMinWidth(100);
    this.setText("Label");

    // register itself to the mediator after being created
    this.mediator.register(this);
  }

  @Override
  public void controlChanged(UIControl uiControl) {
    this.setText(uiControl.getControlValue());
  }

  @Override
  public String getControlValue() {
    return this.getText();
  }

  @Override
  public String getControlName() {
    return "Label";
  }
}
