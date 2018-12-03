package com.nortoncommander.designpatterns.creational.factorymethod.api;

/**
 * Represents an abstract "Product" in the Factory Method pattern
 * The abstract product can be either interface or an abstract class
 *
 * Implementation is specific in the subclasses of this abstract product
 */
public abstract class Message {

  public abstract String getContent();

  public void addDefaultHeaders() {
    // add default headers to the message
  }

  public void encrypt() {
    // do some message encryption
  }
}
