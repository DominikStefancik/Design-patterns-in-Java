package com.nortoncommander.designpatterns.creational.factorymethod.impl;

import com.nortoncommander.designpatterns.creational.factorymethod.api.Message;
import com.nortoncommander.designpatterns.creational.factorymethod.api.MessageCreator;

/**
 * Represents a concrete "Creator" in the Factory Method pattern
 */
public class JSONMessageCreator extends MessageCreator {

  @Override
  protected Message createMessage() {
    return new JSONMessage();
  }
}
