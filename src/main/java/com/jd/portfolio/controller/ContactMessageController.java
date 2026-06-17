package com.jd.portfolio.controller;

import com.jd.portfolio.dto.contact.ContactMessageRequestDto;
import com.jd.portfolio.dto.contact.ContactMessageResponseDto;
import com.jd.portfolio.service.ContactMessageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-messages")
@RequiredArgsConstructor
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactMessageResponseDto createMessage(
            @Valid @RequestBody ContactMessageRequestDto requestDto) {

        return contactMessageService.createContactMessage(requestDto);
    }

    @GetMapping
    public List<ContactMessageResponseDto> getAllMessages() {
        return contactMessageService.getAllContactMessages();
    }

    @GetMapping("/{id}")
    public ContactMessageResponseDto getMessageById(
            @PathVariable Long id) {

        return contactMessageService.getContactMessageById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMessage(@PathVariable Long id) {
        contactMessageService.deleteContactMessage(id);
    }
}
