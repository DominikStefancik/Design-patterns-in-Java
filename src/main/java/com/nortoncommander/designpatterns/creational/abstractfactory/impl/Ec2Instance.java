package com.nortoncommander.designpatterns.creational.abstractfactory.impl;

import com.nortoncommander.designpatterns.creational.abstractfactory.api.Instance;
import com.nortoncommander.designpatterns.creational.abstractfactory.api.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a concrete product in a concrete set/family of products in the Abstract Factory pattern
 *
 * NOTE: Here this class represents a product in the family "Amazon Web Services"
 */
public class Ec2Instance implements Instance {
  private static final Logger LOGGER = LoggerFactory.getLogger(Ec2Instance.class);

  public Ec2Instance(Capacity capacity) {
      LOGGER.info("Created Ec2Instance with {} capacity", capacity);
  }

  @Override
  public void start() {
    LOGGER.info("Ec2Instance started");
  }

  @Override
  public void attachStorage(Storage storage) {
    LOGGER.info("Attached {} to Ec2Instance", storage);
  }

  @Override
  public void stop() {
    LOGGER.info("Ec2Instance stopped");
  }

  @Override
  public String toString() {
    return "Ec2Instance";
  }
}
