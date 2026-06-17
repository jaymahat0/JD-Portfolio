package com.jd.portfolio.service;

import com.jd.portfolio.dto.project.ProjectRequestDto;
import com.jd.portfolio.dto.project.ProjectResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectResponseDto createProject(ProjectRequestDto requestDto);

    ProjectResponseDto getProjectById(Long id);

    Page<ProjectResponseDto> getAllProjects(Pageable pageable);

    ProjectResponseDto updateProject(Long id, ProjectRequestDto requestDto);

    void deleteProject(Long id);
}