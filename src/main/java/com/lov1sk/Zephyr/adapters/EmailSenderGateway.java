package com.lov1sk.Zephyr.adapters;

import com.lov1sk.Zephyr.core.entities.Mail;

/** 
 * Interface criada para ser um contrato de adaptação
 * entre a camada de application <-> Infraesctructure
 * 
 * Ou seja, é uma interface que é implementada pela camada
 * que de infraestrutura (neste caso a AWS SES) que fará
 * definitivamente o envio de emails
 *
 */
public interface EmailSenderGateway {
  void sendMail(Mail mail);
}
