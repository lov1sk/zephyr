package com.lov1sk.Zephyr.infra.ses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import com.lov1sk.Zephyr.adapters.EmailSenderGateway;
import com.lov1sk.Zephyr.core.entities.Mail;
import com.lov1sk.Zephyr.core.exceptions.SendEmailFailureException;

@Service
public class SesEmailSender implements EmailSenderGateway {
  /**
   * Dependencia da AWS SES para envio de emails
   */
  @Autowired
  private AmazonSimpleEmailService amazonSimpleEmailService;
  
  @Override
  public void sendMail(Mail mail) {
    /**
     * Cria instancias para o destinatario e a mensagem e si
     */
    var emailRequestDestination = new Destination().withToAddresses(mail.getTo());
    var emailRequestMessage = new Message().withSubject(new Content(mail.getSubject()))
                                           .withBody(new Body().withText(new Content(mail.getBody())));
    /**
     * Cria uma requisição para o client SES enviar o email
     */
    SendEmailRequest emailRequest = new SendEmailRequest().withSource("lucassantana00@gmail.com")
                                                          .withDestination(emailRequestDestination)
                                                          .withMessage(emailRequestMessage);
 

    try {
      this.amazonSimpleEmailService.sendEmail(emailRequest);
    } catch (AmazonServiceException ex) {
      throw new SendEmailFailureException("Failure while sending email",ex);
    }
                                                        }
}
