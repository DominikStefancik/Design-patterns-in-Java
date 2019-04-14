package com.nortoncommander.designpatterns.behavioral.chainofresponsibility.impl;

import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.api.LeaveRequestApprover;
import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.domain.LeaveRequest;

/**
 * Represents an abstract handler which handles/processes a request in the Chain of Responsibility pattern.
 *
 * NOTE: We set the class abstract, because we don't want the client to work with employee, but with a concrete
 * approver.
 */
public abstract class Employee implements LeaveRequestApprover {

  private String role;
  private LeaveRequestApprover nextApprover;

  public Employee(String role, LeaveRequestApprover nextApprover) {
    this.role = role;
    this.nextApprover = nextApprover;
  }

  @Override
  public void processLeaveRequest(LeaveRequest request) {
    // if this handler is not able to process the given request, it will pass it to the next handler
    if (!processRequest(request) && nextApprover != null) {
      nextApprover.processLeaveRequest(request);
    }
  }

  /**
   * Processes a given request.
   *
   * @param request incoming {@link LeaveRequest} which is to be processed
   * @return true if the given leave request has been successfully process by this handler
   */
  protected abstract boolean processRequest(LeaveRequest request);

  @Override
  public String getApproverRole() {
    return role;
  }
}
