package com.nortoncommander.designpatterns.creational.prototype;

import javafx.geometry.Point3D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) throws CloneNotSupportedException {
    Swordsman swordsman1 = new Swordsman();
    swordsman1.move(new Point3D(-10, 0,0), 20);
    swordsman1.attack();
    LOGGER.info("Original swordsman: {}", swordsman1.toString());

    Swordsman swordsman2 = (Swordsman) swordsman1.clone();
    LOGGER.info("Cloned swordsman: {}", swordsman2.toString());
  }
}
