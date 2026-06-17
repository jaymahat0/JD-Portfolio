package com.jd.portfolio.controller;

import com.jd.portfolio.dto.contact.ContactMessageRequestDto;
import com.jd.portfolio.dto.contact.ContactMessageResponseDto;
import com.jd.portfolio.service.ContactMessageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact-messages")
@RequiredArgsConstructor
@Tag(
        name = "Contact Message API",
        description = "Operations related to contact message"
)
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactMessageResponseDto createMessage(
            @Valid @RequestBody ContactMessageRequestDto requestDto) {

        return contactMessageService.createContactMessage(requestDto);
    }

    @GetMapping
    public Page<ContactMessageResponseDto> getAllMessages(
            @PageableDefault(size = 5, page = 0)
            Pageable pageable
    ) {
        return contactMessageService.getAllContactMessages(pageable);
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
