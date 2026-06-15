package com.jd.portfolio.service;

import com.jd.portfolio.dto.experience.ExperienceRequestDto;
import com.jd.portfolio.dto.experience.ExperienceResponseDto;

import java.util.List;

public interface ExperienceService {

    ExperienceResponseDto createExperience(ExperienceRequestDto requestDto);

    ExperienceResponseDto getExperienceById(Long id);

    List<ExperienceResponseDto> getAllExperiences();

    ExperienceResponseDto updateExperience(Long id, ExperienceRequestDto requestDto);

    void deleteExperience(Long id);
}