package com.jd.portfolio.service;

import com.jd.portfolio.dto.project.ProjectRequestDto;
import com.jd.portfolio.dto.project.ProjectResponseDto;

import java.util.List;

public interface ProjectService {

    ProjectResponseDto createProject(ProjectRequestDto requestDto);

    ProjectResponseDto getProjectById(Long id);

    List<ProjectResponseDto> getAllProjects();

    ProjectResponseDto updateProject(Long id, ProjectRequestDto requestDto);

    void deleteProject(Long id);
}