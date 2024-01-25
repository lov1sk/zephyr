package com.lov1sk.Zephyr.core.dtos;

// DTO para simbolizar os dados enviados entre client -> controller -> service
public record EmailSenderDTO(String to, String subject, String body) {}
