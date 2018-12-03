package com.nortoncommander.designpatterns.creational.factorymethod.impl;

import com.nortoncommander.designpatterns.creational.factorymethod.api.Message;

/**
 * Represents a concrete "Product" in the Factory Method pattern
 */
public class TextMessage extends Message {
  @Override
  public String getContent() {
    return "Simple text";
  }
}
