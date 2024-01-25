package com.lov1sk.Zephyr.core.exceptions;

/**
 * Exception para quando o envio de emails falhar.
 */
public class SendEmailFailureException extends RuntimeException{
  public SendEmailFailureException(String message) {
      super(message);
  }
  public SendEmailFailureException(String message, Throwable cause) {
    super(message,cause);
  } 
}
