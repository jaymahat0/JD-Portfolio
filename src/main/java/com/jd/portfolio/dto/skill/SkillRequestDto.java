package com.jd.portfolio.dto.skill;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillRequestDto {

    @NotBlank
    private String name;

    private String category;

    private Integer proficiency;
}