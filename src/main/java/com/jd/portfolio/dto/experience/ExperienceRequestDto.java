package com.jd.portfolio.dto.experience;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceRequestDto {

    private String company;

    private String role;

    private String location;

    private String description;

    private Integer startYear;

    private Integer endYear;

    private Boolean current;

}