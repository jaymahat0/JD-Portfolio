package com.jd.portfolio.service;

import com.jd.portfolio.dto.experience.ExperienceRequestDto;
import com.jd.portfolio.dto.experience.ExperienceResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExperienceService {

    ExperienceResponseDto createExperience(ExperienceRequestDto requestDto);

    ExperienceResponseDto getExperienceById(Long id);

    Page<ExperienceResponseDto> getAllExperiences(Pageable pageable);

    ExperienceResponseDto updateExperience(Long id, ExperienceRequestDto requestDto);

    void deleteExperience(Long id);
}