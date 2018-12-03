package com.nortoncommander.designpatterns.behavioral.mediator.impl;

import com.nortoncommander.designpatterns.behavioral.mediator.api.UIControl;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextField;

/**
 * A concrete implementation of a colleague from the Mediator design pattern.
 * Every colleague has to have a reference to a mediator object, so it can notify the mediator that its
 * state has changed or mediator can notify it that some other colleague has changed.
 */
public class TextBox extends TextField implements UIControl {

  private final UIMediator mediator;

  /**
   * Indication that our property has changed after we were notified by mediator that some other control
   * has changed.
   * We need this flag to avoid the infinite "change-notify-change" loop of sending notification to the mediator
   * that our property has changed because we got a change notification after we triggered out
   * our change notification.
   */
  private boolean mediatedUpdate;

  public TextBox(UIMediator mediator) {
    this.mediator = mediator;
    this.setText("Textbox");

    // register itself to the mediator after being created
    this.mediator.register(this);

    // Add a listener to the text field which informs the mediator that the text has changed
    ChangeListener<String> changeListener = (value, oldValue, newValue) -> {
      if (!mediatedUpdate) {
        this.mediator.valueChanged(this);
      }
    };
    this.textProperty().addListener(changeListener);

  }

  @Override
  public void controlChanged(UIControl uiControl) {
    this.mediatedUpdate = true;
    this.setText(uiControl.getControlValue());

    // make sure that we don't notify the mediator more times
    this.mediatedUpdate = false;
  }

  @Override
  public String getControlValue() {
    return getText();
  }

  @Override
  public String getControlName() {
    return "TextBox";
  }
}
