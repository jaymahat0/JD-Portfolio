package com.jd.portfolio.serviceimpl;

import com.jd.portfolio.dto.skill.SkillRequestDto;
import com.jd.portfolio.dto.skill.SkillResponseDto;
import com.jd.portfolio.entity.Skill;
import com.jd.portfolio.exception.ResourceNotFoundException;
import com.jd.portfolio.mapper.SkillMapper;
import com.jd.portfolio.repository.SkillRepository;
import com.jd.portfolio.service.SkillService;
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
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Override
    public SkillResponseDto createSkill(SkillRequestDto requestDto) {
        Skill skill = SkillMapper.toEntity(requestDto);
        Skill savedSkill = skillRepository.save(skill);
        return SkillMapper.toResponse(savedSkill);
    }

    @Override
    @Transactional(readOnly = true)
    public SkillResponseDto getSkillById(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Skill not found with id: " + id));

        return SkillMapper.toResponse(skill);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<SkillResponseDto> getAllSkills(Pageable pageable) {
        int defaultPageSize = 20;
        pageable = PageRequest.of(
                pageable.getPageNumber(),
                defaultPageSize,
                pageable.getSort()
        );

        Page<Skill> skills = skillRepository.findAll(pageable);

        return skills.map(SkillMapper::toResponse);
    }

    @Override
    public SkillResponseDto updateSkill(Long id, SkillRequestDto requestDto) {

        Skill skill = skillRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Skill not found with id: " + id));

        skill.setName(requestDto.getName());
        skill.setProficiency(requestDto.getProficiency());
        skill.setCategory(requestDto.getCategory());

        Skill updatedSkill = skillRepository.save(skill);

        return SkillMapper.toResponse(updatedSkill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }
}