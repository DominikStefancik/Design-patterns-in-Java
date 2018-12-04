package com.nortoncommander.designpatterns.creational.abstractfactory.api;

/**
 * Represents and abstract "Product" in the Abstract Factory pattern
 */
public interface Instance {

  enum Capacity {
    MICRO,
    SMALL,
    LARGE
  }

  void start();
  void attachStorage(Storage storage);
  void stop();
}
