package com.jd.portfolio;

import com.jd.portfolio.controller.EducationController;
import com.jd.portfolio.dto.education.EducationRequestDto;
import com.jd.portfolio.dto.education.EducationResponseDto;
import com.jd.portfolio.service.EducationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EducationTest {

    @Autowired
    private EducationService educationService;

    @Test
    public void addEducation() {
        EducationRequestDto educationRequestDto = EducationRequestDto.builder()
                .institution("National Institute of Technology")
                .fieldOfStudy("Electrical and Electronics Engineering")
                .degree("B.Tech")
                .cgpa(8.56)
                .startYear(2023)
                .endYear(2027)
                .description("Good")
                .build();

        EducationResponseDto educationResponseDto = educationService.createEducation(educationRequestDto);

        System.out.println(educationResponseDto);
    }
}
