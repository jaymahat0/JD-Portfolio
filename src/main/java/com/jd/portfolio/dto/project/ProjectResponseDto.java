package com.jd.portfolio.dto.project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectResponseDto {

    private Long id;

    private String title;

    private String description;

    private String githubUrl;

    private String liveUrl;

    private String imageUrl;

    private Boolean featured;
}