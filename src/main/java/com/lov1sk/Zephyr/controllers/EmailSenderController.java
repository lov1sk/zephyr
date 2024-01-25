package com.lov1sk.Zephyr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lov1sk.Zephyr.application.EmailSenderService;
import com.lov1sk.Zephyr.core.dtos.EmailSenderDTO;
import com.lov1sk.Zephyr.core.dtos.EmailSenderFailureExceptionDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * Define que essa classe será um controller REST
 * e seu endpoint base sera "localhost:8080/app/mail"
 */
@RestController
@RequestMapping("/app/mail")
public class EmailSenderController {
  /**
   * Dependencia do serviço/caso de uso
   */
  @Autowired
  private EmailSenderService emailSenderService;


  /**
   * Rota [POST] que recebe de uma outra aplicação
   * a requisição para enviar emails.
   */
  @PostMapping()
  public ResponseEntity<Object> sendEmail(@RequestBody EmailSenderDTO body){
    try {
      /**
       * Chama o serviço/caso de uso para tentar enviar um email
       * e retorna em caso de sucesso, um status code 200 (ok)
       */
      this.emailSenderService.sendMail(body);
      return ResponseEntity.status(HttpStatus.OK).body(null);
    } catch (Exception e) {
      /**
       * Cria uma exception para ser retornada ao cliente
       * contendo a mensagem e a causa. 
       */
      var emailSendFailureException = EmailSenderFailureExceptionDTO.builder()
                                                                    .message(e.getMessage())
                                                                    .cause(e.getCause().toString())
                                                                    .build();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emailSendFailureException);
    }
  }
}
