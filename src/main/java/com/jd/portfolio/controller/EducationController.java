package com.jd.portfolio.controller;

import com.jd.portfolio.common.PersonalizedApiResponse;
import com.jd.portfolio.dto.education.EducationRequestDto;
import com.jd.portfolio.dto.education.EducationResponseDto;
import com.jd.portfolio.service.EducationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@Tag(
        name = "Education API",
        description = "Operations related to education records"
)
@RequiredArgsConstructor
public class EducationController {

    private final EducationService educationService;

    @GetMapping
    public ResponseEntity<PersonalizedApiResponse<List<EducationResponseDto>>> getAllEducations() {

        List<EducationResponseDto> all = educationService.getAllEducations();

        return ResponseEntity.ok()
                .body(new PersonalizedApiResponse<List<EducationResponseDto>>(
                        true,
                        "All educations fetched",
                        all
                ));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get education by id",
            description = "Return a single education record"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Education Found"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Education not found"
            )
    })
    public EducationResponseDto getEducationById(
            @Parameter(
                    description = "Education ID",
                    example = "1"
            )
            @PathVariable Long id) {
        return educationService.getEducationById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EducationResponseDto createEducation(
            @Valid @RequestBody EducationRequestDto requestDto) {

        return educationService.createEducation(requestDto);
    }

    @PutMapping("/{id}")
    public EducationResponseDto updateEducation(
            @PathVariable Long id,
            @Valid @RequestBody EducationRequestDto requestDto) {

        return educationService.updateEducation(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
    }
}
