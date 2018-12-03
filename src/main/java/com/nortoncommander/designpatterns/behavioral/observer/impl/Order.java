package com.nortoncommander.designpatterns.behavioral.observer.impl;

import com.nortoncommander.designpatterns.behavioral.observer.api.Observer;
import com.nortoncommander.designpatterns.behavioral.observer.api.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * A concrete subject in the Observer pattern
 * Attributes "itemsCost" and "itemsCount" represent a state of an order
 */
public class Order implements Subject {
  private static final Logger LOGGER = LoggerFactory.getLogger(Order.class);

  private final String id;

  // cost of all items
  private double itemsCost;
  private int itemsCount;

  private double discount;
  private double shippingCost;

  // a collection of registered observers
  private final List<Observer> observers;

  public Order(String id) {
    this.id = id;
    this.observers = new ArrayList<>();
  }

  /**
   * Registers an observer which want to be notified about the state changes of an Order object
   */
  public void attachObserver(Observer orderObserver) {
    observers.add(orderObserver);
  }

  /**
   * Removes the given observer from the list of registered observers. The removed observer will no longer
   * be notified about the state changes of an Order object
   */
  public void detachObserver(Observer orderObserver) {
    observers.remove(orderObserver);
  }

  public void notifyObservers() {
    LOGGER.info("The order with id {} changed, notifying all registered observers", id);
    observers.forEach(observer -> observer.updated(this));
  }

  public String getId() {
    return id;
  }

  public double getTotal() {
    return itemsCost - discount + shippingCost;
  }

  public void addItem(double price) {
    itemsCost += price;
    itemsCount++;
    notifyObservers();
  }

  public void removeItem(double price) {
    itemsCost -= price;
    itemsCount--;
    notifyObservers();
  }

  public int getItemsCount() {
    return itemsCount;
  }

  public double getItemsCost() {
    return itemsCost;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {

    /**
     * Be careful not to call the notification method in all setter methods, otherwise you might end in
     * an infinite loop. Put notification to the methods where only those attributes change which
     * are important for the observers.
     */
    this.discount = discount;
  }

  public double getShippingCost() {
    return shippingCost;
  }

  public void setShippingCost(double shippingCost) {
    this.shippingCost = shippingCost;
  }

  @Override
  public String toString() {
    return "Order {" +
        "id=" + id +
        ", itemsCost=" + itemsCost +
        ", itemsCount=" + itemsCount +
        ", discount=" + discount +
        ", shippingCost=" + shippingCost +
        "}";
  }
}
