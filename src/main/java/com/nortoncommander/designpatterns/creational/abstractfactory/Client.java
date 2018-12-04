package com.nortoncommander.designpatterns.creational.abstractfactory;

import com.nortoncommander.designpatterns.creational.abstractfactory.api.Instance;
import com.nortoncommander.designpatterns.creational.abstractfactory.api.ResourceFactory;
import com.nortoncommander.designpatterns.creational.abstractfactory.api.Storage;
import com.nortoncommander.designpatterns.creational.abstractfactory.impl.AwsResourceFactory;
import com.nortoncommander.designpatterns.creational.abstractfactory.impl.GoogleResourceFactory;

public class Client {

  private ResourceFactory resourceFactory;

  /**
   * Client contains a reference to a concrete implementation of the resource factory.
   * The factory implementation can be changed so the client can work with objects from different family
   * created by a particular factory.
   */
  public Client(ResourceFactory resourceFactory) {
    this.resourceFactory = resourceFactory;
  }

  public static void main(String[] args) {
    Client awsClient = new Client(new AwsResourceFactory());
    Instance awsInstance = awsClient.createServer(Instance.Capacity.MICRO, 2048);

    awsInstance.start();

    // ... after some time ...

    awsInstance.stop();

    Client gcpClient = new Client(new GoogleResourceFactory());
    Instance gcpInstance = gcpClient.createServer(Instance.Capacity.LARGE, 32768);

    gcpInstance.start();

    // ... after some time ...

    gcpInstance.stop();
  }

  public Instance createServer(Instance.Capacity capacity, int storageInMB) {
    // Create products from the same "product family"
    Instance instance = this.resourceFactory.createInstance(capacity);
    Storage storage = this.resourceFactory.createStorage(storageInMB);
    instance.attachStorage(storage);

    return instance;
  }
}
