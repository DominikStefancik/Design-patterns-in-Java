package com.nortoncommander.designpatterns.creational.prototype;

/**
 * This class represents a concrete prototype which supports cloning
 */
public class Swordsman extends GameUnit {
  private String state = "idle";

  public void attack() {
    this.state = "attacking";
  }

  @Override
  protected void reset() {
    this.state = "idle";
  }

  @Override
  public String toString() {
    return String.format("Swordsman %s at %s", state, getPosition());
  }
}
