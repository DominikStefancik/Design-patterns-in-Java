package com.nortoncommander.designpatterns.creational.objectpool.api;

/**
 * Represents a "Reusable" object which can be obtained/pooled from the Object Pool
 */
public interface Reusable {

  /**
   * Resets the state of the object. It should be called before the object is returned to the object pool,
   * because we want to ensure that the object has no "leftover" values before it is given to a client.
   */
  void reset();
}
