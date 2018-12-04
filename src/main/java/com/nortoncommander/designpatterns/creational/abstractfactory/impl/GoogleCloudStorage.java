package com.nortoncommander.designpatterns.creational.abstractfactory.impl;

import com.nortoncommander.designpatterns.creational.abstractfactory.api.Storage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a concrete product in a concrete set/family of products in the Abstract Factory pattern
 *
 * NOTE: Here this class represents a product in the family "Google Cloud Platform"
 */
public class GoogleCloudStorage implements Storage {
  private static final Logger LOGGER = LoggerFactory.getLogger(GoogleCloudStorage.class);

  public GoogleCloudStorage(int capacityInMB) {
    LOGGER.info("Allocated {} MB on Google Cloud storage", capacityInMB);
  }

  @Override
  public String getId() {
    return "gcpcs1";
  }

  @Override
  public String toString() {
    return "Google Cloud storage";
  }
}
