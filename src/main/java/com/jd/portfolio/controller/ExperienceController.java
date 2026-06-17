package com.jd.portfolio.controller;

import com.jd.portfolio.dto.experience.ExperienceRequestDto;
import com.jd.portfolio.dto.experience.ExperienceResponseDto;
import com.jd.portfolio.service.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @GetMapping
    public Page<ExperienceResponseDto> getAllExperiences(
            @PageableDefault(page = 0,size = 5)
            Pageable pageable
    ) {
        return experienceService.getAllExperiences(pageable);
    }

    @GetMapping("/{id}")
    public ExperienceResponseDto getExperienceById(@PathVariable Long id) {
        return experienceService.getExperienceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ExperienceResponseDto createExperience(
            @Valid @RequestBody ExperienceRequestDto requestDto) {

        return experienceService.createExperience(requestDto);
    }

    @PutMapping("/{id}")
    public ExperienceResponseDto updateExperience(
            @PathVariable Long id,
            @Valid @RequestBody ExperienceRequestDto requestDto) {

        return experienceService.updateExperience(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
    }
}