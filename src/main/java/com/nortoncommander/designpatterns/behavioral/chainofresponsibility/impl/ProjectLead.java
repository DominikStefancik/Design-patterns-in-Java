package com.nortoncommander.designpatterns.behavioral.chainofresponsibility.impl;

import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.api.LeaveRequestApprover;
import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.domain.LeaveRequest;
import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.domain.LeaveType;

/**
 * Represents a concrete handler which handles/processes a request in the Chain of Responsibility pattern.
 */
public class ProjectLead extends Employee {

  public ProjectLead(LeaveRequestApprover nextApprover) {
    super("Project Lead", nextApprover);
  }

  @Override
  protected boolean processRequest(LeaveRequest request) {
    // approve only if type is SICK and duration is less than or equal to 2 days
    if (LeaveType.SICK.equals(request.getType()) && request.getNumberOfDays() <= 2) {
      this.approve(request);
      return true;
    }

    return false;
  }
}
