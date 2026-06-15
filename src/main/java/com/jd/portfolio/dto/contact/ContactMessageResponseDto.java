package com.jd.portfolio.dto.contact;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactMessageResponseDto {

    private Long id;

    private String name;

    private String email;

    private String subject;

    private String message;

    private LocalDateTime createdAt;
}