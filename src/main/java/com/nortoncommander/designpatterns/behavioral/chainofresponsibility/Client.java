package com.nortoncommander.designpatterns.behavioral.chainofresponsibility;

import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.api.LeaveRequestApprover;
import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.domain.LeaveRequest;
import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.domain.LeaveType;
import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.impl.Director;
import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.impl.Manager;
import com.nortoncommander.designpatterns.behavioral.chainofresponsibility.impl.ProjectLead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class Client {

  private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

  public static void main(String[] args) {
    LeaveRequestApprover approver = createChainOfApprovers();
    LeaveRequest request = new LeaveRequest(LeaveType.SICK, LocalDate.of(2019, 1, 30), LocalDate.of(2019, 1, 31));
    approver.processLeaveRequest(request);
    logRequestProcessing(request);

    request = new LeaveRequest(LeaveType.PAID_TIME_OFF, LocalDate.of(2019, 1, 30), LocalDate.of(2019, 2, 3));
    approver.processLeaveRequest(request);
    logRequestProcessing(request);

    request = new LeaveRequest(LeaveType.LOSS_OF_PAY, LocalDate.of(2019, 1, 1), LocalDate.of(2019, 6, 1));
    approver.processLeaveRequest(request);
    logRequestProcessing(request);

  }

  /**
   * Creates a chain of handlers which can handle a request and returns the very first handler
   *
   * @return the first handler in the chain which will process a request
   */
  private static LeaveRequestApprover createChainOfApprovers() {
    // the director is the highest position in our example and there is no next approver
    final Director director = new Director(null);
    final Manager manager = new Manager(director);
    final ProjectLead projectLead = new ProjectLead(manager);

    return projectLead;
  }

  private static void logRequestProcessing(LeaveRequest request) {
    LOGGER.info("Leave request of type {} from {} to {} processed by {} with the status {}",
        request.getType(), request.getFrom(), request.getTo(), request.getProcessedBy(), request.getStatus());
  }
}
