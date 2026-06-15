package com.jd.portfolio.dto.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactMessageRequestDto {

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String subject;

    @NotBlank
    private String message;
}