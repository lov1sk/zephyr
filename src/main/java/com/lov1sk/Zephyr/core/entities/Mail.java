package com.lov1sk.Zephyr.core.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade para simbolizar um email
 * dentro da nosso sistema
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
  private String to;
  private String subject;
  private String body;
}
