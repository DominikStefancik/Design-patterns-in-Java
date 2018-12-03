package com.nortoncommander.designpatterns.behavioral.mediator.api;

/**
 * Represents an abstract colleague in the Mediator pattern.
 * The colleague can be either an interface (which is then implemented by concrete classes) or it can be
 * a concrete class which may serve as a base class for other classes extending it.
 *
 * Note: The name "Colleague" in the Mediator pattern means that the object is on the same communication
 * level as other objects with which it communicates. That means that if the state of one colleague object changes
 * it notifies all other colleague objects which participate in the communication (via Mediator).
 */
public interface UIControl {

  /**
   * This method notifies the UIControl that some other control has changed its state
   */
  void controlChanged(UIControl uiControl);

  /**
   * Returns the value of the UIControl object
   */
  String getControlValue();

  /**
   * Returns the name of the UIControl object
   */
  String getControlName();
}
