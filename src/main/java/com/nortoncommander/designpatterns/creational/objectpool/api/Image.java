package com.nortoncommander.designpatterns.creational.objectpool.api;

import javafx.geometry.Point2D;

/**
 * Represents an abstract "Reusable" in the Object Pool pattern
 *
 * In this concrete example, Image is an object which will be printed out or shown on the screen
 */
public interface Image extends Reusable {

  void draw();
  Point2D getLocation();
  void setLocation(Point2D location);
}
