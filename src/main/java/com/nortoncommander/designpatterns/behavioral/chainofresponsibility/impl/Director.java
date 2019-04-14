package com.nortoncommander.designpatterns.behavioral.chainofresponsibility.impl;

import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.api.LeaveRequestApprover;
import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.domain.LeaveRequest;
import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.domain.LeaveType;

/**
 * Represents a concrete handler which handles/processes a request in the Chain of Responsibility pattern.
 */
public class Director extends Employee {

  public Director(LeaveRequestApprover nextApprover) {
    super("Director", nextApprover);
  }

  @Override
  protected boolean processRequest(LeaveRequest request) {
    if (LeaveType.LOSS_OF_PAY.equals(request.getType())) {
      this.approve(request);
      return true;
    }

    return false;
  }
}
