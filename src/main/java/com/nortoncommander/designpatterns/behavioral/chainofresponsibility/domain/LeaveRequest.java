package com.nortoncommander.designpatterns.behavioral.chainofresponsibility.domain;

import java.time.LocalDate;

/**
 * Represents a request in the Chain of Responsibility pattern.
 */
public class LeaveRequest {
  private LeaveType type;
  private LocalDate from;
  private LocalDate to;
  private String processedBy;
  private LeaveRequestStatus status;

  public LeaveRequest(LeaveType type, LocalDate from, LocalDate to) {
    this.type = type;
    this.from = from;
    this.to = to;
    this.status = LeaveRequestStatus.PENDING;
  }

  public LeaveType getType() {
    return type;
  }

  public void setType(LeaveType type) {
    this.type = type;
  }

  public LocalDate getFrom() {
    return from;
  }

  public void setFrom(LocalDate from) {
    this.from = from;
  }

  public LocalDate getTo() {
    return to;
  }

  public void setTo(LocalDate to) {
    this.to = to;
  }

  public String getProcessedBy() {
    return processedBy;
  }

  public void setProcessedBy(String processedBy) {
    this.processedBy = processedBy;
  }

  public LeaveRequestStatus getStatus() {
    return status;
  }

  public void setStatus(LeaveRequestStatus status) {
    this.status = status;
  }
}
