/*
 * Copyright (c) 2016 Richik Sinha Choudhury and Nick Dimitrov
 */

package com.bankofjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Richik SC and NickDim on 5/9/2016.
 */

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class CustomerIsInvalidException extends Exception {
  private CustomerIsInvalidException.Reason reason;

  public CustomerIsInvalidException(CustomerIsInvalidException.Reason reason) {
    super();
    this.reason = reason;
  }

  public CustomerIsInvalidException(CustomerIsInvalidException.Reason reason, String msg) {
    super(msg);
    this.reason = reason;
  }

  public CustomerIsInvalidException.Reason getReason() {
    return reason;
  }

  @Override
  public String toString() {
    String reasonMessage = new String();
    switch (getReason()) {
      case IS_UNDERAGE:
        reasonMessage = "Customer is underage.";
        break;
      case NOT_ENOUGH_CREDIT:
        reasonMessage = "Customer's credit score is too low.";
        break;
      case OTHER:
        reasonMessage = "";
        break;
    }
    return reasonMessage + super.toString();
  }

  public static enum Reason {
    IS_UNDERAGE, NOT_ENOUGH_CREDIT, OTHER
  }


}
