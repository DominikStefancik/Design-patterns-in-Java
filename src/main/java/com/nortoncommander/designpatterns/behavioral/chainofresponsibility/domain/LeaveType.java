package com.nortoncommander.designpatterns.behavioral.chainofresponsibility.domain;

/**
 * Represent a type of leave which can be sent a request.
 */
public enum LeaveType {
  SICK,
  PAID_TIME_OFF,
  LOSS_OF_PAY // type of leave for unpaid period
}
