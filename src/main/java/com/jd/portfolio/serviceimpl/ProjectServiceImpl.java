package com.jd.portfolio.serviceimpl;

import com.jd.portfolio.dto.project.ProjectRequestDto;
import com.jd.portfolio.dto.project.ProjectResponseDto;
import com.jd.portfolio.entity.Project;
import com.jd.portfolio.exception.ResourceNotFoundException;
import com.jd.portfolio.mapper.ProjectMapper;
import com.jd.portfolio.repository.ProjectRepository;
import com.jd.portfolio.service.ProjectService;
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
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public ProjectResponseDto createProject(ProjectRequestDto requestDto) {
        Project project = ProjectMapper.toEntity(requestDto);
        Project savedProject = projectRepository.save(project);
        return ProjectMapper.toResponse(savedProject);
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectResponseDto getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found with id: " + id));

        return ProjectMapper.toResponse(project);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ProjectResponseDto> getAllProjects(Pageable pageable) {
        int defaultPageSize = 5;
        pageable = PageRequest.of(
                pageable.getPageNumber(),
                defaultPageSize,
                pageable.getSort()
        );

        Page<Project> projects = projectRepository.findAll(pageable);

        return projects.map(ProjectMapper::toResponse);
    }

    @Override
    public ProjectResponseDto updateProject(Long id, ProjectRequestDto requestDto) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found with id: " + id));

        project.setTitle(requestDto.getTitle());
        project.setDescription(requestDto.getDescription());
        project.setGithubUrl(requestDto.getGithubUrl());
        project.setLiveUrl(requestDto.getLiveUrl());
        project.setImageUrl(requestDto.getImageUrl());
        project.setFeatured(requestDto.getFeatured());

        Project updatedProject = projectRepository.save(project);

        return ProjectMapper.toResponse(updatedProject);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}