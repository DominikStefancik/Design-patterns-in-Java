package com.nortoncommander.designpatterns.behavioral.observer;

/**
 * A subject (also called Observable) in the Observer pattern.
 * The interface is used so one observer can observe multiple subjects.
 *
 * NOTE: If in our app there will always be only one subject, then we don't have to use an interface,
 * but can use a class for representing the subject instead.
 */
public interface Subject {

  /**
   * Registers an observer which want to be notified about the state changes of a Subject object
   */
  void attachObserver(Observer orderObserver);

  /**
   * Removes the given observer from the list of registered observers. The removed observer will no longer
   * be notified about the state changes of a Subject object
   */
  void detachObserver(Observer orderObserver);

  void notifyObservers();
}
