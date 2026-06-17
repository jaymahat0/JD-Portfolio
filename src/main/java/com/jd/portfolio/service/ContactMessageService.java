package com.jd.portfolio.service;

import com.jd.portfolio.dto.contact.ContactMessageRequestDto;
import com.jd.portfolio.dto.contact.ContactMessageResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ContactMessageService {

    ContactMessageResponseDto createContactMessage(ContactMessageRequestDto requestDto);

    ContactMessageResponseDto getContactMessageById(Long id);

    Page<ContactMessageResponseDto> getAllContactMessages(Pageable pageable);

    void deleteContactMessage(Long id);
}