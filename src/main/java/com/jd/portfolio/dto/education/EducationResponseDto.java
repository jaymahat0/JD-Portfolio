package com.jd.portfolio.dto.education;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Education Response")
public class EducationResponseDto {

    @Schema(
            description = "Education Record ID",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "Institution Name",
            example = "National Institute of Technology Goa"
    )
    private String institution;

    @Schema(
            description = "Name of Degree",
            example = "Bachelor of Technology"
    )
    private String degree;

    @Schema(
            description = "Field of Study",
            example = "Electrical and Electronics Engineering"
    )
    private String fieldOfStudy;

    @Schema(
            description = "Year of course Start",
            example = "2023"
    )
    private Integer startYear;

    @Schema(
            description = "Year of course End",
            example = "2027"
    )
    private Integer endYear;

    @Schema(
            description = "Current CGPA",
            example = "8.50"
    )
    private Double cgpa;

    @Schema(
            description = "Description of the course"
    )
    private String description;
}