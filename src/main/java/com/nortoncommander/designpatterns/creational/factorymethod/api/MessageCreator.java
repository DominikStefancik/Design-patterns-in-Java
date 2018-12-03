package com.nortoncommander.designpatterns.creational.factorymethod.api;

/**
 * Represents an abstract "Creator" in the Factory Method pattern.
 *
 * Implementation of the factory method creating specific products is defined in the subclasses.
 *
 * NOTE: The base creator can also be a concrete class, but then it has to provide a default implementation
 * for the factory method. In that case the method will create a "default" object.
 */
public abstract class MessageCreator {

  /**
   * This method used/called by the client to get the specific product.
   *
   * Note: The abstract creator usually provides some settings for the object before returning it
   * Then the subclasses don't have to perform these settings
   */
  public Message getMessage() {
    Message message = createMessage();

    // additional settings for the message before we return it
    message.addDefaultHeaders();
    message.encrypt();

    return message;
  }

  /**
   * This is a factory method which produces concrete products.
   *
   * NOTE: An concrete creator implements the factory method which creates only one type of a product.
   */
  protected abstract Message createMessage();
}
