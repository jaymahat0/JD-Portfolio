package com.jd.portfolio.service;

import com.jd.portfolio.dto.education.EducationRequestDto;
import com.jd.portfolio.dto.education.EducationResponseDto;

import java.util.List;

public interface EducationService {

    EducationResponseDto createEducation(EducationRequestDto requestDto);

    EducationResponseDto getEducationById(Long id);

    List<EducationResponseDto> getAllEducations();

    EducationResponseDto updateEducation(Long id, EducationRequestDto requestDto);

    void deleteEducation(Long id);
}