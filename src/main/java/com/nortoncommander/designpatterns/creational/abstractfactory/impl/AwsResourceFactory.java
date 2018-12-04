package com.nortoncommander.designpatterns.creational.abstractfactory.impl;

import com.nortoncommander.designpatterns.creational.abstractfactory.api.Instance;
import com.nortoncommander.designpatterns.creational.abstractfactory.api.ResourceFactory;
import com.nortoncommander.designpatterns.creational.abstractfactory.api.Storage;

/**
 * Represents a concrete factory with methods defined for each object type
 *
 * NOTE: This factory creates products in the family "Amazon Web Services"
 */
public class AwsResourceFactory implements ResourceFactory {

  @Override
  public Instance createInstance(Instance.Capacity capacity) {
    return new Ec2Instance(capacity);
  }

  @Override
  public Storage createStorage(int capacityInMB) {
    return new S3Storage(capacityInMB);
  }
}
