package com.jd.portfolio.controller;

import com.jd.portfolio.dto.education.EducationRequestDto;
import com.jd.portfolio.dto.education.EducationResponseDto;
import com.jd.portfolio.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @GetMapping
    public List<EducationResponseDto> getAllEducations() {
        return educationService.getAllEducations();
    }

    @GetMapping("/{id}")
    public EducationResponseDto getEducationById(@PathVariable Long id) {
        return educationService.getEducationById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EducationResponseDto createEducation(
            @RequestBody EducationRequestDto requestDto) {

        return educationService.createEducation(requestDto);
    }

    @PutMapping("/{id}")
    public EducationResponseDto updateEducation(
            @PathVariable Long id,
            @RequestBody EducationRequestDto requestDto) {

        return educationService.updateEducation(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
    }
}
