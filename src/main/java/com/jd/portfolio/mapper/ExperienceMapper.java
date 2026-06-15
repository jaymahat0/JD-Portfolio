package com.jd.portfolio.mapper;

import com.jd.portfolio.dto.experience.ExperienceRequestDto;
import com.jd.portfolio.dto.experience.ExperienceResponseDto;
import com.jd.portfolio.entity.Experience;

import java.util.Objects;

public final class ExperienceMapper {

    private ExperienceMapper() {
    }

    public static ExperienceResponseDto toResponse(Experience experience) {

        if (experience == null) {
            return null;
        }

        return ExperienceResponseDto.builder()
                .id(experience.getId())
                .company(experience.getCompany())
                .role(experience.getRole())
                .description(experience.getDescription())
                .startYear(experience.getStartDate())
                .endYear(experience.getEndDate())
                .build();
    }

    public static Experience toEntity(ExperienceRequestDto dto) {

        if (dto == null) {
            return null;
        }

        return Experience.builder()
                .company(dto.getCompany())
                .role(dto.getRole())
                .description(dto.getDescription())
                .startDate(dto.getStartYear())
                .endDate(dto.getEndYear())
                .build();
    }

    public static void updateEntity(Experience experience,
                                    ExperienceRequestDto dto) {

        Objects.requireNonNull(experience, "Experience cannot be null");
        Objects.requireNonNull(dto, "ExperienceRequestDto cannot be null");

        experience.setCompany(dto.getCompany());
        experience.setRole(dto.getRole());
        experience.setDescription(dto.getDescription());
        experience.setStartDate(dto.getStartYear());
        experience.setEndDate(dto.getEndYear());
    }
}