package com.jd.portfolio.serviceimpl;

import com.jd.portfolio.dto.contact.ContactMessageRequestDto;
import com.jd.portfolio.dto.contact.ContactMessageResponseDto;
import com.jd.portfolio.entity.ContactMessage;
import com.jd.portfolio.exception.ResourceNotFoundException;
import com.jd.portfolio.mapper.ContactMessageMapper;
import com.jd.portfolio.repository.ContactMessageRepository;
import com.jd.portfolio.service.ContactMessageService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ContactMessageServiceImpl implements ContactMessageService {

    private final ContactMessageRepository contactMessageRepository;

    @Override
    public ContactMessageResponseDto createContactMessage(ContactMessageRequestDto requestDto) {

        ContactMessage contactMessage =
                ContactMessageMapper.toEntity(requestDto);

        ContactMessage saved =
                contactMessageRepository.save(contactMessage);

        return ContactMessageMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public ContactMessageResponseDto getContactMessageById(Long id) {

        ContactMessage contactMessage =
                contactMessageRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Contact message not found with id: " + id));

        return ContactMessageMapper.toResponse(contactMessage);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ContactMessageResponseDto> getAllContactMessages(Pageable pageable) {
        int defaultPageSize = 5;
        pageable = PageRequest.of(
                pageable.getPageNumber(),
                defaultPageSize,
                pageable.getSort()
        );

        Page<ContactMessage> contactMessages = contactMessageRepository.findAll(pageable);

        return contactMessages.map(ContactMessageMapper::toResponse);
    }

    @Override
    public void deleteContactMessage(Long id) {
        contactMessageRepository.deleteById(id);
    }
}