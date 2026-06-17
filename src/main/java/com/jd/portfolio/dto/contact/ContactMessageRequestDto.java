package com.jd.portfolio.dto.contact;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Contact message request payload")
public class ContactMessageRequestDto {

    @Schema(
            description = "Sender's name",
            example = "Robert Jn."
    )
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50)
    private String name;

    @Schema(
            description = "Sender's email address",
            example = "robertjn@hotmail.com"
    )
    @Email
    @NotBlank(message = "Email is required")
    private String email;

    @Schema(
            description = "Subject of the mail",
            example = "Hiring for SDE-2 role"
    )
    @NotBlank(message = "Subject is required")
    @Size(max = 500)
    private String subject;

    @Schema(
            description = "Body of the mail"
    )
    @NotBlank(message = "Message is required")
    @Size(max = 50000)
    private String message;
}