package com.jd.portfolio.serviceimpl;

import com.jd.portfolio.dto.experience.ExperienceRequestDto;
import com.jd.portfolio.dto.experience.ExperienceResponseDto;
import com.jd.portfolio.entity.Experience;
import com.jd.portfolio.exception.ResourceNotFoundException;
import com.jd.portfolio.mapper.ExperienceMapper;
import com.jd.portfolio.repository.ExperienceRepository;
import com.jd.portfolio.service.ExperienceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;

    @Override
    public ExperienceResponseDto createExperience(ExperienceRequestDto requestDto) {
        if(requestDto.getEndYear() < requestDto.getStartYear()) {
            throw new IllegalArgumentException("End year cannot be earlier than start year");
        }
        Experience experience = ExperienceMapper.toEntity(requestDto);
        return ExperienceMapper.toResponse(
                experienceRepository.save(experience)
        );
    }

    @Override
    @Transactional(readOnly = true)
    public ExperienceResponseDto getExperienceById(Long id) {
        return ExperienceMapper.toResponse(
                experienceRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException("Experience not found with id: " + id))
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ExperienceResponseDto> getAllExperiences(Pageable pageable) {
        int defaultSize = 5;
        pageable = PageRequest.of(
                pageable.getPageNumber(),
                defaultSize,
                pageable.getSort()
        );

        Page<Experience> experiences = experienceRepository.findAll(pageable);

        return experiences.map(ExperienceMapper::toResponse);
    }

    @Override
    public ExperienceResponseDto updateExperience(Long id, ExperienceRequestDto requestDto) {

        if(requestDto.getEndYear() < requestDto.getStartYear()) {
            throw new IllegalArgumentException("End year cannot be earlier than start year");
        }

        Experience existing = experienceRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Experience not found with id: " + id));

        existing.setCompany(requestDto.getCompany());
        existing.setRole(requestDto.getRole());
        existing.setLocation(requestDto.getLocation());
        existing.setStartDate(requestDto.getStartYear());
        existing.setEndDate(requestDto.getEndYear());
        existing.setCurrent(requestDto.getCurrent());
        existing.setDescription(requestDto.getDescription());

        Experience updatedExperience= experienceRepository.save(existing);


        return ExperienceMapper.toResponse(updatedExperience);
    }

    @Override
    public void deleteExperience(Long id) {
        experienceRepository.deleteById(id);
    }
}