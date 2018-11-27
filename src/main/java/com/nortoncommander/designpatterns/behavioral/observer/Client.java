package com.nortoncommander.designpatterns.behavioral.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {

  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) {
    Order order = new Order("1");

    PriceObserver priceObserver = new PriceObserver();
    order.attachObserver(priceObserver);

    QuantityObserver quantityObserver = new QuantityObserver();
    order.attachObserver(quantityObserver);

    order.addItem(50);
    order.addItem(500);

    LOGGER.info("Order details: {}", order);
  }
}
