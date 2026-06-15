package com.jd.portfolio.mapper;

import com.jd.portfolio.dto.contact.ContactMessageRequestDto;
import com.jd.portfolio.dto.contact.ContactMessageResponseDto;
import com.jd.portfolio.entity.ContactMessage;

import java.util.Objects;

public final class ContactMessageMapper {

    private ContactMessageMapper() {
    }

    public static ContactMessageResponseDto toResponse(ContactMessage message) {

        if (message == null) {
            return null;
        }

        return ContactMessageResponseDto.builder()
                .id(message.getId())
                .name(message.getName())
                .email(message.getEmail())
                .subject(message.getSubject())
                .message(message.getMessage())
                .createdAt(message.getCreatedAt())
                .build();
    }

    public static ContactMessage toEntity(ContactMessageRequestDto dto) {

        if (dto == null) {
            return null;
        }

        return ContactMessage.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .subject(dto.getSubject())
                .message(dto.getMessage())
                .build();
    }

    public static void updateEntity(ContactMessage message,
                                    ContactMessageRequestDto dto) {

        Objects.requireNonNull(message, "ContactMessage cannot be null");
        Objects.requireNonNull(dto, "ContactMessageRequestDto cannot be null");

        message.setName(dto.getName());
        message.setEmail(dto.getEmail());
        message.setSubject(dto.getSubject());
        message.setMessage(dto.getMessage());
    }
}