package com.nortoncommander.designpatterns.behavioral.observer.impl;

import com.nortoncommander.designpatterns.behavioral.observer.api.Observer;
import com.nortoncommander.designpatterns.behavioral.observer.api.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a concrete observer in the Observer pattern
 */
public class QuantityObserver implements Observer {
  private static final Logger LOGGER = LoggerFactory.getLogger(QuantityObserver.class);

  /**
   * Each observer doesn't know in what Subject implementation the change happened, so he has to
   * check its type and execute code according to that
   */
  @Override
  public void updated(Subject subject) {
    if (subject instanceof Order) {
      Order order = (Order) subject;

      LOGGER.info("Reacting to changes in the order with id {}", order.getId());

      /**
       * the observer doesn't know what changed, so he is asking the Subject about the change
       * he is interested in
       */
      int itemsCount = order.getItemsCount();

      if (itemsCount <= 5) {
        order.setShippingCost(10);
      } else {
        order.setShippingCost(10 + (itemsCount - 5) * 1.5);
      }
    }
  }
}
