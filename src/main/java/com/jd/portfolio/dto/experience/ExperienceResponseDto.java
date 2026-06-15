package com.jd.portfolio.dto.experience;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceResponseDto {

    private Long id;

    private String company;

    private String role;

    private String description;

    private Integer startYear;

    private Integer endYear;
}