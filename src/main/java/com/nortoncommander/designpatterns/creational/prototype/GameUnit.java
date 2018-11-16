package com.nortoncommander.designpatterns.creational.prototype;

import javafx.geometry.Point3D;

/**
 * This class represents an abstract prototype and defines the clone method
 */
public abstract class GameUnit implements Cloneable {
  private Point3D position;

  public GameUnit() {
    this.position = Point3D.ZERO;
  }

  public GameUnit(float x, float y, float z) {
    this.position = new Point3D(x, y, z);
  }

  /**
   * The method has been changed to public, so that we can clone a GameUnit object outside of the package.
   * It says it can throw the CloneNotSupportedException to emphasize that a child class doesn't have to
   * support cloning.
   */
  @Override
  public GameUnit clone() throws CloneNotSupportedException {
    // When cloning an object we need to have in mind whether we want its shallow copy or deep copy
    // clone() method of the Object class returns always a shallow copy of an object
    GameUnit gameUnit = (GameUnit) super.clone();
    gameUnit.initialize();

    return gameUnit;
  }

  /**
   * Resets the state of the current object
   */
  protected void initialize() {
    this.position = Point3D.ZERO;
    this.reset();
  }

  /**
   * This method is used by child classes to reset properties which are not defined in this class
   */
  protected abstract void reset();

  public Point3D getPosition() {
    return this.position;
  }

  public void move(Point3D direction, float distance) {
    Point3D finalMove = direction.normalize();
    finalMove = finalMove.multiply(distance);
    this.position = this.position.add(finalMove);
  }
}
