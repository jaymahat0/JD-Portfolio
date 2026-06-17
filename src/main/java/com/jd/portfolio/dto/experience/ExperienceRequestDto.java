package com.jd.portfolio.dto.experience;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExperienceRequestDto {

    @NotBlank(message = "Company name is required")
    @Size(max = 200)
    private String company;

    @NotBlank(message = "Role is required")
    @Size(max = 100)
    private String role;

    @NotBlank(message = "Location is required")
    @Size(max = 50)
    private String location;

    @NotBlank(message = "Description is required")
    @Size(max = 5000)
    private String description;

    @NotNull(message = "Start year is required")
    @Min(value = 2023, message = "Start year must be at least 2023")
    @Max(value = 2050, message = "Start year must be a valid year")
    private Integer startYear;

    @NotNull(message = "End year is required")
    @Min(value = 2023, message = "End year must be at least 2023")
    @Max(value = 2050, message = "End year must be a valid year")
    private Integer endYear;

    private Boolean current = false;

}