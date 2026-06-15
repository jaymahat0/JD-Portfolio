package com.jd.portfolio.service;

import com.jd.portfolio.dto.skill.SkillRequestDto;
import com.jd.portfolio.dto.skill.SkillResponseDto;

import java.util.List;

public interface SkillService {

    SkillResponseDto createSkill(SkillRequestDto requestDto);

    SkillResponseDto getSkillById(Long id);

    List<SkillResponseDto> getAllSkills();

    SkillResponseDto updateSkill(Long id, SkillRequestDto requestDto);

    void deleteSkill(Long id);
}