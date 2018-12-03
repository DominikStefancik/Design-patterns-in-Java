package com.nortoncommander.designpatterns.behavioral.mediator.impl;

import com.nortoncommander.designpatterns.behavioral.mediator.api.UIControl;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a concrete mediator in the Mediator pattern.
 * It contains a list of colleagues which communicate between each other. The colleagues register themselves to
 * the mediator or mediator can create the colleague objects itself.
 * The mediator can work with objects (representing colleagues) of any type (that's why we define colleague
 * as interface).
 *
 * Note: You can create an interface or an abstract class of the Mediator and then creating its implementation
 * class. Or, which is more common, you can create directly a concrete class representing the Mediator when
 * we don't need to create a subclass of the Mediator.
 */
public class UIMediator {

  // List of objects/colleagues which are participating in collaboration
  private final List<UIControl> colleagues;

  public UIMediator() {
    this.colleagues = new ArrayList<>();
  }

  /**
   * This method will be called by each object which wants to participate in the collaboration
   * (i.e. wants to become a colleague).
   * The object will pass a reference to itself as an argument.
   */
  public void register(UIControl control) {
    colleagues.add(control);
  }

  /**
   * This method is called by the objects/colleagues when their state has changed. They inform the mediator
   * that their state has changed.
   * The object which calls this method is going to pass itself as an argument.
   * Within the method mediator inform all the other objects/colleagues that some colleague
   * has changed its state.
   *
   * Note: You can implement this method that in only notifies the objects that some other object has changed.
   * In that case the other objects will have to ask (the object which changed) what exactly has changed.
   * Or, in the method call, you can notify that the object has changed and provide the information what
   * exactly has changed (then the other objects will not have to ask about it)
   */
  public void valueChanged(UIControl control) {
    // notify all registered colleagues except the one which has changed
    colleagues.stream()
        .filter(currentControl -> !currentControl.equals(control))
        .forEach(currentControl -> currentControl.controlChanged(control));
  }
}
