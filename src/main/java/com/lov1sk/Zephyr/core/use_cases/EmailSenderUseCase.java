package com.lov1sk.Zephyr.core.use_cases;

import com.lov1sk.Zephyr.core.dtos.EmailSenderDTO;

/** 
 * Interface que define um contrato que o 
 * serviço (caso de uso) implementará
 */
public interface EmailSenderUseCase {
  void sendMail(EmailSenderDTO data);
}
