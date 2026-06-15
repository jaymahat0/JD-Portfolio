package com.jd.portfolio.dto.project;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectRequestDto {

    @NotBlank
    private String title;

    private String description;

    private String githubUrl;

    private String liveUrl;

    private String imageUrl;

    private Boolean featured;
}