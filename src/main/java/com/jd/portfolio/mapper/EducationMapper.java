package com.jd.portfolio.mapper;

import com.jd.portfolio.dto.education.EducationRequestDto;
import com.jd.portfolio.dto.education.EducationResponseDto;
import com.jd.portfolio.entity.Education;

import java.util.Objects;

public final class EducationMapper {

    private EducationMapper(){

    }

    public static EducationResponseDto toResponse(Education education) {
        if(education == null) return null;

        return EducationResponseDto.builder()
                .id(education.getId())
                .institution(education.getInstitution())
                .fieldOfStudy(education.getFieldOfStudy())
                .degree(education.getDegree())
                .cgpa(education.getCgpa())
                .startYear(education.getStartYear())
                .endYear(education.getEndYear())
                .description(education.getDescription())
                .build();
    }

    public static Education toEntity(EducationRequestDto dto) {
        if(dto == null) return null;

        return Education.builder()
                .institution(dto.getInstitution())
                .fieldOfStudy(dto.getFieldOfStudy())
                .degree(dto.getDegree())
                .cgpa(dto.getCgpa())
                .startYear(dto.getStartYear())
                .endYear(dto.getEndYear())
                .description(dto.getDescription())
                .build();
    }

    public static void updateEntity(Education education,
                                    EducationRequestDto dto) {
        Objects.requireNonNull(education,"Education cannot be null");
        Objects.requireNonNull(dto,"EducationRequestDto cannot be null");

        education.setInstitution(dto.getInstitution());
        education.setDescription(dto.getDescription());
        education.setFieldOfStudy(dto.getFieldOfStudy());
        education.setCgpa(dto.getCgpa());
        education.setDegree(dto.getDegree());
        education.setStartYear(dto.getStartYear());
        education.setEndYear(dto.getEndYear());


    }
}
