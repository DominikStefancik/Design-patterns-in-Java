package com.nortoncommander.designpatterns.behavioral.chainofresponsibility.api;

import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.domain.LeaveRequest;

/**
 * Represents an abstract handler which handles/processes a request in the Chain of Responsibility pattern.
 */
public interface LeaveRequestApprover {

  /**
   * Processes a given request.
   *
   * If the handler cannot process the request, it passes the processing to another handler.
   *
   * NOTE: This method is necessary for handling request according to the Chain of Responsibility pattern
   * and has to be defined in the handler interface
   *
   * @param request incoming {@link LeaveRequest} which is to be processed
   */
  void processLeaveRequest(LeaveRequest request);

  /**
   * Returns the role of a person who approved a leave request.
   *
   * NOTE: This method is here optionally and doesn't have to be defined in the handler interface
   * according to the Chain of Responsibility pattern.
   *
   * @return the role of the leave request approver
   */
  String getApproverRole();
}
