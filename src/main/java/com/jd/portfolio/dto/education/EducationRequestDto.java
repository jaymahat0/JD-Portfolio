package com.jd.portfolio.dto.education;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Education request payload")
public class EducationRequestDto {

    @Schema(
            description = "Institution name",
            example = "National Institute of Technology Goa"
    )
    @NotBlank(message = "Institution name is required")
    @Size(max = 100)
    private String institution;

    @Schema(
            description = "Degree Name",
            example = "Bachelor of Technology"
    )
    @NotBlank(message = "Degree is required")
    @Size(max = 100)
    private String degree;

    @Schema(
            description = "Field of study",
            example = "Electrical and Electronics Engineering"
    )
    @NotBlank(message = "Field of study is required")
    @Size(max = 100)
    private String fieldOfStudy;

    @Schema(
            description = "Year of course start",
            example = "2023"
    )
    @NotNull(message = "Start year is required")
    @Min(value = 2004, message = "Start cannot be less than 2004")
    @Max(value = 2050, message = "Start Year must be a valid year")
    private Integer startYear;

    @Schema(
            description = "Year of course end",
            example = "2027"
    )
    @NotNull(message = "End year is required")
    @Min(value = 2004, message = "End Year cannot be less than 2004")
    @Max(value = 2050, message = "Start Year must be a valid year")
    private Integer endYear;

    @Schema(
            description = "Current CGPA",
            example = "8.50"
    )
    @NotNull(message = "CGPA is required")
    private Double cgpa;

    @Schema(
            description = "Description of the Education Field"
    )
    @NotBlank(message = "Description is required")
    @Size(max = 5000)
    private String description;
}