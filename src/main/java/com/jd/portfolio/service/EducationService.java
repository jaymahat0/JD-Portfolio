package com.jd.portfolio.service;

import com.jd.portfolio.dto.education.EducationRequestDto;
import com.jd.portfolio.dto.education.EducationResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EducationService {

    EducationResponseDto createEducation(EducationRequestDto requestDto);

    EducationResponseDto getEducationById(Long id);

    Page<EducationResponseDto> getAllEducations(Pageable pageable);

    EducationResponseDto updateEducation(Long id, EducationRequestDto requestDto);

    void deleteEducation(Long id);
}