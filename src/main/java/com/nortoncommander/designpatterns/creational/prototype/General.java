package com.nortoncommander.designpatterns.creational.prototype;

/**
 * This class represents a concrete prototype which doesn't support cloning
 */
public class General extends GameUnit {
  private String state = "idle";

  public void boostMorale() {
    this.state = "MoraleBoost";
  }

  @Override
  public GameUnit clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Generals are unique and cannot be cloned");
  }

  @Override
  protected void reset() {
    throw new UnsupportedOperationException("Reset not supported");
  }

  @Override
  public String toString() {
    return String.format("General %s at %s", state, getPosition());
  }
}
