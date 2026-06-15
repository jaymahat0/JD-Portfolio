package com.jd.portfolio.dto.skill;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillResponseDto {

    private Long id;

    private String name;

    private String category;

    private Integer proficiency;
}