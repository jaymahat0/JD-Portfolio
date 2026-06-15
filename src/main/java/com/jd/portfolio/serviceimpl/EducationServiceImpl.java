package com.jd.portfolio.serviceimpl;

import com.jd.portfolio.dto.education.EducationRequestDto;
import com.jd.portfolio.dto.education.EducationResponseDto;
import com.jd.portfolio.entity.Education;
import com.jd.portfolio.mapper.EducationMapper;
import com.jd.portfolio.repository.EducationRepository;
import com.jd.portfolio.service.EducationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;

    @Override
    public EducationResponseDto createEducation(EducationRequestDto requestDto) {
        Education education = EducationMapper.toEntity(requestDto);
        Education savedEducation = educationRepository.save(education);
        return EducationMapper.toResponse(savedEducation);
    }

    @Override
    @Transactional(readOnly = true)
    public EducationResponseDto getEducationById(Long id) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Education not found with id: " + id));

        return EducationMapper.toResponse(education);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EducationResponseDto> getAllEducations() {
        return educationRepository.findAll()
                .stream()
                .map(EducationMapper::toResponse)
                .toList();
    }

    @Override
    public EducationResponseDto updateEducation(Long id, EducationRequestDto requestDto) {

        Education education = educationRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Education not found with id: " + id));

        education.setInstitution(requestDto.getInstitution());
        education.setDegree(requestDto.getDegree());
        education.setFieldOfStudy(requestDto.getFieldOfStudy());
        education.setCgpa(requestDto.getCgpa());
        education.setStartYear(requestDto.getStartYear());
        education.setEndYear(requestDto.getEndYear());

        Education updatedEducation = educationRepository.save(education);

        return EducationMapper.toResponse(updatedEducation);
    }

    @Override
    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }
}