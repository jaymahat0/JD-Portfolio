package com.jd.portfolio.dto.contact;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Contact Message Response")
public class ContactMessageResponseDto {

    @Schema(
            description = "Contact Message record ID",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Sender's name",
            example = "Robert Jn."
    )
    private String name;

    @Schema(
            description = "Sender's email",
            example = "robertjn@hotmail.com"
    )
    private String email;

    @Schema(
            description = "Subject of the mail",
            example = "Hiring for SDE-2 role"
    )
    private String subject;

    @Schema(
            description = "Body of the mail"
    )
    private String message;

    @Schema(
            description = "Receiving date and time",
            example = "2026-08-17T15:06:06.848055"
    )
    private LocalDateTime createdAt;
}