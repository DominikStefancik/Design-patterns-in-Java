package com.nortoncommander.designpatterns.creational.objectpool.impl;

import com.nortoncommander.designpatterns.creational.objectpool.api.Image;
import javafx.geometry.Point2D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a concrete "Reusable" in the Object Pool pattern.
 *
 * In this example this class represents a bitmap file which is stored on the disk
 */
public class Bitmap implements Image {
  private static final Logger LOGGER = LoggerFactory.getLogger(Bitmap.class);

  private Point2D location;
  private final String name;

  private final Byte[] content;

  public Bitmap(String name) {
    /* When we create a bitmap object we will set its name and content only once so we don't have to
       reset/reload it every time we return it to an object pool */
    this.name = name;
    this.content = getBitmapContent(name);
  }

  @Override
  public void draw() {
    LOGGER.info("Drawing '{}' at {}", name, location);
  }

  @Override
  public Point2D getLocation() {
    return location;
  }

  @Override
  public void setLocation(Point2D location) {
    this.location = location;
  }

  @Override
  public void reset() {
    // only location will be reset
    this.location = null;

    LOGGER.info("Bitmap '{}' has been reset", this.name);
  }

  /**
   * Expects a name of a file on the disk which content will be loaded and returned as an array of bytes.
   *
   * NOTE: This method is here only for demonstration purposes. It is not a part of the "Reusable" interface
   */
  private Byte[] getBitmapContent(String name) {
    return null;
  }
}
