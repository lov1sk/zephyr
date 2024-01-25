package com.lov1sk.Zephyr.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lov1sk.Zephyr.adapters.EmailSenderGateway;
import com.lov1sk.Zephyr.core.dtos.EmailSenderDTO;
import com.lov1sk.Zephyr.core.entities.Mail;
import com.lov1sk.Zephyr.core.use_cases.EmailSenderUseCase;

/**
 * Serviço que possui a funcionalidade de enviar emails,
 * ele é chamado pelo controller e tem como funcionalidade
 * acionar a infraestrutura da aplicação para enviar definitivamente o email
 * 
 * Essa serviço implementa o contrato definido no core do sistema.
 */
@Service
public class EmailSenderService implements EmailSenderUseCase{
  // Dependencia do gateway para a aws
  @Autowired
  private EmailSenderGateway emailSenderGateway;


  @Override
  public void sendMail(EmailSenderDTO data) {
    /**
     * Cria uma entidade para o email
     */
    var email = Mail.builder()
                    .body(data.body())
                    .subject(data.subject())
                    .to(data.to())
                    .build();

    /**
     * Aciona o gateway para que a classe que implementa
     * esse gateway seja acionada e envie de fato o email
     * 
     * No nosso caso, a classe dentro da camada de infra que
     * definitivamente faz implementação desse gateway é a
     * SesEmailSender
     */
    this.emailSenderGateway.sendMail(email);
  }
}
