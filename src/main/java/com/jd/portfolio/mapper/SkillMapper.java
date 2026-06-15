package com.jd.portfolio.mapper;

import com.jd.portfolio.dto.skill.SkillRequestDto;
import com.jd.portfolio.dto.skill.SkillResponseDto;
import com.jd.portfolio.entity.Skill;

import java.util.Objects;

public final class SkillMapper {

    private SkillMapper() {
    }

    public static SkillResponseDto toResponse(Skill skill) {

        if (skill == null) {
            return null;
        }

        return SkillResponseDto.builder()
                .id(skill.getId())
                .name(skill.getName())
                .category(skill.getCategory())
                .proficiency(skill.getProficiency())
                .build();
    }

    public static Skill toEntity(SkillRequestDto dto) {

        if (dto == null) {
            return null;
        }

        return Skill.builder()
                .name(dto.getName())
                .category(dto.getCategory())
                .proficiency(dto.getProficiency())
                .build();
    }

    public static void updateEntity(Skill skill,
                                    SkillRequestDto dto) {

        Objects.requireNonNull(skill, "Skill cannot be null");
        Objects.requireNonNull(dto, "SkillRequestDto cannot be null");

        skill.setName(dto.getName());
        skill.setCategory(dto.getCategory());
        skill.setProficiency(dto.getProficiency());
    }
}