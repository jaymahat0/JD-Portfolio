package com.jd.portfolio.service;

import com.jd.portfolio.dto.contact.ContactMessageRequestDto;
import com.jd.portfolio.dto.contact.ContactMessageResponseDto;

import java.util.List;

public interface ContactMessageService {

    ContactMessageResponseDto createContactMessage(ContactMessageRequestDto requestDto);

    ContactMessageResponseDto getContactMessageById(Long id);

    List<ContactMessageResponseDto> getAllContactMessages();

    void deleteContactMessage(Long id);
}