package com.nortoncommander.designpatterns.behavioral.chainofresponsibility.impl;

import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.api.LeaveRequestApprover;
import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.domain.LeaveRequest;

/**
 * Represents a concrete handler which handles/processes a request in the Chain of Responsibility pattern.
 */
public class Manager extends Employee {

  public Manager(LeaveRequestApprover nextApprover) {
    super("Manager", nextApprover);
  }

  @Override
  protected boolean processRequest(LeaveRequest request) {
    switch (request.getType()) {
      case SICK:
        approve(request);
        return true;
      case PAID_TIME_OFF:
        if (request.getNumberOfDays() <= 5) {
          approve(request);
          return true;
        }
    }

    return false;
  }
}
