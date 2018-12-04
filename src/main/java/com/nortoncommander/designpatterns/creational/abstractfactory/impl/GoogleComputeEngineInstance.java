package com.nortoncommander.designpatterns.creational.abstractfactory.impl;

import com.nortoncommander.designpatterns.creational.abstractfactory.api.Instance;
import com.nortoncommander.designpatterns.creational.abstractfactory.api.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a concrete product in a concrete set/family of products in the Abstract Factory pattern
 *
 * NOTE: Here this class represents a product in the family "Google Cloud Platform"
 */
public class GoogleComputeEngineInstance implements Instance {
  private static final Logger LOGGER = LoggerFactory.getLogger(GoogleComputeEngineInstance.class);

  public GoogleComputeEngineInstance(Capacity capacity) {
      LOGGER.info("Created Google Compute Engine instance with {} capacity", capacity);
  }

  @Override
  public void start() {
    LOGGER.info("Google Compute Engine instance started");
  }

  @Override
  public void attachStorage(Storage storage) {
    LOGGER.info("Attached {} to Google Compute Engine instance", storage);
  }

  @Override
  public void stop() {
    LOGGER.info("Google Compute Engine instance stopped");
  }

  @Override
  public String toString() {
    return "Google Compute Engine instance";
  }
}
