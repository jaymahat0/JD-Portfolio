package com.jd.portfolio.dto.contact;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactMessageRequestDto {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50)
    private String name;

    @Email
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Subject is required")
    @Size(max = 500)
    private String subject;

    @NotBlank(message = "Message is required")
    @Size(max = 50000)
    private String message;
}