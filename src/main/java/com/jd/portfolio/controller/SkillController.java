package com.jd.portfolio.controller;

import com.jd.portfolio.dto.skill.SkillRequestDto;
import com.jd.portfolio.dto.skill.SkillResponseDto;
import com.jd.portfolio.service.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping
    public List<SkillResponseDto> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{id}")
    public SkillResponseDto getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SkillResponseDto createSkill(
            @Valid @RequestBody SkillRequestDto requestDto) {

        return skillService.createSkill(requestDto);
    }

    @PutMapping("/{id}")
    public SkillResponseDto updateSkill(
            @PathVariable Long id,
            @Valid @RequestBody SkillRequestDto requestDto) {

        return skillService.updateSkill(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }
}