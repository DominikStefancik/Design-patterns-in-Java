package com.nortoncommander.designpatterns.behavioral.observer;

/**
 * Represents an abstract observer
 */
public interface Observer {

  /**
   * This method represents a notification which is called by a Subject whenever its state changes.
   * The method can either only notify the observer that something changed with the subject it observes
   * (in that case the observer has to "ask" the subject what has changed).
   * Or it can notify the observer that something changed and also provides the information what changed
   *
   * NOTE: To improve the performance, we can define the update() method with an additional parameter
   * which will hold the property or event that has been changed. Then only those observers will be
   * notified which have been registered to observe the particular property or event (i.e. we don't have to
   * notify all observers but only the subset of them)
   */
  void updated(Subject subject);
}
