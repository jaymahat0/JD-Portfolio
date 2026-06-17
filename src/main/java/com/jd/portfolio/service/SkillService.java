package com.jd.portfolio.service;

import com.jd.portfolio.dto.skill.SkillRequestDto;
import com.jd.portfolio.dto.skill.SkillResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;

import java.util.List;

public interface SkillService {

    SkillResponseDto createSkill(SkillRequestDto requestDto);

    SkillResponseDto getSkillById(Long id);

    Page<SkillResponseDto> getAllSkills(Pageable pageable);

    SkillResponseDto updateSkill(Long id, SkillRequestDto requestDto);

    void deleteSkill(Long id);
}