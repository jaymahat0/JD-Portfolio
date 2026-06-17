package com.jd.portfolio.controller;

import com.jd.portfolio.dto.experience.ExperienceRequestDto;
import com.jd.portfolio.dto.experience.ExperienceResponseDto;
import com.jd.portfolio.service.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {

    private final ExperienceService experienceService;

    @GetMapping
    public List<ExperienceResponseDto> getAllExperiences() {
        return experienceService.getAllExperiences();
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