package com.lov1sk.Zephyr.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmailSenderFailureExceptionDTO {
 private String message;
 private String cause;
}
